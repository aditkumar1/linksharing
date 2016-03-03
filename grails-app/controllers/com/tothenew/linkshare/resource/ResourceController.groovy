package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.topic.Visibility

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
    def search(ResourceSearchCo resourceSearchCo){
        if(resourceSearchCo.q){
            resourceSearchCo.visibility=Visibility.PUBLIC
            render Resource.search(resourceSearchCo).list()
        }
        else {
            render "Q parameter not set"
        }
    }
    def show(){
        List<TopicVO> topicVos=Topic.trendingTopics
        List<RatingInfoVo> ratingInfoVos=Resource.getRatingInfo()
        if(resource){
            RatingInfoVo ratingInfoVo=resource.ratingInfo
            render ratingInfoVo
        }
        else{
            render "resource not found"
        }
    }


}
