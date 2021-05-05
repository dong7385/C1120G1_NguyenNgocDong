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
        <form method="post" action="/customer">
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="name" placeholder="Search"/>
            <button type="submit" class="btn btn-success">Search</button>
            <br>
        </form>
        <h4>
         <a class="btn btn-primary" href="../customer?action=create">Create</a>
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
