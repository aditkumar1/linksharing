package com.tothenew.linkshare.resource

import grails.validation.ValidationException

class LinkResourceController {

    def save(LinkResource linkResource) {
        try{
            linkResource.save(failOnError: true)
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
