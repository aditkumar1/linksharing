<%@ page import="com.tothenew.linkshare.topic.Topic" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Link Sharing"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <asset:javascript src="jquery.validate.min.js"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


    <asset:stylesheet src="main.css"/>
    <g:layoutHead/>
</head>

<body>
<g:set var="subscribedTopics" value="${Topic.all}"></g:set>
<g:if test="${session.user}">
    <g:render template="/topic/templates/create" />
    <g:render template="/documentResource/templates/create" model="[subscribedTopics: subscribedTopics]"/>
    <g:render template="/linkResource/templates/create" model="[subscribedTopics: subscribedTopics]"/>
    <g:render template="/topic/templates/email" model="[subscribedTopics: subscribedTopics]"/>
</g:if>
<div id="header">
    <g:render template="/templates/header-dashboard"/>
</div>
<div class="container-fluid">
    <div class="row">
        <g:if test="${flash.message}">
            <div class="col-xs-12 alert alert-success">
                <label><%= flash.message %></label>
            </div>
        </g:if>
        <div class="col-xs-12 alert alert-success" style="display:none">
            <label id="messagePlaceholder"></label>
        </div>
    </div>
    <div class="row">
        <g:if test="${flash.error}">
            <div class="col-xs-12 alert alert-danger">
                <label><%= flash.error %></label>
            </div>
        </g:if>
    </div>
<g:layoutBody/>
</div>
<div id="ajaxSpinnerContainer">
    <asset:image src="spinner.gif" id="ajaxSpinnerImage" title="working..."/>
</div>
</body>
</html>
