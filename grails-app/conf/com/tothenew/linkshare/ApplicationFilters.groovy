package com.tothenew.linkshare

class ApplicationFilters {

    def filters = {
        sessionCheck(controller: 'login',invert:true){
            before={
                if(!session.user){
                    redirect(controller:"Login",action:"index");
                }
            }
        }
        logging(controller:'*', action:'*') {
            before = {
                log.info(params);
            }
        }

    }
}
