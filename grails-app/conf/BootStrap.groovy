import com.tothenew.linkshare.resource.DocumentResource
import com.tothenew.linkshare.resource.LinkResource
import com.tothenew.linkshare.resource.ReadingItem
import com.tothenew.linkshare.resource.Resource
import com.tothenew.linkshare.resource.ResourceRating
import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.user.Seriousness
import com.tothenew.linkshare.user.Subscription
import com.tothenew.linkshare.user.User
import com.tothenew.linkshare.topic.Visibility
import grails.validation.ValidationException

class BootStrap {

    final String PASSWORD="Confidential";
    def grailsApplication

    def init = { servletContext ->


        println "......................."
        println grailsApplication.config.grails.app.context
        println ">..>>>>>>>>>>>>>>>>>>>>>"
//        if(initialize()){

//            log.info("Requirement fullfilled")
//        }
//        else{
//            log.info("Requirement not fullfilled");
//        }

        if (User.count() == 0) {
            initialize()
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
//            log.info("user Table is not Empty\n");
            return false;
        }

        if(Topic.count==0){
            savedTopics=createTopics(savedUsers);

        }
        else {
//            log.info("Topics already created\n");
            return false;
        }
        if(Resource.count==0) {
            createResources(savedTopics);
        }
        else {
//            log.info("Resources already created\n");
            return false;
        }

        return SubscribeTopics(savedUsers,savedTopics)&&createReadingItems(savedUsers,savedTopics)&&createResourceRating();
    }
    List<User> createUsers() {
        List<User> savedUsers=new ArrayList<User>();
        User user1=new User(email: "manvendra.singh@tothenew.com",username: "manvendra.singh",password: PASSWORD,confirmPassword: PASSWORD,firstName: "Manvendra",lastName: "Singh",admin: true,active: true);
        User user2=new User(email: "adit.kumar@tothenew.com",username: "adit.kumar",password: PASSWORD,confirmPassword: PASSWORD,firstName: "Adit",lastName: "Kumar",admin: false,active: true);

        if(saveUser(user1,savedUsers) && saveUser(user2,savedUsers)) {
//            log.info("user list created. Count : ${savedUsers.size()}\n");
        }
        return savedUsers;
    }

    Boolean saveUser(User user,List<User> savedUsers) {
        try {
             user.save(flush: true,failOnError: true)
//             log.info("New user Saved. Details : ${subscribedBy}\n");
             savedUsers.add(user);
             return true;
        }
        catch(ValidationException ve) {
            log.error("user Creation failed. Exception details : ${ve.toString()}\n");
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
//            log.info("Required Topics list per user created. Count : ${newTopics.size()}\n");
        }
        return savedTopics;
    }

    Boolean saveTopics(List<Topic> newTopics,List<Topic> savedTopics) {
        try {
            if(newTopics) {
                newTopics.each {
                    it.save(flush: true, failOnError: true);
//                    log.info("New com.tothenew.linkshare.topic Saved. Details : ${it}\n");
                    savedTopics.add(it);
                }
            }

            return true;
        }
        catch(ValidationException ve) {
            log.error("com.tothenew.linkshare.topic Creation failed. Exception details : ${ve.toString()}\n");
            return false
        }
    }

    Boolean createResources(List<Topic> savedTopics){
        try{
            savedTopics.each {
                new LinkResource(description: it.name+"->resource",createdBy: it.createdBy,topic: it,url: "http://www.download.com").save(failOnError:true);
                new LinkResource(description: it.name+"->resource",createdBy: it.createdBy,topic: it,url: "http://www.download.com").save(failOnError:true);
                DocumentResource documentResource1=new DocumentResource(description: it.name+"->resource",createdBy: it.createdBy,contentType:'application/pdf' ,topic: it,filePath: "/opt/bin/a1");
                DocumentResource documentResource2=new DocumentResource(description: it.name+"->resource",createdBy: it.createdBy,contentType:'application/pdf',topic: it,filePath: "/opt/bin/a2");
                documentResource1.contentType='application/pdf'
                documentResource2.contentType='application/pdf'
                documentResource1.save(failOnError:true)
                documentResource2.save(failOnError:true)
            }
//            log.info("Resources creation successful");
            return true;
        }
        catch(ValidationException ve){
            log.error("resource Creation failed. Exception details : ${ve.toString()}\n");
            return false;
        }
    }

    Boolean SubscribeTopics(List<User> savedUser,List<Topic> savedTopics) {
        savedUser.each {user->
            savedTopics.each{topic->
                if(!Subscription.findWhere(subscribedBy: user,topic:topic)){
                    try{
                          Subscription subscription=new Subscription(topic:topic, subscribedBy:user,seriousness:Seriousness.VERY_SERIOUS);
                          subscription.save(failOnError: true);
//                          log.info("New Subscription Created. Deatils : ${subscription}") ;
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

    Boolean createReadingItems(List<User> savedUsers,List<Topic> savedTopics){
        savedUsers.each {user->
            savedTopics.each {topic->
                if(Subscription.findWhere(subscribedBy:user,topic: topic)){
                    Resource.findAllWhere(topic: topic).each {resource->
                        if(!ReadingItem.findAllWhere(user: user,resource: resource)){
                            try{
                                ReadingItem readingItem=new ReadingItem(resource:resource,user:user,isRead: false);
                                readingItem.save(failOnError: true);
//                                log.info("New reading item created. Details : ${readingItem}");
                            }
                            catch(ValidationException ve){
                                log.error("Reading Item creation failed. Error Details : ${ve.toString()}");
                                return false;
                            }
                        }
                    }

                }
            }

        }
        return true;
    }

    Boolean createResourceRating(){
        ReadingItem.findAllByIsRead(false).each {
            try{
                ResourceRating resourceRating=new ResourceRating(ratedBy: it.user,resource: it.resource,score: 2);
                resourceRating.save(failOnError: true);
//                log.info("New resource rating created. Details : ${resourceRating}");
            }
            catch(ValidationException ve){
                log.error("resource rating creation failed. Error Details : ${ve.toString()}");
                return false;
            }
        }
        return true;
    }


    def destroy = {

    }

}
