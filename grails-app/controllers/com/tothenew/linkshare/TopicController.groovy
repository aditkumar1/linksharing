package com.tothenew.linkshare

class TopicController {

    def show(int id, ResourceSearchCo resourceSearchCo){
        Topic requestedTopic=Topic.read(id);
        if(requestedTopic){
            switch(requestedTopic.visibility){
                case Visibility.PUBLIC:
                    render("Success");
                    break;
                case Visibility.PRIVATE:
                    if(Subscription.findWhere(topic: requestedTopic,user: session.user)){
                        render("Success");
                    }
                    else{
                        redirect(controller: "login",action: "index");
                        flash.error="User not subscribed to this topic";
                    }
                    break;
                default:
                    flash.error="Topic object is corrupt";
            }
        }
        else {
            redirect(controller: "Login" , action: "index");
            flash.error="Topic not found";
        }
        render flash.error
    }
    def save(Topic topic, String seriousness){

    }
}
