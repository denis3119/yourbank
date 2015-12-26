<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/#/"/>">YourBank</a>
    </div>

    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Logged as: <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/#/login"/>">Login</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</div>