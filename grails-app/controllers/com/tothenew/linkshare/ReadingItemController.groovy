package com.tothenew.linkshare

class ReadingItemController {

    def changeIsRead(long id,boolean isRead) {
        String query="Update ReadingItem ri set isRead=${isRead} where ri.resource.id=${id}"
        if(User.executeUpdate(query)){
            render("Success")
        }
        else{
            render("error")
        }
    }
}
