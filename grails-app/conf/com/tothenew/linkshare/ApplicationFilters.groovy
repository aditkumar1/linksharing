package com.tothenew.linkshare

class ApplicationFilters {

    def filters = {
//        sessionCheck(controller: 'Login',invert:true){
//            before={
//                log.info(params);
//                if(!session.user){
//                    redirect(controller:"Login",action:"index");
//                }
//            }
//        }
        logging(controller:'*', action:'*') {
            before = {
                log.info(params);
                if((params.controller).toLowerCase()!='login'){
                    if(!session.user) {
                        redirect(controller: "Login", action: "index");
                    }

                }
            }
        }

    }
}
