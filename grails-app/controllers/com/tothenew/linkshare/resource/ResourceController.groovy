package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.topic.Visibility
import com.tothenew.linkshare.user.User

class ResourceController {

    def delete(int id) {
        User user= session.user
        try {
            Resource resource=Resource.load(id)
            if(user.canDeleteRsource(resource)){
                resource.delete(flush:true)
                flash.message= "resource Deleted "+id
                redirect(controller: "user",action: "index")
            }
        }
        catch(Exception e){
            flash.error=e.toString()
            redirect(controller: "user",action: "index")
        }
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
        if(resource&&user&&resource.canViewedBy(user)){
        List<TopicVO> trendingTopics= Topic.getTrendingTopics()
        //RatingInfoVO ratingInfoVo=resource.getRatingInfo()
            RatingInfoVO ratingInfoVO=resource.getRatingInfo()
            [user:user,resource:resource,ratingInfoVO:ratingInfoVO,trendingTopics:trendingTopics]
        }
        else{
                flash.error= "resource not found or user not authorized"
        }
    }


}
