package com.tothenew.linkshare.user

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO


class UserController {
    def index() {
        User user=User.get(session.user.id)
        List<TopicVO> subscribedTopics =user.getSubscribedTopics(0,5)
        List<TopicVO> trendingTopics= Topic.getTrendingTopics()
        List<TopicVO> createdTopics =subscribedTopics.findAll(){
            it.createdBy==user
        }
        render(view:"/index",model: [user:user,subscribedTopics: subscribedTopics,createdTopics:createdTopics,trendingTopics:trendingTopics])
    }
}
