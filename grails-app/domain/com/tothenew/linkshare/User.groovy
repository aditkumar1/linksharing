package com.tothenew.linkshare

class User {
    String email;
    String username;
    String password;
    String firstName;
    String lastName;
    String confirmPassword;
    byte[] photo;
    Boolean admin;
    Boolean active;
    Date dateCreated;
    Date lastUpdated;

    static transients = ['name','confirmPassword'];
    String getName() {
        return "${firstName} ${lastName}";
    }
    String getConfirmPassword(){
        return confirmPassword;
    }
    void setConfirmPassword(String password){
        confirmPassword=password;
    }
    static constraints = {
        email unique:true, email:true, nullable:false, blank :false;
        password nullable:false, blank:false, minSize:5;
        firstName nullable:false, blank:false;
        lastName nullable:false, blank:false;
        photo nullable:true, blank:true;
        admin nullable:true, blank:true;
        active nullable:true, blank:true;
        confirmPassword nullable: false, blank: false, minSize: 5;
        confirmPassword validator:{value,user->
            return value==user.password;
        }
    }
    static mapping = {
        photo(sqlType: 'longblob')
    }
    static hasMany = [topics:Topic,subscriptions:Subscription,readingitems:ReadingItem,resources:Resource,resourceratings:ResourceRating];

    String toString(){
        return username;
    }
}
