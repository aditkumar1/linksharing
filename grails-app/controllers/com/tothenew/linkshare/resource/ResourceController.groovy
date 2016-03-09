package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.topic.Visibility
import com.tothenew.linkshare.user.User

class ResourceController {

    def delete(int id) {
        try {
            Resource.load(id).delete(flush:true)
            render "resource Deleted "+id
        }
        catch(Exception e){
            flash.error=e.toString()
            render flash.error
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
        User user=User.get(session.user.id)
        List<TopicVO> trendingTopics= Topic.getTrendingTopics()
        //RatingInfoVO ratingInfoVo=resource.getRatingInfo()
        if(resource){
            RatingInfoVO ratingInfoVO=resource.getRatingInfo()
            [user:user,resource:resource,ratingInfoVO:ratingInfoVO,trendingTopics:trendingTopics]
        }
        else{
                flash.error= "resource not found"
        }
    }


}
