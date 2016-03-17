package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicSearchCO
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.topic.Visibility
import com.tothenew.linkshare.user.User
import grails.transaction.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }

    List<TopicVO> search(TopicSearchCO topicSearchCO) {
        List<TopicVO> createdTopicsList = []

        if (topicSearchCO.id) {
            User user = topicSearchCO.getUser()

            List<Topic> topicList = Topic.createCriteria().list(offset:topicSearchCO.offset,max: topicSearchCO.max) {
                eq('createdBy.id', topicSearchCO.id)

                if(topicSearchCO.visibility)
                    eq('visibility', topicSearchCO.visibility)
                if(topicSearchCO?.q)
                    eq('name', "%${topicSearchCO.q}%")
            }

            topicList.each {
                topic -> createdTopicsList.add(new TopicVO(id: topic.id, name: topic.name, visibility: topic.visibility, createdBy: topic.createdBy))
            }

        }
        else{
            List<Topic> topicList = Topic.createCriteria().list(offset:topicSearchCO.offset,max: topicSearchCO.max) {
                    eq('visibility',Visibility.PUBLIC)
                if(topicSearchCO?.q)
                    ilike('name', "%${topicSearchCO.q}%")
            }

            topicList.each {
                topic -> createdTopicsList.add(new TopicVO(id: topic.id, name: topic.name, visibility: topic.visibility, createdBy: topic.createdBy))
            }
        }

        return createdTopicsList
    }
}
