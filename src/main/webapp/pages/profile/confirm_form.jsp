<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06.01.2016
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/profile/confirm" method="post">
<input type="password" min="6" name="password" value="123456" id="password" placeholder="введите пароль"/>
<input type="password" min="6" name="password_confirm" value="123456" id="password_confirm" placeholder="повторите пароль"/>

    <input type="hidden" name="email" id="email" value="test@test.by" placeholder="повторите пароль"/>
    <input type="hidden" name="hash" id="hash" value="<%="test@test.by".hashCode()%>" placeholder="повторите пароль"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit" value="Сохранить"></button>
</form>