package com.tothenew.linkshare.user

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicSearchCO
import com.tothenew.linkshare.topic.TopicVO
import grails.validation.ValidationException

class SubscriptionController {

    def subscriptionService
    def save(int id) {
        Map jsonObject = [:]
        Topic topic=Topic.get(id)
        if(topic){
            Subscription subscription=new Subscription(subscribedBy: session.user, topic: topic)
            try{
                subscription.save(failOnError: true)
                jsonObject.message= "success ${subscription.seriousness}"
            }
            catch(ValidationException ve){
                jsonObject.error= ve.toString()
            } catch (Exception e) {
                jsonObject.error =e.toString()
            }
        }
        else{
            jsonObject.error= "com.tothenew.linkshare.topic not found"
        }
        render jsonObject
    }
    def update(int id,String seriousness) {
        Map jsonObject = [:]
        Subscription subscription=Subscription.get(id)
        if(subscription){
            try{
                subscription.seriousness=seriousness as Seriousness
                subscription.save(failOnError: true,flush: true)
                 jsonObject.message= "success : ${subscription.seriousness}"
            }
            catch(ValidationException ve){
                jsonObject.error= ve.toString()
            } catch (Exception e) {
                jsonObject.error= e.toString()
            }
        }
        else{
            jsonObject.error="Subscription not found"
        }
        render jsonObject
    }
    def delete(long id) {
        User user=session.user
        Topic topic=Topic.get(id)
        Map jsonObject = [:]
        try{
            Subscription subscription=user.getSubscription(id)
            if(!topic?.createdBy.equals(user)){
                subscription.delete(flush: true)
                jsonObject.message="Success"
            }
            else{
                jsonObject.error= "Creator of topic cant unsubscribe"
            }
        }
        catch(Exception ex){
            jsonObject.error= "Not Found"
        }
        render jsonObject
    }
    def subscribedTopics(int offset,int max){
        User user=User.get(session.user.id)
        long totalSubscribedTopicCount=Subscription.count()
        List<TopicVO> subscribedTopics =subscriptionService.search(new TopicSearchCO(id:user.id,offset: offset,max: max))
        render(template: '/subscription/templates/show',model: [subscribedTopics:subscribedTopics,user:user,totalSubscribedTopicCount:totalSubscribedTopicCount])
    }
    def subscribedUsers(int offset,int max){
        Topic requestedTopic=Topic.get(params.id)
        List<User> subscribedUsers=requestedTopic.getSubscribedUsers(offset,max)
        long totalSubscribedUserCount=requestedTopic.getSubscribedUsersCount()
        render(template: subscribedUsers,model: [subscribedUsers:subscribedUsers,totalSubscribedUserCount:totalSubscribedUserCount,topic: requestedTopic])
    }
}
