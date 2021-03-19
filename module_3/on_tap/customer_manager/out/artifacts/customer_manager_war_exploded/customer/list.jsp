<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap.bundle.css">
    <head>
        <title>Customer</title>
    </head>
<body>
<div class="container">
    <h2>Customer List</h2>

    <c:if test="${empty customerList}">
        <h3>User List Empty</h3>
    </c:if>

    <c:if test="${not empty customerList}">
        <form method="post" action="customer">
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="name" placeholder="Search"/>
            <button type="button"><a href="../customer?action=search&name">Search</a></button>
            <br>

        </form>
        <h4>
            <button type="button"><a href="../customer?action=create">Create</a></button>
        </h4>
        <table id="customer" class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Customer id</th>
                <th scope="col">Customer name</th>
                <th scope="col">Birthday</th>
                <th scope="col">Gender</th>
                <th scope="col">Customer type</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td><c:out value="${customer.customerId}"/></td>
                    <td><c:out value="${customer.customerName}"/></td>
                    <td><c:out value="${customer.customerBirthday}"/></td>
                    <td><c:out value="${customer.customerGender}"/></td>
                    <td><c:out value="${customer.customerType.customerTypeName}"/></td>

                    <td><a href="../customer?action=edit&id=${customer.customerId}">Edit</a></td>
                    <td><a href="../customer?action=delete&id=${customer.customerId}">Delete</a></td>
                    <td><a href="../customer?action=view&id=${customer.customerId}">View</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<%--<form action="../customer" method="post" id="deleteCustomer">--%>
<%--    <input type="hidden" name="action" value="delete">--%>
<%--    <input type="hidden" name="idCustomer" id="idCustomer">--%>
<%--</form>--%>
</body>
</html>
