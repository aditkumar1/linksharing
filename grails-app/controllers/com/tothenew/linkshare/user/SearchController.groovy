package com.tothenew.linkshare.user

import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceSearchCO
import com.tothenew.linkshare.resource.TopicService
import com.tothenew.linkshare.topic.TopicSearchCO
import com.tothenew.linkshare.topic.TopicVO

class SearchController {
def topicService
    def resourceService
    def show(String topicSearch,String resourceSearch) {
        List<TopicVO> topics=[]
        List<Resource> posts=[]
        if(topicSearch){
            topics=topicService.search(new TopicSearchCO(description: topicSearch))
        }
        if(resourceSearch){
            posts=resourceService.search(new ResourceSearchCO(description: resourceSearch))
        }
        [topics:topics,posts:posts]
    }
}
