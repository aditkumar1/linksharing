package com.tothenew.linkshare

class UserController {

    def index() {
        render("User Dashboard  --  ${session.user}");
    }

}
