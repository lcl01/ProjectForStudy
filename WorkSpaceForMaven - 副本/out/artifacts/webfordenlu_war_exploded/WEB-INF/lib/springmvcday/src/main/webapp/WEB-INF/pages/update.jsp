<%--
  Created by IntelliJ IDEA.
  User: 龍城
  Date: 2019/9/15
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>修改用户</h3>
${ requestScope }
<form action="${pageContext.request.contextPath}/
user/update" method="post">
    姓名：<input type="text" name="username" value="${ user.username }"><br>
    密码：<input type="text" name="password" value="${ user.password }"><br>
    年龄：<input type="text" name="age" value="${ user.age }"><br>
    生日：<input type="text" name="age" value="${ user.birthday}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
