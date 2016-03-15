<div class="panel panel-default">
    <div class="panel-heading">
        <span class="panel-title">Users : ${topic.name}</span>
    </div>
    <ul class="list-group">
        <g:each in="${subscribedUsers}" var="user">
            <li class="list-group-item">
                <g:render template="/user/templates/show" model="[user:user]"/>
            </li>
        </g:each>
        <li>
            <util:remotePaginate controller='subscription' action="subscribedUsers" total="${totalSubscribedUserCount}"
                                 update="subscribedUserPlaceholder" max="5" params="[topicId:topic.id]"/>
        </li>
    </ul>
</div>