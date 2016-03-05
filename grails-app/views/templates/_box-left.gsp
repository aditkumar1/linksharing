
          <div class="panel panel-default">
      <div class="panel-body">
          <div class="row">
            <div class="col-sm-4">
              <asset:image class="img-thumbnail img-responsive" src="user.png" height="125px" width="100px"/>
            </div>
            <div class="col-sm-8">
              <div class="row">
                <span><h4><%=user.name %></h4></span>
              </div>
              <div class="row">
                <p class="text-muted">
                  @<%= user.username %>
                </p>
              </div>
              <div class="row">
                <span class="col-sm-6 text-muted pull-left">Subscriptions</span>
                <span class="col-sm-6 text-muted pull-left">Topics</span>
              </div>
              <div class="row">
                <span class="col-sm-6 pull-left"><a href="#"><%= subscribedTopics.size() %></a></span>
                <span class="col-sm-6 pull-left"><a href="#"><%= createdTopics.size() %></a></span>
              </div>
            </div>
          </div>
      </div>
    </div>

          <div class="panel panel-default">
            <div class="panel-heading">
			<span class="panel-title">Subscriptions</span>
			</div>
	        <ul class="list-group">
        <g:each in="${subscribedTopics}" var="topicVO">
            <li class="list-group-item">
                <div class="row" style="margin-bottom:5px">
                    <div class="col-sm-3">
                        <asset:image class="img-thumbnail img-responsive pull-left" src="user.png" height="75px" width="75px" />
                    </div>
                    <div class="col-sm-9">
                        <div class="row">
                            <span class="col-sm-4 pull-left"><a href="#">Grails</a></span>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 text-muted"><span>@<%= user.username %></span></div>
                            <div class="col-sm-4 text-muted"><span>Subscriptions</span></div>
                            <div class="col-sm-4 text-muted pull-right"><span>Topics</span></div>
                        </div>
                        <div class="row">
                            <span class="col-sm-4"><a href="#">Unsubscribe</a></span>
                            <span class="col-sm-4"><a href="#"><%= subscribedTopics.size() %></a></span>
                            <span class="col-sm-4"><a href="#"><%= createdTopics.size() %></a></span>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-xs-8">
                    <g:if test="${topicVO.createdBy==user}">
                        <span class="col-sm-4 pull-right">
                            <g:select name="visibility" from="${com.tothenew.linkshare.topic.Visibility.values()}" value="${topicVO.visibility}" class="form-control"/>
                        </span>
                    </g:if>
                    <span class="col-sm-4 pull-right">
                        <g:select name="seriousness" from="${com.tothenew.linkshare.user.Seriousness.values()}" class="form-control"/>
                    </span>
                    </div>
                    <div class="col-xs-4">
                    <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
                    <g:if test="${topicVO.createdBy==user}">
                        <span class="col-sm-1 pull-left glyphicon glyphicon-pencil" style="font-size:20px"></span>
                        <span class="col-sm-1 pull-left glyphicon glyphicon-trash" style="font-size:20px"></span>
                    </g:if>
                    </div>
                </div>
            </li>
        </g:each>
		</ul>
		</div>


   
 <!----------------------------------------------------------------Trending-------------------------------------------------->
          <div class="panel panel-default">
            <div class="panel-heading">
			<span class="panel-title">Trending Topics</span>
			</div>
        <ul class="list-group">
        <g:each in="${trendingTopics}" var="trendingTopic">
            <g:if test="${trendingTopic.createdBy==user}">
                <li class="list-group-item">
                    <div class="row" style="margin-bottom:5px">
                        <div class="col-sm-3">
                            <asset:image class="img-thumbnail img-responsive pull-left" src="user.png" height="75px" width="75px" />
                        </div>
                        <div class="col-sm-9">
                            <div class="row">
                                <span class="col-sm-4 text-muted">@<%= user.username %></span>
                                <span class="col-sm-4 text-muted">Subscriptions</span>
                                <span class="col-sm-4 text-muted pull-right">Topics</span>
                            </div>
                            <div class="row">
                                <span class="col-sm-4"><a href="#">Unsubscribe</a></span>
                                <span class="col-sm-4"><a href="#"><%= subscribedTopics.size() %></a></span>
                                <span class="col-sm-4"><a href="#"><%= createdTopics.size() %></a></span>
                            </div>
                        </div>
                    </div>
                    <div class="row form-group">
                        <span class="col-sm-4 pull-left">
                            <g:select name="seriousness" from="${com.tothenew.linkshare.user.Seriousness.values()}" class="form-control"/>
                        </span>
                        <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
                    </div>
                </li>

            </g:if>
            <g:elseif test="${subscribedTopics.any{trendingTopic}}">
                <li class="list-group-item">
                    <div class="row" style="margin-bottom:5px">
                        <div class="col-sm-3">
                            <asset:image class="img-thumbnail img-responsive pull-left" src="user.png" height="75px" width="75px" />
                        </div>
                        <div class="col-sm-9">
                            <div class="row">
                                <span class="col-sm-4 text-muted">@<%= user.username %></span>
                                <span class="col-sm-4 text-muted">Subscriptions</span>
                                <span class="col-sm-4 text-muted pull-right">Topics</span>
                            </div>
                            <div class="row">
                                <span class="col-sm-4"><a href="#">Unsubscribe</a></span>
                                <span class="col-sm-4"><a href="#"><%= subscribedTopics.size() %></a></span>
                                <span class="col-sm-4"><a href="#"><%= createdTopics.size() %></a></span>
                            </div>
                        </div>
                    </div>
                    <div class="row form-group">
                        <span class="col-sm-4 pull-left">
                            <g:select name="seriousness" from="${com.tothenew.linkshare.user.Seriousness.values()}" class="form-control"/>
                        </span>
                        <span class="col-sm-4 pull-left">
                            <g:select name="visibility" from="${com.tothenew.linkshare.topic.Visibility.values()}" value="${trendingTopic}" class="form-control"/>
                        </span>
                        <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
                        <span class="col-sm-1 pull-left glyphicon glyphicon-pencil" style="font-size:20px"></span>
                        <span class="col-sm-1 pull-left glyphicon glyphicon-trash" style="font-size:20px"></span>
                    </div>
                </li>
            </g:elseif>
            <g:else>

            </g:else>
        </g:each>


            </ul>

       </div>

