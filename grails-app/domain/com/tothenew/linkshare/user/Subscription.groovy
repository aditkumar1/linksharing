package com.tothenew.linkshare.user

import com.tothenew.linkshare.topic.Topic

class Subscription {

    User subscribedBy;
    Seriousness seriousness = Seriousness.SERIOUS;
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
        subscribedBy nullable:false, blank:false;
        topic nullable:false, blank:false;
        subscribedBy unique:['topic'];
    }
    static  mapping = {
        subscribedBy(lazy: false)
        topic( lazy:false)
    }
//    //static fetchMode=[subscribedBy:'eager',topic:'eager']

    static belongsTo = [topic:Topic];
}
