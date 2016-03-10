package com.tothenew.linkshare.resource

import com.tothenew.linkshare.user.User
import grails.validation.ValidationException

class ResourceRatingController {

    def save(int id,int score) {
        Resource resource=Resource.get(id)
        User user=session.user
        ResourceRating resourceRating=ResourceRating.findOrCreateByRatedByAndResource( user,resource)
        try{
            resourceRating.score=score
            resourceRating.save(failOnError: true)
            flash.message="resource resource has been saved"
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
