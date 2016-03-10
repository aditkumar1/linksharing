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
		%{--<div class="panel panel-default">--}%
			%{--<div class="panel-heading">--}%
				%{--<span class="panel-title" col-xs-3 pull-left>Topic</span>--}%
				%{--<span class="form-group col-xs-3 pull-right">--}%
  						%{--<select class="form-control" id="sel1">--}%
    							%{--<option>Today</option>--}%
    							%{--<option>1 Week</option>--}%
    							%{--<option>1 Month</option>--}%
    							%{--<option>1 Year</option>--}%
  						%{--</select>--}%
				%{--</span>--}%
			%{--</div>--}%
			%{--<div class="panel-body">--}%
        %{--<div class="well">--}%

          %{--<div class="row">--}%
            %{--<div class="col-sm-3">--}%
              %{--<img class="img-thumbnail img-responsive" src="user.png" height=125px width=100px>--}%
            %{--</div>--}%
            %{--<div class="col-sm-9">--}%
              %{--<div class="row">--}%
                %{--<span class="col-sm-4"><a href="#">Uday Pratap Singh</a></span><span class="col-sm-4 text-muted">@uday 5min</span><span class="col-sm-2"><a href="#">Grails</a></span>--}%
              %{--</div>--}%
              %{--<div class="row">--}%
                %{--<p>--}%
                  %{--Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. --}%
                %{--</p>--}%
              %{--</div>--}%
              %{--<div class="row">--}%
                %{--<span class="col-sm-1 pull-left"><i class="fa fa-facebook"></i> </span><span class="col-sm-1 pull-left"><i class="fa fa-twitter"></i> </span><span class="col-sm-1 pull-left"><i class="fa fa-google-plus"></i></span><span class="col-sm-4 pull-right"><a href="#">view post</a></span>--}%
              %{--</div>--}%
            %{--</div>--}%
          %{--</div>--}%
        %{--</div>--}%
			%{--</div>--}%
		%{--</div>--}%
            <ls:topPost/>
		</div>
        </div>

	</body>
</html>