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
                                <span class="col-sm-4"><a href="#"><%= posts.createdBy.name %></a></span><span class="col-sm-4 text-muted">@<%= posts.createdBy.username %> 5min</span>
                            </div>
                            <div class="row">
                                <h4><%= posts.topicName %></h4>
                                <p>
                                    <%= posts.description %>
                                </p>
                            </div>
                            <div class="row">
                                <span class="col-sm-1 pull-left"><i class="fa fa-facebook"></i> </span><span class="col-sm-1 pull-left"><i class="fa fa-twitter"></i> </span><span class="col-sm-1 pull-left"><i class="fa fa-google-plus"></i></span><span class="col-sm-4 pull-right"><a href="#">view post</a></span>
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