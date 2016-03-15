<html>
    <body>
    <div class="row">
		<div class="container-fluid col-xs-12 pull-left">
		<div class="panel panel-default">
			<div class="panel-heading">
			<span class="panel-title">Recent Posts</span>
			</div>
		<div class="panel-body">
            <g:each var="posts" in="${recentPosts}">
                <div class="well">

                    <div class="row">
                        <div class="col-sm-3">
                            <ls:userImage userId="${posts.createdBy.id}"/>
                        </div>
                        <div class="col-sm-9">
                            <div class="row">
                                <span class="col-sm-4"><a href="${g.createLink(controller: 'user',action: 'profile',params: ["resourceSearchCO.id":posts.createdBy.id])}"><%= posts.createdBy.name %></a></span><span class="col-sm-4 text-muted">@<%= posts.createdBy.username %> 5min</span>
                            </div>
                            <div class="row">
                                <h4><%= posts.topic.name %></h4>
                                <p>
                                    <%= posts.description %>
                                </p>
                            </div>
                            <div class="row">
                                <span class="col-sm-1 pull-left"><i class="fa fa-facebook"></i> </span><span class="col-sm-1 pull-left"><i class="fa fa-twitter"></i> </span><span class="col-sm-1 pull-left"><i class="fa fa-google-plus"></i></span>
                                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="${g.createLink(controller: 'resource',action: 'show',id: posts.id)}">view post</a></span>
                                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><ls:displayResource resource="${posts}"/> </span>
                            </div>
                        </div>
                    </div>
                </div>
            </g:each>


			</div>
		</div>

            <ls:topPost/>
		</div>
        </div>

	</body>
</html>