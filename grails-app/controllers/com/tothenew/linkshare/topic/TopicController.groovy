package com.tothenew.linkshare.topic

import com.tothenew.linkshare.resource.ResourceSearchCo
import com.tothenew.linkshare.user.Subscription

class TopicController {

    def show(int id, ResourceSearchCo resourceSearchCo){
        Topic requestedTopic=Topic.read(id);
        if(requestedTopic){
            switch(requestedTopic.visibility){
                case Visibility.PUBLIC:
                    render("Success");
                    break;
                case Visibility.PRIVATE:
                    if(Subscription.findWhere(topic: requestedTopic, subscribedBy: session.user)){
                        render("Success");
                    }
                    else{
                        redirect(controller: "login",action: "index");
                        flash.error="user not subscribed to this topic";
                    }
                    break;
                default:
                    flash.error="com.tothenew.linkshare.topic object is corrupt";
            }
        }
        else {
            //redirect(controller: "Login" , action: "index");
            flash.error="com.tothenew.linkshare.topic not found";
        }
        render flash.error
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
