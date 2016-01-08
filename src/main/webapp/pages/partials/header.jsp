<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/#/"/>">YourBank</a>
    </div>

    <div class="collapse navbar-collapse">
      <%--<ul class="nav navbar-nav">--%>
        <%--<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
        <%--<li><a href="#">Link</a></li>--%>
        <%--<li class="dropdown">--%>
          <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
          <%--<ul class="dropdown-menu">--%>
            <%--<li><a href="#">Action</a></li>--%>
            <%--<li><a href="#">Another action</a></li>--%>
            <%--<li><a href="#">Something else here</a></li>--%>
            <%--<li role="separator" class="divider"></li>--%>
            <%--<li><a href="#">Separated link</a></li>--%>
            <%--<li role="separator" class="divider"></li>--%>
            <%--<li><a href="#">One more separated link</a></li>--%>
          <%--</ul>--%>
        <%--</li>--%>
      <%--</ul>--%>
      <div class="navbar-header-right navbar-right">
        <div ng-if="!global.current.user">
          <a href="<c:url value="/#/login"/>" type="button" class="btn btn-success navbar-btn">Log in</a>
        </div>
        <div ng-if="global.current.user">
          <span class="navbar-text">Logged as: <span class="well well-sm">{{global.current.user.name}}</span></span>
          <a href="<c:url value="/logout"/>" type="button" class="btn btn-success navbar-btn">Logout</a>
        </div>
      </div>
    </div>
  </div>
</div>