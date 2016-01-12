<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html ng-app="yourbank">
<head>
  <title>Yourbank</title>
  <link href="<c:url value="/css/internal/style.css"/>" rel="stylesheet" type="text/css">
  <link href="<c:url value="/css/external/bootstrap.css"/>" rel="stylesheet" type="text/css">
  <link href="<c:url value="/css/external/bootstrap-theme.css"/>" rel="stylesheet" type="text/css">
  <meta charset="utf-8">
</head>
<body ng-controller="GlobalController as global">

<script src="<c:url value="/js/external/angular/angular.js"/>"></script>
<script src="<c:url value="/js/external/angular/angular-route.js"/>"></script>
<script src="<c:url value="/js/external/angular/angular-mask.js"/>"></script>
<script src="<c:url value="/js/external/jquery/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/js/external/bootstrap/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/external/bootstrap/ui-bootstrap-tpls-0.14.3.js"/>"></script>
<script src="<c:url value="/js/external/lodash/lodash.js"/>"></script>

<script src="<c:url value="/js/internal/app.js"/>"></script>
<script src="<c:url value="/js/internal/controllers/GlobalController.js"/>"></script>
<script src="<c:url value="/js/internal/controllers/HomeController.js"/>"></script>
<script src="<c:url value="/js/internal/controllers/LoginController.js"/>"></script>
<script src="<c:url value="/js/internal/controllers/ProfileController.js"/>"></script>
<script src="<c:url value="/js/internal/controllers/CreateRequestController.js"/>"></script>
<script src="<c:url value="/js/internal/controllers/ManagerController.js"/>"></script>
<script src="<c:url value="/js/internal/controllers/AdminController.js"/>"></script>

<script src="<c:url value="/js/internal/services/current-user.service.js"/>"></script>

<div class="container-fluid">
  <jsp:include page="partials/header.jsp"/>
  <div class="container-fluid layout-center" data-layout>
    <div class="ui-layout-center">
      <div class="ng-view ui-layout-mask-inside-pane"></div>
    </div>
  </div>
  <div class="clearfix"></div>
</div>
</body>
</html>
