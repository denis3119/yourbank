<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/#/"/>">YourBank</a>
    </div>

    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li  ng-if="global.current.user"><a href="<c:url value="/#/profile"/>">Profile</a></li>
      </ul>
      <div class="navbar-header-right navbar-right">
        <div ng-if="!global.current.user">
          <a href="<c:url value="/#/login"/>" type="button" class="btn btn-success navbar-btn">Log in</a>
        </div>
        <div ng-if="global.current.user">
          <span class="navbar-text">Logged as: <span class="well well-sm">{{global.current.user.email}}</span></span>
          <a href="<c:url value="/logout"/>" type="button" class="btn btn-success navbar-btn">Logout</a>
        </div>
      </div>
    </div>
  </div>
</div>