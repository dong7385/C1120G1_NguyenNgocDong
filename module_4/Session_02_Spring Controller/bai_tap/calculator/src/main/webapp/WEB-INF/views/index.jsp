<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/30/2021
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="text" name="num1">
    <input type="text" name="num2"><br>
    <button type="submit" name="operator" value="+">Add</button>
    <button type="submit" name="operator" value="-">Sub</button>
    <button type="submit" name="operator" value="*">Mul</button>
    <button type="submit" name="operator" value="/">div</button>
</form>
<h2>Total: ${operator}:${total}</h2>
</body>
</html>
