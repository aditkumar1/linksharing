package com.tothenew.linkshare.user

import com.tothenew.linkshare.topic.Topic
import grails.validation.ValidationException

class SubscriptionController {

    def save(int id) {
        Map jsonObject = [:]
        Topic topic=Topic.get(id)
        if(topic){
            Subscription subscription=new Subscription(subscribedBy: session.user, topic: topic)
            try{
                subscription.save(failOnError: true)
                jsonObject.message= "success ${subscription.seriousness}"
            }
            catch(ValidationException ve){
                jsonObject.error= ve.toString()
            } catch (Exception e) {
                jsonObject.error =e.toString()
            }
        }
        else{
            jsonObject.error= "com.tothenew.linkshare.topic not found"
        }
        render jsonObject
    }
    def update(int id,String seriousness) {
        Map jsonObject = [:]
        Subscription subscription=Subscription.get(id)
        if(subscription&&subscription.seriousness.toString()==seriousness){
            try{
                subscription.save(failOnError: true)
                 jsonObject.message= "success : ${subscription.seriousness}"
            }
            catch(ValidationException ve){
                render ve.toString()
            } catch (Exception e) {
                render e.toString()
            }
        }
        else{
            jsonObject.error="Subscription not found"
        }

    }
    def delete(int id) {
        Map jsonObject = [:]
        try{
            Subscription.load(id).delete(flush: true)
            jsonObject.message="Success"
        }
        catch(Exception ex){
            jsonObject.error= "Not Found"
        }
        render jsonObject

    }
}
