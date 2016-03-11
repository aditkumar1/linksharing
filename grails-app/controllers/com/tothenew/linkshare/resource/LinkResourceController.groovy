package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.user.User
import grails.validation.ValidationException

class LinkResourceController extends ResourceController {
    def save() {
        try{
            User user=session?.user
            Topic topic=Topic.load(params.topicId)
            LinkResource linkResource=new LinkResource(url:params.url,description: params.description,topic: topic,createdBy: user)
            linkResource.save(failOnError: true)
            addToReadingItems(linkResource)
            flash.message="link resource has been saved"
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
}
