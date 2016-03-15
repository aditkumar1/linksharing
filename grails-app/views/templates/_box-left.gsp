<div class="row">
    <g:render template="/user/templates/show" model="[user:user]"/>
</div>
<div class="row" id="subscriptionPlaceHolder">
    <g:render template="/subscription/templates/show" model="[subscribedTopics:subscribedTopics,totalSubscribedTopicCount:totalSubscribedTopicCount]"/>
</div>
   
 <!----------------------------------------------------------------Trending-------------------------------------------------->
<div class="row">
    <ls:trendingTopics/>
</div>
