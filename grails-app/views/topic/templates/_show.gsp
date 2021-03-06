<div class="panel panel-default">
    <div class="panel-heading">
        <span class="panel-title">Topic : <%= topic.name %></span>
    </div>
<div class="panel-body">
    <div class="row">
            <div class="col-sm-3">
                <ls:userImage userId="${topic.createdBy?.id}"/>
            </div>
            <div class="col-sm-9">
                <div class="row">
                    <ls:showEditTopic topic="${topic}"/>
                </div>
                <div class="row">
                    <span class="col-sm-12 pull-left"><a href="${g.createLink(controller: 'topic',action:'show',id: topic.id )}">${topic.name}(${topic.visibility})</a></span>
                </div>
                <div class="row">
                    <div class="col-sm-4 text-muted"><span>@<%= topic.createdBy.username %></span></div>
                    <div class="col-sm-4 text-muted"><span>Subscriptions</span></div>
                    <div class="col-sm-4 text-muted pull-right"><span>Posts</span></div>
                </div>
                <div class="row">
                    <span class="col-sm-4"><ls:showSubscribe topicId="${topic.id}"/> </span>
                    <span class="col-sm-4"><ls:susbcriptionCount topicId="${topic.id}"/></span>
                    <span class="col-sm-4"><ls:resourceCount topicId="${topic.id}"/> </span>
                </div>
            </div>
        </div>
        <ls:canUpdateTopic topic="${topic}"/>
</div>
</div>