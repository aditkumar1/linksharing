package com.tothenew.linkshare

class UserController {

    def index() {
        render("User Dashboard  --  ${session.user}");
    }
    def show(int id){
        Topic requestedTopic=Topic.findById(id);
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
    }
}
