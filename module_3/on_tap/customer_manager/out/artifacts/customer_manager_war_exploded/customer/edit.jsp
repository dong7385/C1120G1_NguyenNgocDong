<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap.bundle.css">
    <head>
        <title>Customer</title>
    </head>

<body>
<form method="post" action="customer">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${requestScope["customer"].getCustomerId()}">
<%--    chus ý kiểu chuoi id phải gióng với id ben customer Servlet ,tuong tu cho các truong khac cũng vay--%>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>customerName:</td>
                <td><input type="text" name="customerName" id="customerName"
                           value="${requestScope["customer"].getCustomerName()}"></td>
            </tr>
            <tr>
                <td>customerBirthday:</td>
                <td><input type="text" name="customerBirthday" id="customerBirthday"
                           value="${requestScope["customer"].getCustomerBirthday()}"></td>
            </tr>
            <tr>
                <td>customerGender:</td>
                <td><input type="text" name="customerGender" id="customerGender"
                           value="${requestScope["customer"].getCustomerGender()}"></td>
            </tr>
            <tr>
                <td>customerTypeId:</td>
                <td><input type="text" name="customerTypeId" id="customerTypeId"
                           value="${requestScope["customer"].customerType.getCustomerTypeId()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>

        </table>
    </fieldset>
</form>

</body>
</html>
