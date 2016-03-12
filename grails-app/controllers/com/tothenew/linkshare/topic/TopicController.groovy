package com.tothenew.linkshare.topic

import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceSearchCO
import com.tothenew.linkshare.user.Subscription
import com.tothenew.linkshare.user.User
import grails.validation.ValidationException

class TopicController {

    def show(int id, ResourceSearchCO resourceSearchCo){
        Topic requestedTopic=Topic.read(id);
        if(requestedTopic){
            switch(requestedTopic.visibility){
                case Visibility.PRIVATE:
                    if(Subscription.findWhere(topic: requestedTopic, subscribedBy: session.user)){

                    }
                    else{
                        redirect(controller: "login",action: "index");
                        flash.error="user not subscribed to this topic";
                    }
                case Visibility.PUBLIC:
                    //render("Success");
                    List<User> subscribedUsers=requestedTopic.getSubscribedUsers()
                    List<Resource> posts=requestedTopic.resources.asList()
                    [topic:requestedTopic,subscribedUsers:subscribedUsers,posts:posts]
                    break;
                default:
                    flash.error="com.tothenew.linkshare.topic object is corrupt";
            }
        }
        else {
            flash.error="com.tothenew.linkshare.topic not found";
            redirect(controller: "Login" , action: "index");
        }
        //render flash.error
    }
    def update(int id,String visibility) {
        Map jsonObject = [:]
        Topic topic=Topic.get(id)
        if(topic){
            try{
                topic.visibility=visibility as Visibility
                topic.save(failOnError: true)
                jsonObject.message= "topic successfully saved"
            }
            catch(ValidationException ve){
                jsonObject.error= ve.toString()
            } catch (Exception e) {
                jsonObject.error= e.toString()
            }
        }
        else{
            jsonObject.error="Topic not found"
        }
        render jsonObject
    }
    def save(String name,String visibility){
        Map jsonObject = [:]
        Topic topic=new Topic(name:name,createdBy:session.user ,visibility: visibility as Visibility)
        try{
            topic.save(failOnError: true)
            jsonObject.message="Requested topic is saved"
        }
        catch(Exception ex){
            jsonObject.error="Exception caught :${ex.toString()}"
        }
        finally {
            render jsonObject
        }
    }
    def delete(long id) {
        User user=session.user
        Map jsonObject = [:]
        try{
            Topic topic=Topic.load(id)
            if(user.canDeleteRsourceOrTopic(topic)){
                topic.delete(flush: true)
                jsonObject.message="Success"
            }
            else{
                jsonObject.error= "User can not delete this topic"
            }
        }
        catch(Exception ex){
            jsonObject.error= "Not Found"
        }
        render jsonObject
    }
}
