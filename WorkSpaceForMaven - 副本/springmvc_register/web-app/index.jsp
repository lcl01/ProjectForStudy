<%--
  Created by IntelliJ IDEA.
  User: 龍城
  Date: 2019/9/17
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
  <body>
  <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
    <span class="sr-only">Toggle navigation</span>
  </a>
  欢迎你: ${sessionScope.loginUser.number}
  </body>
</html>
