package com.tothenew.linkshare.user

/**
 * Created by ttnd on 13/3/16.
 */
class Util {
    static String getRandomPassword(){
            return UUID.randomUUID().toString().substring(0,8)
        }
    }


