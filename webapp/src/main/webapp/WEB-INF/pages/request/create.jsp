<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">
    <form:form action="add_request" method="post" commandName="requestForm">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Заявка</h2></td>
            </tr>
            <tr>
                <td>User Name:</td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <%--<td><form:input type="date" pattern="dd/MM/yyyy"  path="period" value="<%=new Date()%>"/></td>--%>
            </tr>
            <tr>
                <td>Patronymic:</td>
                <td><form:input path="patronymic"/></td>
            </tr>
            <tr>
                <td>Target:</td>
                <td><form:input path="target"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Create"/></td>
            </tr>
        </table>
    </form:form>
</div>