<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/31/2021
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="email" method="post" modelAttribute="email">
    <table>
        <tr>
            <th><form:label path="languages">Language: </form:label></th>
            <td>
                <form:select path="languages">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="pageSize">Page Size</form:label></th>
            <td>Show
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th><form:label path="filter">Spams filter:</form:label></th>
            <td><form:checkbox path="filter" value="Enable spams filter"/>Enable spams filter</td>
        </tr>
        <tr>
            <th><form:label path="signature"> Signature: </form:label></th>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
                <input type="reset" value="Cancel">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
