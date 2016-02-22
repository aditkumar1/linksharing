package com.tothenew.linkshare

import grails.validation.ValidationException


class LoginController {

    def index() {
        if(session.user){
            redirect(controller:"User",action:"index");
        }
        else{
            render("Failure");
        }

    }
    def loginHandler(String username,String password){

        if(loggedInUser){
            if(loggedInUser.active){
                session.user=loggedInUser;
                redirect(action:"index");
            }
            else{
                flash.error="User is not active";
            }
        }
        else{
            flash.error="User not found";
        }
        render(flash.error);
    }
    def register(){
        User newUser=new User(email: params.email,username: params.username,password: params.password,confirmPassword: params.confirmPassword,firstName: params.firstName,lastName: params.lastName,admin: params.admin,active: params.active);
        try {
            newUser.save(flush: true, failOnError: true);
            render "Success"
        }
        catch(ValidationException ve) {
            render(ve.toString());
        }
    }
    def logout(){
        session.invalidate();
        forward(action:"index");
    }
}
