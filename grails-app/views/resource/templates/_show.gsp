<div class="container-fluid col-md-12 pull-right">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-3">
                    <ls:userImage userId="${resource.createdBy?.id}"/>
                </div>
                <div class="col-sm-9">
                    <div class="row">
                        <span class="col-sm-6"><a href="#">${resource.createdBy.name}</a></span>
                        <span class="col-sm-6 text-right"><a href="#">${resource.topic.name}</a></span>
                    </div>

                    <div class="row">
                        <span class="col-sm-6 text-muted">@${resource.createdBy.username}</span>
                        <span id="time" class="col-sm-6 text-right text-muted">2:45 PM 22 Feb 2014</span>
                    </div>

                    <div class="row">
                        <span class="col-sm-12 text-muted pull-right">
                            <g:form name="rateForm" controller="resourceRating" action="save" params="[id:resource.id]">
                                <g:select from="[1,2,3,4,5]" name="score" value="${session.user?.getScore(resource)}">
                                </g:select>
                                <g:submitButton name="vote">Vote</g:submitButton>
                            </g:form>
                        </span>
                    </div>
                    <div class="row">
                        <p style="margin-left:2%">
                        ${resource.description}
                    </p>
                    </div>
                </div>
            </div>

            <div class="row">
                <span class="col-sm-1 pull-left">
                    <i class="fa fa-facebook"></i>
                </span>
                <span class="col-sm-1 pull-left">
                    <i class="fa fa-twitter"></i> </span>
                <span class="col-sm-1 pull-left">
                    <i class="fa fa-google-plus"></i></span>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="#">Delete</a></span>
                <g:if test="${session.user}">
                    <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="#">Edit </a></span>
                </g:if>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="#">Download </a></span>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="#">view full site </a></span>
            </div>
        </div>
    </div>
</div>