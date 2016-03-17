package com.tothenew.linkshare.user

import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceSearchCO
import com.tothenew.linkshare.resource.TopicService
import com.tothenew.linkshare.topic.TopicSearchCO
import com.tothenew.linkshare.topic.TopicVO

class SearchController {
def topicService
    def resourceService
    def show() {
        List<TopicVO> topics=[]
        List<Resource> posts=[]
        TopicSearchCO topicSearchCO=new TopicSearchCO()
        bindData(topicSearchCO, params);
       ResourceSearchCO resourceSearchCO=new ResourceSearchCO()
        bindData(resourceSearchCO, params);
        topics=topicService.search(topicSearchCO)
        posts=resourceService.search(resourceSearchCO)
       // render ([statusssss: 200]);
        [topics:topics,posts:posts]
    }
}
