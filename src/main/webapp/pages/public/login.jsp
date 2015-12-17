<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<c:url value="/login" var="loginUrl"/>--%>
<%--<form action="${loginUrl}" method="post">--%>
    <%--<c:if test="${param.error != null}">--%>
        <%--<p>--%>
            <%--Invalid username and password.--%>
        <%--</p>--%>
    <%--</c:if>--%>
    <%--<c:if test="${param.logout != null}">--%>
        <%--<p>--%>
            <%--You have been logged out.--%>
        <%--</p>--%>
    <%--</c:if>--%>
    <%--<p>--%>
        <%--<label for="username">Username</label>--%>
        <%--<input type="text" id="username" username="username"/>--%>
    <%--</p>--%>
    <%--<p>--%>
        <%--<label for="password">Password</label>--%>
        <%--<input type="password" id="password" username="password"/>--%>
    <%--</p>--%>
    <%--<input type="hidden" username="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    <%--<button type="submit" class="btn">Log in</button>--%>
<%--</form>--%>

<div class="login-content">
    <form class="public-form login" username="loginForm" ng-submit="login.submit(loginForm)" novalidate>
        <div class="form-group"
             ng-class="{ 'has-error': (loginForm.login.$touched || loginForm.login.$dirty) && loginForm.login.$invalid }">
            test
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <span>Login</span>
        </button>
    </form>
</div>