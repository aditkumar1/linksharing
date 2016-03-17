<div class="container-fluid col-md-12 pull-right">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="panel-title row">
                <div class="col-md-8">Posts : (<%= topic.name %>)</div>
                <div class="col-md-4">
                    <g:form   role="search" controller="search" action="show">
                        <div class="input-group">
                            <g:textField width="20px" name="q" type="text" class="form-control" placeholder="Search" />
                            <div class="input-group-addon">
                                <a onclick="$(parent).parent().submit(); return false;" class="" style="cursor: pointer"><i class="glyphicon glyphicon-search"></i></a>
                            </div>
                        </div>
                    </g:form>
                </div>
            </div>
        </div>

        <div class="panel-body">
            <g:each in="${posts}" var="post">
                <div class="well">

                    <div class="row">
                        <div class="col-sm-3">
                            <ls:userImage userId="${post.createdBy?.id}"/>
                        </div>
                        <div class="col-sm-9">
                            <div class="row">
                                <span class="col-sm-6"><a href="${g.createLink(controller: 'user',action: 'profile',params: ['resourceSearchCO.id':post.createdBy.id])}">${post.createdBy.name}</a></span>
                                <span class="col-sm-6 text-muted">@${post.createdBy.username}</span>
                            </div>
                            <div class="row">
                                <h4>${post.topic.name}</h4>
                                <p>
                                    <%= post.description %>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <span class="col-sm-1 pull-left">
                            <i class="fa fa-facebook"></i>
                        </span>
                        <span class="col-sm-1 pull-left">
                            <i class="fa fa-twitter"></i> </span>
                        <span class="col-sm-1 pull-left">
                            <i class="fa fa-google-plus"></i></span>
                        <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="${g.createLink(controller: 'resource',action: 'show',id: post.id)}">view post</a></span>
                        <span class="pull-right" style="margin-right:10px;text-decoration:underline"><ls:markAsRead resource="${post}"/> </span>
                        <span class="pull-right" style="margin-right:10px;text-decoration:underline"><ls:displayResource resource="${post}"/> </span>
                    </div>
                </div>
            </g:each>
            <util:remotePaginate controller='resource' action="showPost" total="${totalPostCount}"
                                 update="showPostPlaceHolder" max="5" params="[topicId:posts.first().createdBy.id]"/>
        </div>
    </div>
</div>