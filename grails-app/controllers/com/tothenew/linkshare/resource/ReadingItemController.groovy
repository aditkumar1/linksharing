package com.tothenew.linkshare.resource

import com.tothenew.linkshare.user.User
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

class ReadingItemController {
    def changeIsRead(long id,boolean isRead) {
        Map jsonObject = [:]
        User user=session.user
        String query="Update ReadingItem ri set isRead=${isRead} where ri.resource.id=${id} and user.id=${user.id}"
        if(User.executeUpdate(query)){
            jsonObject.name =isRead?"Mark as unread":"Mark as read"
            jsonObject.message="Status changed successfully"
            jsonObject.url=g.createLink(controller:'readingItem',action: 'changeIsRead',id: id,params: ['isRead':!isRead])
        }
        else{
            jsonObject.error  ="Error while updating status"
        }
        render jsonObject as JSONObject
    }
}
