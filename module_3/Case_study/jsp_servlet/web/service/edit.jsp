<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.css">
    <link rel="stylesheet" href="../assert/js/bootstrap.bundle.js">
    <head>
        <title>Service</title>
    </head>

<body>
<form method="post">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${requestScope["service"].getService_id()}">
<%--    chus ý kiểu chuoi id phải gióng với id ben customer Servlet ,tuong tu cho các truong khac cũng vay--%>
    <fieldset>
        <legend>Service information</legend>
        <table>
            <tr>
                <td>service_name:</td>
                <td><input type="text" name="service_name" id="service_name"
                           value="${requestScope["service"].getService_name()}"></td>
            </tr>
            <tr>
                <td>service_name:</td>
                <td><input type="text" name="service_area" id="service_area"
                           value="${requestScope["service"].getService_area()}"></td>
            </tr>
            <tr>
                <td>service_cost:</td>
                <td><input type="text" name="service_cost" id="service_cost"
                           value="${requestScope["service"].getService_cost()}"></td>
            </tr>
            <tr>
                <td>service_max_people:</td>
                <td><input type="text" name="service_max_people" id="service_max_people"
                           value="${requestScope["service"].getService_max_people()}"></td>
            </tr>

            <tr>
                <td>rentType:</td>
                <td><input type="text" name="rent_type_id" id="rent_type_id"
                           value="${requestScope["service"].rentType.getRent_type_id()}"></td>
            </tr>
            <tr>
                <td>serviceType:</td>
                <td><input type="text" name="service_type_id" id="service_type_id"
                           value="${requestScope["service"].serviceType.getService_type_id()}"></td>
            </tr>
            <tr>
                <td>standard_room:</td>
                <td><input type="text" name="standard_room" id="standard_room"
                           value="${requestScope["service"].getStandard_room()}"></td>
            </tr>
            <tr>
                <td>description_other_convenience:</td>
                <td><input type="text" name="description_other_convenience" id="description_other_convenience"
                           value="${requestScope["service"].getDescription_other_convenience()}"></td>
            </tr>
            <tr>
                <td>pool_area:</td>
                <td><input type="text" name="pool_area" id="pool_area"
                           value="${requestScope["service"].getPool_area()}"></td>
            </tr>
            <tr>
                <td>number_of_floors:</td>
                <td><input type="text" name="number_of_floors" id="number_of_floors"
                           value="${requestScope["service"].getNumber_of_floors()}"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Update Service"></td>
            </tr>

        </table>
    </fieldset>
</form>

</body>
</html>
