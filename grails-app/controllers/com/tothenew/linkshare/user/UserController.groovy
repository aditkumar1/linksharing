package com.tothenew.linkshare.user

import com.tothenew.linkshare.topic.TopicVO


class UserController {
    def index() {
        User user=session.user
        List<TopicVO> subscribedTopics =user.getSubscribedTopics()
        List<TopicVO> createdTopics =subscribedTopics.findAll(){
            it.createdBy==user
        }
        render(view:"/index",model: [user:user,subscribedTopics: subscribedTopics,createdTopics:createdTopics])
    }
}
