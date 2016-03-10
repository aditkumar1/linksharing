package com.tothenew.linkshare

import com.tothenew.linkshare.resource.LinkResource
import com.tothenew.linkshare.resource.ReadingItem
import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.user.Subscription
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
    def showSubscribe={attrs->
        User user=session.user
        if(user&&attrs.topicId){
            if(user.isSubscribed(attrs.topicId)){
                out<<g.link(controller: "subscription",action: "delete",id: attrs.topicId,"Unsubscribe")
            }
            else{
                out<<g.link(controller: "subscription",action: "save",id: attrs.topicId,"Subscribe")
            }
        }
    }
    def susbcriptionCount={attrs->
        int count=0
        String output=""
        if(attrs.topicId){
            Topic topic=Topic.get(attrs.topicId)
            count=topic?.getSubscriptionCount()
            output=g.link(controller: "topic",action: "show",params: [id:attrs.topicId],count.toString())
        }
        if(attrs.user){
            User user=attrs.user
            count=user.getUserSubscriptionsCount()
            output=g.link(controller: "user",action: "show",params: [id:attrs.topicId],count.toString())
        }
        out<<output
    }
    def resourceCount={attrs->
        long topicId=0
        int count=0
        if(attrs.topicId){
            topicId=attrs.topicId
            Topic topic=Topic.get(topicId)
            count=topic.getResourceCount()
            out<<g.link(controller: "topic",action: "show",params: [id:attrs.topicId],count.toString())
        }
    }
    def topicCount={attrs->
        int count=0
        if(attrs.user){
            User user=attrs.user
            count=user.getUserTopicsCount()
            out<<g.link(controller: "user",action: "show",params: [id:user.id],count.toString())
        }
    }

}
