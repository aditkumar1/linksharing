package com.tothenew.linkshare.resource

import com.tothenew.linkshare.user.User
import org.codehaus.groovy.grails.web.json.JSONObject

class ReadingItemController {
    def changeIsRead(long id,boolean isRead) {
        JSONObject jsonObject = new JSONObject()
        User user=session.user
        String query="Update ReadingItem ri set isRead=${isRead} where ri.resource.id=${id} and user.id=${user.id}"
        if(User.executeUpdate(query)){
            jsonObject.put("message","Status changed successfully")
        }
        else{
            jsonObject.put("error","Error while updating status")
        }
        render jsonObject.toString()
    }
}
