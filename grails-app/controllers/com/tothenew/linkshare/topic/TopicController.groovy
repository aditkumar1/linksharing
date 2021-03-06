package com.tothenew.linkshare.topic

import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceSearchCO
import com.tothenew.linkshare.user.Subscription
import com.tothenew.linkshare.user.User
import grails.converters.JSON
import grails.validation.ValidationException
import org.codehaus.groovy.grails.web.json.JSONObject

class TopicController {
def emailService
    def topicService
    def show(int id, ResourceSearchCO resourceSearchCo){
        Topic requestedTopic=Topic.read(id);
        if(requestedTopic){
            switch(requestedTopic.visibility){
                case Visibility.PRIVATE:
                    if(Subscription.findWhere(topic: requestedTopic, subscribedBy: session.user)){

                    }
                    else{
                        redirect(controller: "login",action: "index");
                        flash.error="user not subscribed to this topicId";
                        break
                    }
                case Visibility.PUBLIC:
                    //render("Success");
                    List<User> subscribedUsers=requestedTopic.getSubscribedUsers()
                    long totalSubscribedUserCount=requestedTopic.getSubscribedUsersCount()
                    List<Resource> posts=requestedTopic.getPost()
                    long totalPostCount=requestedTopic.getPostCount()
                    [topic:requestedTopic,subscribedUsers:subscribedUsers,posts:posts,totalSubscribedUserCount:totalSubscribedUserCount,totalPostCount:totalPostCount]
                    break;
                default:
                    flash.error="com.tothenew.linkshare.topicId object is corrupt";
            }
        }
        else {
            flash.error="com.tothenew.linkshare.topicId not found";
            redirect(controller: "Login" , action: "index");
        }
        //render flash.error
    }

    def createdTopics(int offset,int max){
        User user=User.get(params?.userId)
        long totalCreatedTopicCount=Topic.findAllByCreatedBy(user).size()
        List<TopicVO> createdTopics=topicService.search(new TopicSearchCO(id:user?.id))
        render(template: '/user/templates/createdTopics',model: [createdTopics:createdTopics,totalCreatedTopicCount:totalCreatedTopicCount])
    }
    def update(int id,String visibility) {
        Map jsonObject = [:]
        Topic topic=Topic.get(id)
        if(topic){
            try{
                topic.visibility=visibility as Visibility
                topic.save(failOnError: true,flush: true)
                jsonObject.message= "topicId successfully saved"
            }
            catch(ValidationException ve){
                jsonObject.error= ve.toString()
            } catch (Exception e) {
                jsonObject.error= e.toString()
            }
        }
        else{
            jsonObject.error="Topic not found"
        }
        render jsonObject as JSONObject
    }
    def save(String name,String visibility){
        Map jsonObject = [:]
        Topic topic=new Topic(name:name,createdBy:session.user ,visibility: visibility as Visibility)
        try{
            topic.save(failOnError: true)
            jsonObject.message="Requested topicId is saved"
        }
        catch(Exception ex){
            jsonObject.error="Exception caught :${ex.toString()}"
        }
        finally {
            render jsonObject as JSONObject
        }
    }
    def delete(long id) {
        User user=session.user
        Map jsonObject = [:]
        try{
            Topic topic=Topic.load(id)
            if(user.canDeleteRsourceOrTopic(topic)){
                topic.delete(flush: true)
                jsonObject.message="Success"
            }
            else{
                jsonObject.error= "User can not delete this topicId"
            }
        }
        catch(Exception ex){
            jsonObject.error= "Not Found"
        }
        render jsonObject as JSONObject
    }
    def updateTopicName(long id,String topic)
    {
        Map jsonObject = [:]
        Topic updateTopic = Topic.read(id)
        if(updateTopic)
        {
            updateTopic.name = topic
            try {
                updateTopic.save(failOnError: true,flush: true)
                jsonObject.message = "Topic Updated"
                jsonObject.topic=topic
            }
            catch (Exception ex){
                jsonObject.message = "Could not be Updated"
            }
        }
        else {
            jsonObject.message = "Cannot find topic"
        }
        render jsonObject as JSONObject
    }
    def invite(String email,long id) {
        Topic topic = Topic.get(id)
        EmailDTO emailDTO = new EmailDTO(to: email, subject: "Topic Invitation", view: "/email/templates/_invite", model: [topic: topic, user: session.user, serverUrl: grailsApplication.config.grails.serverURL])
        emailService.sendMail(emailDTO)
        redirect(controller: "user", action: "index")
    }

    def join(long id) {
        User invitedUser = session.user
        Topic invitedTopic = Topic.read(id)
        if (!invitedUser.isSubscribed(invitedTopic.id)) {
            Subscription subscription = new Subscription(topic: invitedTopic, subscribedBy: invitedUser)
            try {
                subscription.save()
                flash.message = "Subscribed"
            } catch (Exception ex){
                flash.error = ex.toString()
            }
        } else {
            flash.message = "Already Subscribed"
        }
        redirect(controller: "user", action: "index")
    }
}
