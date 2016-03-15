<%--
  Created by IntelliJ IDEA.
  User: ttnd
  Date: 6/3/16
  Time: 6:32 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>
<div id="header">
    <g:render template="/templates/header-dashboard"/>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12">
            <g:if test="${flash.error}">
                <label><%= flash.error %></label>
            </g:if>
        </div>
    </div>
    <div class="row">
        <div id="box-left" class="col-xs-6">
            <g:render template="/resource/templates/show" model="[resource:resource,ratingInfoVO:ratingInfoVO]"/>
        </div>
        <div id="box-right" class="col-xs-6">
            <ls:trendingTopics/>
        </div>
    </div>
</div>
</body>
</html>