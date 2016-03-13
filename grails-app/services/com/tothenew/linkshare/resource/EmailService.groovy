package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.EmailDTO
import grails.transaction.Transactional

@Transactional
class EmailService {

    def mailService
    def sendMail(EmailDTO emailDTO)
    {
        sendMail{
            async true
            to emailDTO.to.tokenize(";")
            subject emailDTO.subject
            if(emailDTO.content)
                body emailDTO.content
            else
                body(view:emailDTO.view,model:emailDTO.model)
        }
    }

}
