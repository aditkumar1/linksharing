package com.tothenew.linkshare

import grails.validation.ValidationException

class SubscriptionController {

    def save(int id) {
        Topic topic=Topic.get(id)
        if(topic){
            Subscription subscription=new Subscription(user: session.user, topic: topic)
            try{
                subscription.save(failOnError: true)
                render "success ${subscription.seriousness}"
            }
            catch(ValidationException ve){
                render ve.toString()
            } catch (Exception e) {
                render e.toString()
            }
        }
        else{
            render "Topic not found"
        }
    }
    def update(int id,String seriousness) {
        Subscription subscription=Subscription.get(id)
        if(subscription&&subscription.seriousness.toString()==seriousness){
            try{
                subscription.save(failOnError: true)
                render "success ${subscription.seriousness}"
            }
            catch(ValidationException ve){
                render ve.toString()
            } catch (Exception e) {
                render e.toString()
            }
        }
        else{
            flash.error="Subscription not found"
            render flash.error
        }

    }
    def delete(int id) {
        try{
            Subscription.load(id).delete()
            render("Success")
        }
        catch(Exception ex){
            render "Not Found"
        }

    }
}
