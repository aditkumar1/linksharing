package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.topic.Visibility
import com.tothenew.linkshare.user.Subscription
import com.tothenew.linkshare.user.User
import grails.converters.JSON
import grails.validation.ValidationException

class ResourceController {
    def grailsApplication
    protected void addToReadingItems(Resource resource){
        try {
                Subscription.findAllByTopic(resource.topic).each{
                    new ReadingItem(user: it.subscribedBy,resource: resource,isRead: false).save(failOnError: true)
            }
        }
        catch (ValidationException vx){
            flash.error=vx.toString()
        }
        catch(Exception ex){
            flash.error=ex.toString()
            throw ex
        }
    }
    def delete(int id) {
        User user= session.user
        try {
            Resource resource=Resource.load(id)
            if(user.canDeleteRsourceOrTopic(resource)){
                resource.delete(flush:true)
                flash.message= "Resource Deleted -"+resource.description
                redirect(controller: "user",action: "index")
            }
        }
        catch(Exception e){
            flash.error=e.toString()
            redirect(controller: "user",action: "index")
        }
    }
    def updateResourceDescription(long id,String description)
    {
        Map jsonObject = [:]
        Resource resource = Resource.read(id)
        if(resource)
        {
            resource.description = description
            try {
                resource.save(failOnError: true,flush: true)
                jsonObject.message = "Resource Description Updated"
            }
            catch (Exception ex){
                jsonObject.message = "Resource Description Could not be Updated"
            }
        }
        else {
            jsonObject.message = "Cannot find resource"
        }
        render jsonObject as JSON
    }
    def search(ResourceSearchCO resourceSearchCo){
        if(resourceSearchCo.q){
            resourceSearchCo.visibility=Visibility.PUBLIC
            render Resource.search(resourceSearchCo).list()
        }
        else {
            render "Q parameter not set"
        }
    }
    def show(int id){
        Resource resource=Resource.get(id)
        User user=session.user
        if(user&&resource&&user&&resource.canViewedBy(user)){
        List<TopicVO> trendingTopics= Topic.getTrendingTopics()
        //RatingInfoVO ratingInfoVo=resource.getRatingInfo()
            RatingInfoVO ratingInfoVO=resource.getRatingInfo()
            [user:user,resource:resource,ratingInfoVO:ratingInfoVO,trendingTopics:trendingTopics]
        }
        else{
                flash.error= "Resource not found or user not authorized"
                redirect(controller: "login",action: "index")
        }
    }
}
