package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.TopicSearchCO
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.user.User
import grails.transaction.Transactional

@Transactional
class SubscriptionService {

    def serviceMethod() {

    }

    List<TopicVO> search(TopicSearchCO topicSearchCO){

        if(topicSearchCO.id)
        {
            User user = topicSearchCO.getUser()
            return user.getSubscribedTopics(topicSearchCO.offset,topicSearchCO.max)
        }
    }
}
