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
    String getName() {
        return "${firstName} ${lastName}";
    }
    List<TopicVO> getSubscribedTopics(offset,maxResults){
        return Subscription.findAllBySubscribedBy(this,[max:maxResults,offset:offset]).collect{ subscription ->
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
    boolean canDeleteRsource(Resource resource){
        Boolean canDelete=false;
        if(this.admin||resource.createdBy==this){
            canDelete=true
        }
        else{
            canDelete=false
        }
        return canDelete
    }
    boolean isSubscribed(long topicId){
        boolean subscription=false
        List result=Subscription.createCriteria().list {
            eq('subscribedBy.id',this.id)
            eq('topic.id',topicId)
        }
        if(result.size()>0) subscription=true
        return subscription
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
    
//    String toString(){
//        return username;
//    }

    static hasMany = [topics:Topic, subscriptions:Subscription, readingItems:ReadingItem, resources:Resource];
}
