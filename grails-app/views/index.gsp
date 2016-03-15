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





%{--<g:message code="login.index.array.out.of.bounds"/>--}%
%{--${g.message(code: "login.index.array.out.of.bounds")}--}%
<div class="container-fluid">
    <div class="row">
        <g:if test="${flash.message}">
            <div class="col-xs-12 alert alert-success">
                    <label><%= flash.message %></label>
            </div>
        </g:if>
    </div>
    <div class="row">
        <g:if test="${flash.error}">
            <div class="col-xs-12 alert alert-danger">
                <label><%= flash.error %></label>
            </div>
        </g:if>
    </div>
    <div class="row">
        <div id="box-left" class="col-xs-6">
            <g:render template="/templates/box-left" model="[user:user,subscribedTopics: subscribedTopics,createdTopics:createdTopics,trendingTopics:trendingTopics]"/>
        </div>
        <div id="box-right" class="col-xs-6">
            <g:render template="/templates/box-right" model="[inbox:inbox]"/>
        </div>
    </div>
</div>
</body>
</html>