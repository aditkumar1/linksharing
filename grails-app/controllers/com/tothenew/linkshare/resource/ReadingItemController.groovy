package com.tothenew.linkshare.resource

import com.tothenew.linkshare.user.User

class ReadingItemController {
    def changeIsRead(long id,boolean isRead) {
        User user=session.user
        String query="Update ReadingItem ri set isRead=${isRead} where ri.resource.id=${id} and user.id=${user.id}"
        if(User.executeUpdate(query)){
            render "success"
        }
        else{
            flash.error="Error updating reading Item"
        }
    }
}
