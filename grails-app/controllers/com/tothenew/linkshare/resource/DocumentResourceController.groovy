package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.user.User
import grails.transaction.Transactional
import grails.validation.ValidationException
import org.springframework.web.multipart.MultipartFile

class DocumentResourceController extends ResourceController {
    @Transactional
    def save() {
        try{
            MultipartFile file = params.file
            String extension="."+file.originalFilename.tokenize('.').last()
            String folderPath=grailsApplication.config.linksharing.documents.folderPath
            File directory=new File(folderPath)
            String fullPath = folderPath +DocumentResource.generateUID()+extension
            if( !directory.exists() ) {
                directory.mkdirs()
            }
            if(file.empty) {
                flash.message = "File cannot be empty"
            } else {
                User user=session?.user
                Topic topic=Topic.get(params.topicId)
                DocumentResource documentResource=new DocumentResource(filePath: fullPath,contentType: file.contentType ,description: params.description,topic: topic,createdBy: user)
                documentResource.contentType= file.contentType
                documentResource.save(failOnError: true)
                def ctx = startAsync()
                ctx.start {
                    addToReadingItems(documentResource)
                    ctx.complete()
                }
                flash.message="link resource has been saved"
                file.transferTo(new File(fullPath))
            }
        }
        catch(ValidationException ve){
            flash.error=ve.toString()
            redirect(controller: "user",action: "index")
        }
        catch(Exception ex){
            flash.error=ex.toString()
            redirect(controller: "user",action: "index")
        }

    }
    def download(long id){
        DocumentResource documentResource=DocumentResource.get(id)
        User user=session.user
        if(documentResource&&documentResource.topic.canViewedBy(user)){
            def file = new File(documentResource.filePath)
            if (file.exists()) {
                response.setContentType("application/pdf")
                response.setHeader("Content-disposition", "attachment; filename=${file.name}")
                response.outputStream << file.bytes
                response.outputStream.flush()
            }
        }
        else{
            flash.error="Resource not found or resource not accessible"
        }
    }
}
