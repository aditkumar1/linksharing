<%--
  Created by IntelliJ IDEA.
  User: ttnd
  Date: 29/2/16
  Time: 9:57 AM
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


<g:render template="/topic/templates/create" />
<g:render template="/documentResource/templates/create" model="[subscribedTopics: subscribedTopics]"/>
<g:render template="/linkResource/templates/create" model="[subscribedTopics: subscribedTopics]"/>
<g:render template="/topic/templates/email" model="[subscribedTopics: subscribedTopics]"/>



%{--<g:message code="login.index.array.out.of.bounds"/>--}%
%{--${g.message(code: "login.index.array.out.of.bounds")}--}%
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
            <g:render template="/templates/box-left" model="[user:user,subscribedTopics: subscribedTopics,createdTopics:createdTopics,trendingTopics:trendingTopics]"/>
        </div>
        <div id="box-right" class="col-xs-6">
            <g:render template="/templates/box-right"/>
        </div>
    </div>
</div>
</body>
</html>