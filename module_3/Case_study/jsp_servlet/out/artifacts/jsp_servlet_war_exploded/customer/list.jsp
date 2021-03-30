<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
    <head>
        <title>Customer</title>
    </head>
<body>
<jsp:include page="../assert/style/header.jsp"/>
<div class="container-fluid">
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
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Customer id</th>
                <th scope="col">customer Type</th>
                <th scope="col">customer_name</th>
                <th scope="col">customer_birthday</th>
                <th scope="col">customer_gender</th>
                <th scope="col">customer_id_card</th>
                <th scope="col">customer_phone</th>
                <th scope="col">customer_email</th>
                <th scope="col">customer_address</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody id="customer" >
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td><c:out value="${customer.customer_id}"/></td>
                    <td><c:out value="${customer.customerType.customer_type_name}"/></td>
                    <td><c:out value="${customer.customer_name}"/></td>
                    <td><c:out value="${customer.customer_birthday}"/></td>
                    <td><c:out value="${customer.customer_gender}"/></td>
                    <td><c:out value="${customer.customer_id_card}"/></td>
                    <td><c:out value="${customer.customer_phone}"/></td>
                    <td><c:out value="${customer.customer_email}"/></td>
                    <td><c:out value="${customer.customer_address}"/></td>


                    <td><a href="../customer?action=edit&id=${customer.customer_id}">Edit</a></td>
                    <td><a href="../customer?action=delete&id=${customer.customer_id}">Delete</a></td>
                    <td><a href="../customer?action=view&id=${customer.customer_id}">View</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>


<script src="../jquery/jquery-3.5.1.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

<script>
    $(document).ready(function () {
        $('#customer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })
</script>
</body>
</html>