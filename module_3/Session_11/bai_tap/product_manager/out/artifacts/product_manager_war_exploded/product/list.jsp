
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<jsp:include page="../index.jsp" />
<div class="container">
    <h2>Product List</h2>

    <c:if test="${empty productServiceList}">
        <h3>Product List Empty</h3>
    </c:if>

    <c:if test="${not empty productServiceList}">
        <form>
            <input type="hidden" name="actionUser" value="search"/>
            <input type="text" name="name" placeholder="Search"/>
            <input type="submit" value="Search"/>
        </form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>price</th>
                <th>Description</th>
                <th>Maker</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productServiceList}" var="product">
                <tr>
                    <td>${product.getId()}</td>
                    <td><a href="/product?action=view&id=${product.id}">${product.getName()}</a></td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getDescription()}</td>
                    <td>${product.getMaker()}</td>
                    <td><a href="/product?action=edit&id=${product.id}">Edit</a></td>
                    <td><a href="/product?action=delete&id=${product.id}">Delete</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>
