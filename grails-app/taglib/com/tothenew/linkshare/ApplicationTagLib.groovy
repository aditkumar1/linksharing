package com.tothenew.linkshare

import com.tothenew.linkshare.resource.LinkResource
import com.tothenew.linkshare.resource.ReadingItem
import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.user.User
import com.tothenew.linkshare.resource.Resource

class ApplicationTagLib {
    static defaultEncodeAs = [taglib: 'raw']
    static namespace="ls"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def markAsRead={attrs->
        User user=session.user
        Resource resource=attrs?.resource
        ReadingItem readingItem=ReadingItem.findByUserAndResource(user,resource)
        if(readingItem&&readingItem.isRead){
             out<<g.link(controller: 'readingItem',action: 'changeIsRead',params: [id:resource.id,isRead:false],"Mark as unread")
        }
        else{
             out<<g.link(controller: 'readingItem',action: 'changeIsRead',params: [id:resource.id,isRead:true],"Mark as read")
        }
    }
    def trendingTopics={
        User user=session.user
        List<TopicVO> trendingTopics= Topic.getTrendingTopics()
        out << g.render(template: "/topic/templates/trending", model: [trendingTopics: trendingTopics,user:user])
    }
    def topPost={
        List<Resource> topPosts=Resource.getTopPosts(0,5)
        out<<g.render(template: "/resource/templates/top-posts",model: [topPosts:topPosts])
    }
    def displayResource={attr->
        Resource resource=attr?.resource
        if(resource.isLinkResource()) {
            out<<g.link(url: ((LinkResource)resource).url,"View full site")
        }
        else{
            out<<g.link(url:"#","Download")
        }
    }
    def canDeleteResource={attr->
        User user=session.user
        Resource resource=attr?.resource
        if(user.canDeleteRsource(resource)){

        }
        else{

        }
    }

}
