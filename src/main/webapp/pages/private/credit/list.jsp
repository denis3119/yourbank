<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:forEach var="item" items="${credits}">
    <c:out value="${item.name}"/>
    <c:out value="${item.description}"/>
    <c:out value="${item.currency}"/>
    <br>
</c:forEach>