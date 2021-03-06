<div class="row form-group">
    <div class="col-xs-8">
        <span class="col-sm-4 pull-right">
            <g:select name="visibility" id="visibility-${topic?.id}" from="${com.tothenew.linkshare.topic.Visibility.values()}" data-url="${g.createLink(controller: 'topic',action: 'update')}" data-id="${topic?.id}"  value="${topic.visibility}" class="form-control visibility"/>
        </span>
        <span class="col-sm-4 pull-right">
            <ls:showSeriousness topic="${topic}"/>
        </span>
    </div>
    <div class="col-xs-4">
        <a href='javascript:void(0)' class='topicInviteIcon' data-id="${topic?.id}"><span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span></a>
        <a href='javascript:void(0)' class='topicEditIcon' data-id="${topic?.id}"><span class="col-sm-1 pull-left glyphicon glyphicon-pencil" style="font-size:20px"></span></a>
        <a href='javascript:void(0)' class='topicDelete' id='topic-delete-${topic?.id}' data-url=${createLink(controller: "topic",action: "delete",id: topic?.id)}><span class="col-sm-1 pull-left glyphicon glyphicon-trash" style="font-size:20px"></span></a>
    </div>
</div>