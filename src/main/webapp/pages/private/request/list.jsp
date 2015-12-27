<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:forEach var="item" items="${requests}">
    <c:out value="${item.firstName} ${item.lastName} ${item.patronymic}"/>
    <c:out value="${item.target}"/>
    <c:out value="${item.period}"/>
    <br>
</c:forEach>

<%--
    private boolean aproved;

    private String phoneNumber;

    private String firstName;

    private String target;

    private String lastName;

    private String patronymic;

    private Integer period; // месяцы--%>