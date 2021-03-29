<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/29/2021
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Chuyển Đổi Tiền Tệ</title>
  </head>
  <body>
  <form method="post" action="/convert">
  <p>USD: <input type="text" name="usd"></p>
  <p>Rate: <input type="text" name="rate"></p>
  <input type="submit" value="ConVert">
  </form>
  </body>
</html>
