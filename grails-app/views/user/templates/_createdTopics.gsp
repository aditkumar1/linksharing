<div class="panel panel-default">
    <div class="panel-heading">
        <div class="panel-title row">
            <div class="col-md-4">Topics</div>
            <div class="col-md-1">
                <form class="form-search">
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="glyphicon glyphicon-search"></i>
                        </span>
                        <input type="text" placeholder="search">

                    </div>
                </form>
            </div>
        </div>
    </div>
    <ul class="list-group">
        <g:each in="${createdTopics}" var="topicVO">
            <li class="list-group-item">
                <div class="row" style="margin-bottom:5px">
                    <div class="col-sm-3">
                        <ls:userImage userId="${topicVO.createdBy?.id}"/>
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
                <ls:canUpdateTopic topic="${topicVO}"/>
            </li>
        </g:each>
    </ul>
</div>