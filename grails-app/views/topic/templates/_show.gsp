<div class="panel panel-default">
    <div class="panel-heading">
        <span class="panel-title">Topic : <%= topic.name %></span>
    </div>
<div class="panel-body">
    <div class="row">
            <div class="col-sm-3">
                <asset:image class="img-thumbnail img-responsive pull-left" src="user.png" height="75px" width="75px" />
            </div>
            <div class="col-sm-9">
                <div class="row">
                    <span class="col-sm-12 pull-left"><a href="#">${topic.name}(${topic.visibility})</a></span>
                </div>
                <div class="row">
                    <div class="col-sm-4 text-muted"><span>@<%= topic.createdBy.username %></span></div>
                    <div class="col-sm-4 text-muted"><span>Subscriptions</span></div>
                    <div class="col-sm-4 text-muted pull-right"><span>Topics</span></div>
                </div>
                <div class="row">
                    <span class="col-sm-4"><ls:showSubscribe topicId="${topic.id}"/> </span>
                    <span class="col-sm-4"><ls:susbcriptionCount topicId="${topic.id}"/></span>
                    <span class="col-sm-4"><ls:resourceCount topicId="${topic.id}"/> </span>
                </div>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-xs-8">
                <span class="col-sm-4 pull-right">
                    <g:select name="seriousness" from="${com.tothenew.linkshare.user.Seriousness.values()}" class="form-control"/>
                </span>
            </div>
            <div class="col-xs-4">
                <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
            </div>
        </div>
</div>
</div>