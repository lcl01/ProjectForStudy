<%--
  Created by IntelliJ IDEA.
  User: 龍城
  Date: 2019/9/15
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="param/saveAccount" method="post">
    账号: <input type="text" name="name"/><br>
    密码：<input type="password" name="password"/><br>
    用户姓名: <input type="text" name="user.username"/><br>
    用户年龄: <input type="text" name="user.age"/><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
