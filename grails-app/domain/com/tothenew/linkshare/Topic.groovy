package com.tothenew.linkshare

import grails.validation.ValidationException


class Topic {
    String name;
    User createdBy;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility;

    static constraints = {
        name unique:true, nullable: false, blank:false;
        visibility nullable:false, blank:false;
        createdBy nullable:false, blank:false;
    }
    static hasMany = [subscriptions:Subscription,resources:Resource];

    def afterInsert(){
        try{
            Subscription.withNewSession {
                Subscription subscription=new Subscription(topic:this,user:createdBy,seriousness:Seriousness.VERY_SERIOUS);
                subscription.save(failOnError: true);
                log.info("New Subscription Created. Deatils : ${subscription}") ;
            }

        }
        catch(ValidationException ve){
            log.info("Subscription creation failed. Error Details : ${ve.toString()}");
        }
    }

    @Override
    String toString(){
        return name;
    }

}
