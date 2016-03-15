package com.tothenew.linkshare

class ApplicationFilters {

    def filters = {
        def filters = {
            all(controller:'*', action:'*') {
                before = {

                    log.info "Controller : ${controllerName}, Action : ${actionName}"
                    log.info params

                }
                after = { Map model ->

                }
                afterView = { Exception e ->

                }
            }
        }

    }
}

