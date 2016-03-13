<%@ page import="com.tothenew.linkshare.user.Subscription" %>
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="panel-title">Trending Topics</span>
    </div>
    <ul class="list-group">
        <g:each in="${trendingTopics}" var="trendingTopic">
            <li class="list-group-item">
                <div class="row" style="margin-bottom:5px">
                    <div class="col-sm-3">
                        <ls:userImage userId="${trendingTopic.createdBy?.id}"/>
                    </div>
                    <div class="col-sm-9">
                        <div class="row">
                            <div class="row">
                                <ls:showEditTopic topic="${trendingTopic}"/>
                            </div>
                            <div class="row">
                                <span class="col-sm-12 pull-left"><a href="${g.createLink(controller: 'topic',action: 'show',id: trendingTopic.id)}">${trendingTopic.name}</a></span>
                            </div>
                        </div>
                        <div class="row">
                            <span class="col-sm-4 text-muted">@<%= trendingTopic.createdBy.username %></span>
                            <span class="col-sm-4 text-muted">Subscriptions</span>
                            <span class="col-sm-4 text-muted pull-right">Posts</span>
                        </div>
                        <div class="row">
                            <span class="col-sm-4"><ls:showSubscribe topicId="${trendingTopic.id}"/> </span>
                            <span class="col-sm-4"><ls:susbcriptionCount topicId="${trendingTopic.id}"/></span>
                            <span class="col-sm-4"><ls:resourceCount topicId="${trendingTopic.id}"/> </span>
                        </div>
                    </div>
                </div>
                <ls:canUpdateTopic topic="${trendingTopic}"/>
            </li>
        </g:each>
    </ul>

</div>

