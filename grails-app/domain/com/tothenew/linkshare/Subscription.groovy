package com.tothenew.linkshare

class Subscription {

    User user;
    Seriousness seriousness = Seriousness.SERIOUS;
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
        user nullable:false, blank:false;
        topic nullable:false, blank:false;
        user unique:['topic'];
    }
    static  mapping = {
        user(lazy: false)
        topic( lazy:false)
    }
    //static fetchMode=[user:'eager',topic:'eager']

    static belongsTo = [topic:Topic];
}
