package com.tothenew.linkshare.topic

import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.user.Seriousness
import com.tothenew.linkshare.user.Subscription
import com.tothenew.linkshare.user.User
import com.tothenew.linkshare.user.UserTopicDetailsVO
import grails.validation.ValidationException

class Topic {
    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility

    static transients = ['subscribedUsers']
    static constraints = {
        name unique: true, nullable: false, blank: false
        visibility nullable: false, blank: false
        createdBy nullable: false, blank: false
    }

    static mapping = {
        sort "name"
    }
    static hasMany = [subscriptions: Subscription, resources: Resource]

    def afterInsert() {
        try {
            Subscription.withNewSession {
                Subscription subscription = new Subscription(topic: this, subscribedBy: createdBy, seriousness: Seriousness.VERY_SERIOUS)
                subscription.save(failOnError: true)
                log.info("New Subscription Created. Deatils : ${subscription}")
            }

        } catch(ValidationException ve){
            log.info("Subscription creation failed. Error Details : ${ve.toString()}")
        }
    }

    @Override
    String toString(){
        return name
    }


    static List<TopicVO> getTrendingTopics(){
        List<TopicVO> topicVos= Topic.createCriteria().list(){
            projections{
                groupProperty('id')
                resources{
                    count('id','rCount')
                }
                property('name')
                property('visibility')
                property('createdBy')
            }

            order('rCount','desc')
            order('name', 'desc')
            maxResults(5)
        }.collect{
            new TopicVO(id: it[0],count: it[1],name: it[2],visibility: it[3],createdBy: it[4])
        }
        return topicVos
    }
    List<User> getSubscribedUsers(){
        return Subscription.findAllByTopic(this).collect{
            it.subscribedBy
        }
    }
}