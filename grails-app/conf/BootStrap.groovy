import com.tothenew.linkshare.*
import grails.validation.ValidationException
import org.apache.commons.logging.Log


class BootStrap {

    final String PASSWORD="Confidential";
    def grailsApplication

    def init = { servletContext ->


        println "......................."
        println grailsApplication.config.grails.app.context
        println ">..>>>>>>>>>>>>>>>>>>>>>"
        if(initialize()){
            log.info("Requirement fullfilled")
        }
        else{
            log.info("Requirement not fullfilled");
        }

    }
    Boolean initialize(){
        List<User> savedUsers;
        List<User> savedTopics;
        Boolean status=false;

        if(User.count==0){
            savedUsers= createUsers() ;
        }
        else {
            log.info("User Table is not Empty\n");
            return false;
        }

        if(Topic.count==0){
            savedTopics=createTopics(savedUsers);

        }
        else {
            log.info("Topics already created\n");
            return false;
        }
        if(Resource.count==0) {
            createResources(savedTopics);
        }
        else {
            return false;
        }

        return SubscribeTopics(savedUsers,savedTopics)&&createReadingItems()&&createResourceRating();
    }
    List<User> createUsers() {
        List<User> savedUsers=new ArrayList<User>();
        User user1=new User(email: "manvendra.singh@tothenew.com",username: "manvendra.singh",password: PASSWORD,firstName: "Manvendra",lastName: "Singh",admin: true,active: true);
        User user2=new User(email: "adit.kumar@tothenew.com",username: "adit.kumar",password: PASSWORD,firstName: "Adit",lastName: "Kumar",admin: false,active: true);

        if(saveUser(user1,savedUsers) && saveUser(user2,savedUsers)) {
            log.info("User list created. Count : ${savedUsers.size()}\n");
        }
        return savedUsers;
    }

    Boolean saveUser(User user,List<User> savedUsers) {

        try {
             user.save(flush: true,failOnError: true)
             log.info("New User Saved. Details : ${user}\n");
             savedUsers.add(user);
             return true;
        }
        catch(ValidationException ve) {
            log.error("User Creation failed. Exception details : ${ve.toString()}\n");
            return false
        }
    }
    List<Topic> createTopics(List<User> savedUsers){
        List<Topic> newTopics=new ArrayList<Topic>();
        List<Topic> savedTopics=new ArrayList<Topic>();
        savedUsers.each {
            newTopics.add(new Topic(name: "How to become rich in 1 day like ${it.firstName}",createdBy: it,visibility:Visibility.PUBLIC));
            newTopics.add(new Topic(name: "How to become rich in 2 day like ${it.firstName}",createdBy: it,visibility:Visibility.PUBLIC));
            newTopics.add(new Topic(name: "How to become rich in 3 day like ${it.firstName}",createdBy: it,visibility:Visibility.PUBLIC));
            newTopics.add(new Topic(name: "How to become rich in 4 day like ${it.firstName}",createdBy: it,visibility:Visibility.PUBLIC));
            newTopics.add(new Topic(name: "How to become rich in 5 day like ${it.firstName}",createdBy: it,visibility:Visibility.PUBLIC));
        }

        if(saveTopics(newTopics,savedTopics)) {
            log.info("Required Topics list per User created. Count : ${newTopics.size()}\n");
        }
        return savedTopics;
    }

    Boolean saveTopics(List<Topic> newTopics,List<Topic> savedTopics) {
        try {
            if(newTopics) {
                newTopics.each {
                    it.save(flush: true, failOnError: true);
                    log.info("New Topic Saved. Details : ${it}\n");
                    savedTopics.add(it);
                }
            }

            return true;
        }
        catch(ValidationException ve) {
            log.error("Topic Creation failed. Exception details : ${ve.toString()}\n");
            return false
        }
    }

    Boolean createResources(List<Topic> savedTopics){
        try{
            savedTopics.each {
                new LinkResource(description: it.name,createdBy: it.createdBy,topic: it,url: "http://www.download.com").save(failOnError:true);
                new LinkResource(description: it.name,createdBy: it.createdBy,topic: it,url: "http://www.download.com").save(failOnError:true);
                new DocumentResource(description: it.name,createdBy: it.createdBy,topic: it,filePath: "/opt/bin/a1").save(failOnError:true);
                new DocumentResource(description: it.name,createdBy: it.createdBy,topic: it,filePath: "/opt/bin/a2").save(failOnError:true);
            }
            log.info("Resources creation successful");
            return true;

        }
        catch(ValidationException ve){
            log.error("Resource Creation failed. Exception details : ${ve.toString()}\n");
            return false;
        }

    }

    Boolean SubscribeTopics(List<User> savedUser,List<Topic> savedTopics) {
        savedUser.each {user->
            savedTopics.each{topic->
                if(!Subscription.findWhere(user: user,topic:topic)){
                    try{
                          Subscription subscription=new Subscription(topic:topic,user:user,seriousness:Seriousness.VERY_SERIOUS);
                          subscription.save(failOnError: true);
                          log.info("New Subscription Created. Deatils : ${subscription}") ;
                    }
                    catch(ValidationException ve){
                        log.error("Subscription creation failed. Error Details : ${ve.toString()}");
                        return false;
                    }
                }
            }
        }
        return true;

    }

    Boolean createReadingItems(){
        Resource.all.each {resource->
            if(!Subscription.findWhere(user:resource.createdBy,topic: resource.topic)){
                if(!ReadingItem.findByUser(resource.createdBy)){
                    try{
                        ReadingItem readingitem=new ReadingItem(resource:resource,user:resource.createdBy,isRead: false);
                        readingitem.save(failOnError: true);
                        log.info("New reading item created. Details : ${readingitem}");
                    }
                    catch(ValidationException ve){
                        log.error("Reading Item creation failed. Error Details : ${ve.toString()}");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    Boolean createResourceRating(){
        ReadingItem.findByIsRead(Boolean.FALSE).each {
            try{
                ResourceRating resourceRating=new ResourceRating(user:it.user,resource: it.resource,score: 2);
                resourceRating.save(failOnError: true);
                log.info("New resource rating created. Details : ${resourceRating}");
            }
            catch(ValidationException ve){
                log.error("Resource rating creation failed. Error Details : ${ve.toString()}");
                return false;
            }
        }
        return true;
    }


    def destroy = {

    }

}
