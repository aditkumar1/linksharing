<div class="container-fluid col-md-12 pull-right">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="panel-title row">
                <div class="col-md-12">Posts</div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form class="form-search ">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="glyphicon glyphicon-search pagination-centered"></i>
                            </span>
                            <input type="text" placeholder="search">

                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="panel-body">
            <g:each in="${createdPosts}" var="post">
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
                        <span class="pull-right" style="margin-right:10px;text-decoration:underline"><ls:displayResource resource="${post}"/> </span>
                    </div>

                </div>
            </g:each>
            <div class="row">
                <util:remotePaginate controller='resource' action="createdPost" total="${totalCreatedPostCount}"
                                     update="createdPostPlaceHolder" max="5" params="[userId:createdPosts.first().createdBy.id]"/>
            </div>

        </div>
    </div>
</div>