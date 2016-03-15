<div class="row">
    <g:render template="/user/templates/show" model="[user:user]"/>
</div>
<div class="row" id="createdTopicPlaceHolder">
    <g:render template="/user/templates/createdTopics" model="[createdTopics:createdTopics]"/>
</div>
<div class="row" id="subscriptionPlaceHolder">
    <g:render template="/subscription/templates/show" model="[subscribedTopics:subscribedTopics]"/>
</div>
