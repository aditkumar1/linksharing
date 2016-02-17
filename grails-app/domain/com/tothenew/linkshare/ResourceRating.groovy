package com.tothenew.linkshare

class ResourceRating {
    Resource resource;
    User user;
    Integer score;
    Date dateCreated;
    Date lastUpdated;
    static constraints = {
        user nullable:false, blank:false;
        score nullable:false, blank:false, min:1, max:5;
        resource nullable:false, blank:false;
        resource (unique:['user']);

    }
    static belongsTo = [resource:Resource];
}
