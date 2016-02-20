package com.tothenew.linkshare

class User {
    String email;
    String username;
    String password;
    String firstName;
    String lastName;
    byte[] photo;
    Boolean admin;
    Boolean active;
    Date dateCreated;
    Date lastUpdated;

    static transients = ['getName'];
    String getName() {
        return "${firstName} ${lastName}";
    }
    static constraints = {
        email unique:true, email:true, nullable:false, blank :false;
        password nullable:false, blank:false, minSize:5;
        firstName nullable:false, blank:false;
        lastName nullable:false, blank:false;
        photo nullable:true, blank:true;
        admin nullable:true, blank:true;
        active nullable:true, blank:true;

    }
    static mapping = {
        photo(sqlType: 'longblob')
    }
    static hasMany = [topics:Topic,subscriptions:Subscription,readingitems:ReadingItem,resources:Resource,resourceratings:ResourceRating];

    String toString(){
        return username;
    }
}
