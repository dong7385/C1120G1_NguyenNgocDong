<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.css">
    <link rel="stylesheet" href="../assert/js/bootstrap.bundle.js">
        <title>Customer</title>
    </head>
<body>
<form method="post" action="customer">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${requestScope["customer"].getCustomer_id()}">
<%--    chus ý kiểu chuoi id phải gióng với id ben customer Servlet ,tuong tu cho các truong khac cũng vay--%>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>customerTypeId:</td>
                <td><input type="text" name="customer_type_id" id="customer_type_id"
                           value="${requestScope["customer"].customerType.getCustomer_type_id()}"></td>
            </tr>
            <tr>
                <td>customerName:</td>
                <td><input type="text" name="customer_name" id="customer_name"
                           value="${requestScope["customer"].getCustomer_name()}"></td>
            </tr>
            <tr>
                <td>customerBirthday:</td>
                <td><input type="date" name="customer_birthday" id="customer_birthday"
                           value="${requestScope["customer"].getCustomer_birthday()}"></td>
            </tr>
            <tr>
                <td>customerGender:</td>
                <td><input type="text" name="customer_gender" id="customer_gender"
                           value="${requestScope["customer"].getCustomer_gender()}"></td>
            </tr>
            <tr>
                <td>customer_id_card:</td>
                <td><input type="text" name="customer_id_card" id="customer_id_card"
                           value="${requestScope["customer"].getCustomer_id_card()}"></td>
            </tr>

            <tr>
                <td>customer_phone:</td>
                <td><input type="text" name="customer_phone" id="customer_phone"
                           value="${requestScope["customer"].getCustomer_phone()}"></td>
            </tr>
            <tr>
                <td>customer_email:</td>
                <td><input type="text" name="customer_email" id="customer_email"
                           value="${requestScope["customer"].getCustomer_email()}"></td>
            </tr>
            <tr>
                <td>customer_address:</td>
                <td><input type="text" name="customer_address" id="customer_address"
                           value="${requestScope["customer"].getCustomer_address()}"></td>
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
