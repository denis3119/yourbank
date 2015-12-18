<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">
    <form:form action="add_request" method="post" commandName="requestForm">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Заявка</h2></td>
            </tr>
            <tr>
                <td>Имя:</td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td>Фамилия:</td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td>Отчество:</td>
                <td><form:input path="patronymic"/></td>
            </tr>
            <tr>
                <td>Количтсево месяцев:</td>
                <td><form:input type="number" path="period" min="3" max="100" value="12"/></td>
            </tr>
            <tr>
                <td>Цель:</td>
                <td><form:input path="target"/></td>
            </tr>
            <%--<tr>--%>
                <%--<td>Кредит</td>--%>
                <%--<td><form:select path="creditName" items="${credits}"/></td>--%>
            <%--</tr>--%>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Подать"/></td>
            </tr>
        </table>
    </form:form>
</div>