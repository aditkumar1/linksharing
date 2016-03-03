package com.tothenew.linkshare

class ApplicationFilters {

    def filters = {
//        redirectToLogin(controller: "*", action: "*") {
//            before = {
//                if (!session.user) {
////                    redirect(controller: "login", action: "index")
//                }
//            }
//        }
        sessionCheck(controller: 'login', invert:true){
            before={
                if(!session.user){
                    redirect(controller:"login",action:"index");
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
