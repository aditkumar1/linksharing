package com.tothenew.linkshare

class Subscription {

    Topic topic;
    User user;
    Seriousness seriousness;
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
        user nullable:false, blank:false;
        topic nullable:false, blank:false;
        user unique:['topic'];
    }
    static belongsTo = [topic:Topic];
}
