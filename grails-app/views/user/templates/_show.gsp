<div class="panel panel-default">
    <div class="panel-body">
        <div class="row">
            <div class="col-sm-4">
                <ls:userImage userId="${user.id}"/>
            </div>
            <div class="col-sm-8">
                <div class="row">
                    <span><a href="${g.createLink(controller: 'user',action: 'profile',params: ['resourceSearchCO.id':user.id])}"> <h4><%=user.name %></h4></a></span>
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
                    <span class="col-sm-6 pull-left"><ls:susbcriptionCount user="${user}"/> </span>
                    <span class="col-sm-6 pull-left"><ls:topicCount user="${user}"/></span>
                </div>
            </div>
        </div>
    </div>
</div>
