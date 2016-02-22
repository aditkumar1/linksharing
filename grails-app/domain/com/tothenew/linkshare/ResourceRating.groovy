package com.tothenew.linkshare

class ResourceRating {
    
    User ratedBy;
    Integer score;
    Date dateCreated;
    Date lastUpdated;
    static constraints = {
        
        score min:1, max:5;
        resource (unique:['ratedBy']);

    }
    static belongsTo = [resource:Resource];
}
