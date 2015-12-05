<%@ page import="java.util.Currency" %>
<%@ page import="com.yourbank.bank.Credit" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">
    <form:form action="add_credit" method="post" commandName="creditForm">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Кредит</h2></td>
            </tr>
            <tr>
                <td>Название:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td><form:textarea path="description"/></td>
            </tr>
            <tr>
                <td>Валюта</td>
                <td><form:select path="currency" items="${currency}"/></td>
            </tr>
            <tr>
                <td>Максимальная сумма</td>
                <td><form:input type="number" path="maxSum"/></td>
            </tr>
            <tr>
                <td>Процентная ставка</td>
                <td><form:input type="number" path="percent"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Create"/></td>
            </tr>
        </table>
    </form:form>
</div>