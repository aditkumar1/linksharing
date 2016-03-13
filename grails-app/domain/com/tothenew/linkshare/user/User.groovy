package com.tothenew.linkshare.user

import com.tothenew.linkshare.resource.ReadingItem
import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceRating
import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.TopicVO

class User {
    String email;
    String username;
    String password;
    String firstName;
    String lastName;
    String confirmPassword;
    byte[] photo;
    Boolean admin;
    Boolean active;
    Date dateCreated;
    Date lastUpdated;

    static transients = ['name','confirmPassword','subscribedTopics','userSubscriptionsCount','userTopicsCount'];
    void changeActivateStatus() throws Exception{
        this.confirmPassword=this.password
        try{
            this.save(failOnError: true,flush: true)
        }
        catch (Exception ex)
        {
            throw ex
        }
    }

    String getName() {
        return "${firstName} ${lastName}";
    }
    List<TopicVO> getSubscribedTopics(int offset,int max){
        return Subscription.findAllBySubscribedBy(this,[max:max,offset:offset]).collect{ subscription ->
            Topic topic = subscription.topic
            new TopicVO(id: topic.id, count: topic.resources.size(), name: topic.name, createdBy: topic.createdBy, visibility: topic.visibility)
        }
    }
    int getUserTopicsCount() {
        return Topic.createCriteria().get {
            projections {
                    count('id')
            }
            eq('createdBy.id', this.id.toLong())
        } ?: 0
    }
    int getUserSubscriptionsCount(){

        return Subscription.createCriteria().get{
            projections{
                count('id')
            }
            eq('subscribedBy.id',this.id)
        }?:0
    }
    boolean canDeleteRsourceOrTopic(def resourceOrTopic){
        Boolean canDelete=false;
        if(this.admin||resourceOrTopic.createdBy.equals(this)){
            canDelete=true
        }
        else{
            canDelete=false
        }
        return canDelete
    }
    boolean isSubscribed(long topicId){
        boolean isSubscribed=false
        Subscription subscription=getSubscription(topicId)
        if(subscription) isSubscribed=true
        return isSubscribed
    }

    String getConfirmPassword(){
        return confirmPassword;
    }
    void setConfirmPassword(String password){
        confirmPassword=password;
    }
    int getScore(Resource resource){
        int score=0
        ResourceRating resourceRating=ResourceRating.findByRatedByAndResource(this,resource)
        if(resourceRating){
            score=resourceRating.score
        }
        return score
    }
    Subscription getSubscription(long topicId){
        return Subscription.createCriteria().get {
            eq('subscribedBy.id',this.id)
            eq('topic.id',topicId)
        }
    }
    static constraints = {
        email unique:true, email:true, nullable:false, blank :false;
        password nullable:false, blank:false, minSize:5;
        firstName nullable:false, blank:false;
        lastName nullable:false, blank:false;
        photo nullable:true, blank:true;
        admin nullable:true, blank:true;
        active nullable:true, blank:true;
        confirmPassword nullable: false, blank: false, minSize: 5;
        confirmPassword validator:{value,user->
            return value==user.password;
        }
    }
    static mapping = {
        photo(sqlType: 'longblob')
        sort(id: "desc")
    }
    boolean equals(User user){
        return this.id==user.id
    }

    @Override
    boolean equals(Object obj) {
        return super.equals(obj)
    }
    static namedQueries = {
        search {
            UserSearchCO userSearchCO ->

                if (userSearchCO.q) {

                    or
                            {
                                ilike('firstName', "%${userSearchCO.q}%")
                                ilike('lastName', "%${userSearchCO.q}%")
                                ilike('email', "%${userSearchCO.q}%")
                                ilike('username', "%${userSearchCO.q}%")

                            }
                }

                if (userSearchCO.isActive != null) {
                    eq('active', userSearchCO.isActive)
                }

                eq('admin', false)
        }

    }
//    String toString(){
//        return username;
//    }

    static hasMany = [topics:Topic, subscriptions:Subscription, readingItems:ReadingItem, resources:Resource];
}
