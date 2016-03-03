package com.tothenew.linkshare.resource

import com.tothenew.linkshare.user.User

class ReadingItemController {

    def changeIsRead(long id,boolean isRead) {
        String query="Update ReadingItem ri set isRead=${isRead} where ri.resource.id=${id}"
        if(User.executeUpdate(query)){
        }
        else{
            render("error")
        }
    }
}
