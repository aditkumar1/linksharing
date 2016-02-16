class BootStrap {

    def grailsApplication

    def init = { servletContext ->

        println "......................."
        println grailsApplication.config.grails.app.context
        println ">..>>>>>>>>>>>>>>>>>>>>>"
    }
    def destroy = {

    }
}
