package com.tothenew.linkshare.user

import com.tothenew.linkshare.resource.ReadingItem
import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceSearchCO
import com.tothenew.linkshare.topic.EmailDTO
import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicSearchCO
import com.tothenew.linkshare.topic.TopicVO
import com.tothenew.linkshare.topic.Visibility
import grails.validation.ValidationException

class UserController {
    def assetResourceLocator
    def topicService
    def subscriptionService
    def resourceService
    def emailService
    def photoUploaderService
    def index() {
        User user=User.get(session.user.id)
        long totalSubscribedTopicCount=Subscription.count()
        List<TopicVO> subscribedTopics =subscriptionService.search(new TopicSearchCO(id:user.id))
        List<TopicVO> trendingTopics= Topic.getTrendingTopics()
        List<TopicVO> createdTopics =subscribedTopics.findAll(){
            it.createdBy==user
        }
        List<Resource> inbox=user.getInbox()
        long inboxItemsTotalCount=user.getInboxCount()
        render(view:"/index",model: [user:user,subscribedTopics: subscribedTopics,totalSubscribedTopicCount:totalSubscribedTopicCount,createdTopics:createdTopics,trendingTopics:trendingTopics,posts:inbox,inboxItemsTotalCount:inboxItemsTotalCount])
    }
    def profile(ResourceSearchCO resourceSearchCO) {
        if(resourceSearchCO) {
            User user = User.get(resourceSearchCO.id)
            if (session.user) {
                if (!(session.user.admin || session.user.equals(user))) {
                    resourceSearchCO.visibility = Visibility.PUBLIC
                }
            }
            List<TopicVO> createdTopics=topicService.search(new TopicSearchCO(id:resourceSearchCO.id))
            long totalCreatedTopicCount=Topic.findAllByCreatedBy(user).size()
            List<TopicVO> subscribedTopics=subscriptionService.search(new TopicSearchCO(id:resourceSearchCO.id))
            long totalSubscribedTopicCount=Subscription.count()
            List<Resource> createdPosts = resourceService.search(resourceSearchCO)
            long totalCreatedPostCount=Resource.findAllByCreatedBy(user).size()
            [createdPosts: createdPosts,createdTopics: createdTopics,subscribedTopics: subscribedTopics,totalSubscribedTopicCount: totalSubscribedTopicCount,totalCreatedTopicCount:totalCreatedTopicCount,totalCreatedPostCount:totalCreatedPostCount, user: user]
        }
    }
    def updateProfile(){
        User user=User.get(session.user.id)
        user.properties=params
        try{
            user.updateInstance()
            flash.message="User profile successfully updated"
        }
        catch(ValidationException ve){
            flash.error=ve.toString()
        }
        catch(Exception ex){
            flash.error=ex.toString()
        }
        redirect(action: 'editProfile')
    }
    def updatePassword(String password, String confirmPassword){
        User user=User.get(session.user.id)
        user.password=password
        user.confirmPassword=confirmPassword
        try{
            user.updateInstance()
            flash.message="Password successfully updated"
        }
        catch(ValidationException ve){
            flash.error=ve.toString()
        }
        catch(Exception ex){
            flash.error=ex.toString()
        }
        redirect(action: 'editProfile')
    }
    def editProfile(){
        User user=session.user
        List<TopicVO> createdTopics=topicService.search(new TopicSearchCO(id:user.id))
        long totalCreatedTopicCount=Topic.findAllByCreatedBy(user).size()
        [createdTopics: createdTopics,totalCreatedTopicCount: totalCreatedTopicCount,user:user]
    }
    def inbox(int offset,int max){
        User user=User.get(session.user.id)
        List<Resource> inbox=user.getInbox(offset,max)
        long inboxItemsTotalCount=user.getInboxCount()
        render(template: "/user/templates/inbox",model: [posts:inbox,inboxItemsTotalCount:inboxItemsTotalCount])
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

    def topics(Long id) {

        TopicSearchCO topicSearchCO = new TopicSearchCO(id: id)

        if (session.user) {
            if (!(session.user.isAdmin || session.user.equals(User.load(id)))) {
                topicSearchCO.visibility = Visibility.PUBLIC
            }
        }
        List<TopicVO> createdTopics = topicService.search(topicSearchCO)
        render(template: '/topic/list', model: [topics: createdTopics])
    }

    def subscriptions(Long id) {

        TopicSearchCO topicSearchCO = new TopicSearchCO(id: id)

        if (session.user) {
            if (!(session.user.isAdmin || session.user.equals(User.load(id)))) {
                topicSearchCO.visibility = Visibility.PUBLIC
            }
        }
        List<TopicVO> subscribedTopics = subscriptionService.search(topicSearchCO)
        render(template: '/topic/list', model: [topics: subscribedTopics])
    }

    def list(UserSearchCO userSearchCO) {

        if (session.user) {
            if (session.user.admin) {
                List<User> users = User.search(userSearchCO).list(max: userSearchCO.max, sort: userSearchCO.sort, order: userSearchCO.order)
                [usersList: users]
            } else{
                flash.error="Only admin have access to this page"
                redirect(controller: "login", action: "index")
            }

        } else{
            flash.error="PLease login to this page.Only admin have access to this page"
            redirect(controller: "login", action: "index")
        }
    }

    def toggleActive(Long id) {
        if (session.user) {
            if (session.user.admin) {
                User user = User.get(id)
                if (user) {
                    if (user.admin) {
                        flash.error = "Admin active status cannot be changed."
                    } else
                        user.active = !(user.active)
                    try{
                        user.updateInstance()
                        flash.message="active status has been changed"
                    }
                    catch(ValidationException ve){
                        flash.error=ve.toString()
                    }
                    catch(Exception ex){
                        flash.error=ex.toString()
                    }
                }
            }
        }
        redirect(controller: "user", action: "list")
    }


    def forgotPassword(String recoveryemail) {
        User user = User.findByEmail(recoveryemail)
        if (user && user.active) {
            String newPassword = Util.getRandomPassword()
            EmailDTO emailDTO = new EmailDTO(to: recoveryemail, subject: "Account Recovery", view: "/email/templates/_password", model: [userName: user.name, newPassword: newPassword, serverUrl: grailsApplication.config.grails.serverURL])
            emailService.sendMail(emailDTO)
            user.password = newPassword
            try{
                user.updateInstance()
                flash.message = "Email successfully sent"
            }
            catch (Exception ex){
                flash.error = ex.toString()
            }
        } else {
            flash.error = "Email not for a valid user"
        }
        redirect(controller: "login", action: "index")
    }
}
