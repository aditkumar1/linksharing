<g:render template="/user/templates/show" model="[user:user]"/>

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
                            <div class="col-sm-4 text-muted"><span>@<%= topicVO.createdBy.username %></span></div>
                            <div class="col-sm-4 text-muted"><span>Subscriptions</span></div>
                            <div class="col-sm-4 text-muted pull-right"><span>Posts</span></div>
                        </div>
                        <div class="row">
                            <span class="col-sm-4"><ls:showSubscribe topicId="${topicVO.id}"/> </span>
                            <span class="col-sm-4"><ls:susbcriptionCount topicId="${topicVO.id}"/></span>
                            <span class="col-sm-4"><ls:resourceCount topicId="${topicVO.id}"/></span>
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
    <ls:trendingTopics/>