package com.tothenew.linkshare.user


import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO
import org.apache.catalina.connector.Response


class UserController {
    def assetResourceLocator
    def index() {
        User user=User.get(session.user.id)
        List<TopicVO> subscribedTopics =user.getSubscribedTopics(0,5)
        List<TopicVO> trendingTopics= Topic.getTrendingTopics()
        List<TopicVO> createdTopics =subscribedTopics.findAll(){
            it.createdBy==user
        }
        render(view:"/index",model: [user:user,subscribedTopics: subscribedTopics,createdTopics:createdTopics,trendingTopics:trendingTopics])
    }
    def image(Long id) {
        User user = User.get(id)
        byte[] photo

        if (user?.photo) {
            photo = user.photo
        } else {
            photo = assetResourceLocator.findAssetForURI('user.png').byteArray
        }
        response.contentType = 'image/png'
        OutputStream out = response.getOutputStream()
        out.write(photo)
        out.flush()
        out.close()
    }
}
