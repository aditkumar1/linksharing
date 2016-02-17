package com.tothenew.linkshare

    abstract class Resource {
    String description;
    User createdBy;
    Topic topic;
    Date dateCreated;
    Date lastUpdated;


    static constraints = {
        createdBy blank:false, nullable:false;
        description blank:false, nullable:false;
        topic blank:false, nullable:false;

        //have doubt here
    }
        static mapping ={
            description(type:'text');
        }

        static hasMany = [resourceratings:ResourceRating,readingitems:ReadingItem];
        static belongsTo = [topic:Topic];
}
//https://docs.google.com/a/tothenew.com/document/d/1y4b2I5IXoHibL34Cur2NKF4dq6rN_fapYYwWMGtV5HU/edit?usp=sharing
