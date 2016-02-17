package com.tothenew.linkshare

import groovy.util.logging.Log
import org.apache.commons.logging.LogFactory

class FirstController {

//    def log= LogFactory.getLog(this);
    def index() {

        log.error("Hi Manvender error")
        log.debug("Hi Manvender debug")
        log.debug(params.getClass())
        render "Hello this is my first program";
    }
}
