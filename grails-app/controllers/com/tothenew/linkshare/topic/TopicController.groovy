package com.tothenew.linkshare.topic

import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceSearchCO
import com.tothenew.linkshare.user.Subscription
import com.tothenew.linkshare.user.User

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
    def save(Topic topic, String seriousness){
        try{
            topic.createdBy=session.user
            topic.save(failOnError: true)
            flash.error="Requested com.tothenew.linkshare.topic is saved"
        }
        catch(Exception ex){
            flash.error="Exception caught :${ex.toString()}"
        }
        finally {
            render flash.error
        }
    }
}
