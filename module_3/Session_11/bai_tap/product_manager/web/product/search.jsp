<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/14/2021
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/productServlet">Back to product list</a>
</p>
<h1>Products</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>

    </tr>
    <c:forEach items="${productServiceList}" var="product">
        <tr>
            <td><a href="/product?action=view&id=${product.id}">${product.getName()}</a></td>
            <td><c:out value="${product.price}"/></td>
            <td>${product.getDescription()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
