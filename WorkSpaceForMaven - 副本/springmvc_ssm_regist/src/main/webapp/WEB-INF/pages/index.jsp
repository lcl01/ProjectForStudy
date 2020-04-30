<%--
  Created by IntelliJ IDEA.
  User: lc.L
  Date: 2020/3/10
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Sidebar toggle button-->
<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
    <span class="sr-only">Toggle navigation</span>
</a>
欢迎你：${sessionScope.loginUser.number}
</body>
</html>
