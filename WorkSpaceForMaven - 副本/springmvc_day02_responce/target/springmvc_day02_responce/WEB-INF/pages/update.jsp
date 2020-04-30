<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>修改用户</h3>
<%--${ requestScope }--%>
<%--${pageContext.request.contextPath}--%>
<form action="/user/userUpdate" method="post">
    姓名：<input type="text" name="username" value="${ user.username }"><br>
    密码：<input type="text" name="password" value="${ user.password }"><br>
    年龄：<input type="text" name="age" value="${ user.age }"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>