<%@ page import="com.tothenew.linkshare.user.Subscription" %>
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
                                <span class="col-sm-4 text-muted">@<%= trendingTopic.createdBy.username %></span>
                                <span class="col-sm-4 text-muted">Subscriptions</span>
                                <span class="col-sm-4 text-muted pull-right">Topics</span>
                            </div>
                            <div class="row">
                                <span class="col-sm-4"><a href="#">Unsubscribe</a></span>
                                <span class="col-sm-4"><a href="#"><%= 50 %></a></span>
                                <span class="col-sm-4"><a href="#"><%= 40 %></a></span>
                            </div>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-xs-8">
                            <span class="col-sm-4 pull-right">
                                <g:select name="visibility" from="${com.tothenew.linkshare.topic.Visibility.values()}" value="${trendingTopic.visibility}" class="form-control"/>
                            </span>
                            <span class="col-sm-4 pull-right">
                                <g:select name="seriousness" from="${com.tothenew.linkshare.user.Seriousness.values()}" class="form-control"/>
                            </span>
                        </div>
                        <div class="col-xs-4">
                            <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
                            <span class="col-sm-1 pull-left glyphicon glyphicon-pencil" style="font-size:20px"></span>
                            <span class="col-sm-1 pull-left glyphicon glyphicon-trash" style="font-size:20px"></span>
                        </div>
                    </div>
                </li>

            </g:if>
            <g:elseif test="${"com.tothenew.linkshare.user.Subscription.findWhere(topic:trendingTopic,subscribedBy: user )"}">
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
                                <span class="col-sm-4"><a href="#"><%=50 %></a></span>
                                <span class="col-sm-4"><a href="#"><%= 50 %></a></span>
                            </div>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-xs-8">
                            <span class="pull-right col-xs-8">
                                <g:select name="seriousness" from="${com.tothenew.linkshare.user.Seriousness.values()}" class="form-control"/>
                            </span>
                        </div>
                        <div class="col-xs-4">
                            <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
                        </div>
                    </div>
                </li>
            </g:elseif>
            <g:else>
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
                                <span class="col-sm-4"><a href="#">Subscribe</a></span>
                                <span class="col-sm-4"><a href="#"><%= 77 %></a></span>
                                <span class="col-sm-4"><a href="#"><%= 12 %></a></span>
                            </div>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-xs-8">
                            <span class="pull-right col-xs-8">
                                <g:select name="seriousness" from="${com.tothenew.linkshare.user.Seriousness.values()}" class="form-control"/>
                            </span>
                        </div>
                        <div class="col-xs-4">
                            <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
                        </div>
                    </div>
                </li>
            </g:else>
        </g:each>
    </ul>

</div>

