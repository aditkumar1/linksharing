package com.tothenew.linkshare.Login

import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceVO
import com.tothenew.linkshare.user.User
import grails.validation.ValidationException

class LoginController {
    //static scope="prototype"
    def messageSource
    def mailService
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
            List<ResourceVO> topPosts = Resource.getTopPosts(lOffset,lMax);
            [topPosts:topPosts, count:topPosts.size(),recentPosts:Resource.getRecentPosts()]
        }
    }
    def loginHandler(String username,String password){
        User loggedInUser =User.findWhere(username: username,password: password);
        if(loggedInUser){
            if(loggedInUser.active){
                session.user=loggedInUser;
                redirect(action:"index");
            }
            else{
                flash.error="user is not active";
            }
        }
        else{
            flash.error="user not found";
        }
        render(flash.error);
    }

    def logout(){
        session.invalidate();
        forward(action:"index");
    }
}
