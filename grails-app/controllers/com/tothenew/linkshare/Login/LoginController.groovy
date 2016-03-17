package com.tothenew.linkshare.Login

import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceVO
import com.tothenew.linkshare.user.User
import grails.validation.ValidationException

class LoginController {
    //static scope="prototype"
    def messageSource
    def mailService
    def photoUploaderService
    def index(int offset, int max) {
//        def message = messageSource.getMessage("login.index.array.out.of.bounds", null, Locale.FRENCH)
//
//        try {
//            throw new ArrayIndexOutOfBoundsException(message)
//        } catch (ArrayIndexOutOfBoundsException ae) {
//            flash.error=ae.toString()
//        }
        int lOffset = offset ?: 0;
        int lMax = max ?: 3
        if(session.user){
            redirect(controller: "user",action: "index");
        }
        else {
            [recentPosts:Resource.getRecentPosts()]
        }
    }

    def validateEmail(){

        User numUser = User.findByEmail(params.email)
        log.info params.email
        Boolean result = numUser ? false : true
        render result
    }

    def validateUserName(){
        System.err.println("................$params")
        User numUser = User.findByUsername(params.username)
        log.info params.username
        Boolean result = numUser ? false : true
        render result
    }

    def loginHandler(String username,String password){
        User loggedInUser =User.findWhere(username: username,password: password);
        if(loggedInUser){
            if(loggedInUser.active){
                session.user=loggedInUser;
            }
            else{
                flash.error="User is not active";
            }
        }
        else{
            flash.error="User not found";
        }
        redirect(action:"index");
    }
    def register() {
        User registerUser = new User(params)
        if (registerUser.validate()) {
            registerUser.save(flush: true)
            session.user=registerUser
            flash.message="Registration Successfull"
        } else {
            flash.error="Could not register user field ${registerUser.errors.fieldError} cannot have value ${registerUser.errors.fieldError.rejectedValue}"
        }
        redirect(controller: 'login',action: 'index')
    }

    def logout(){
        session.invalidate();
        forward(action:"index");
    }
}
