package com.tothenew.linkshare



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

}
