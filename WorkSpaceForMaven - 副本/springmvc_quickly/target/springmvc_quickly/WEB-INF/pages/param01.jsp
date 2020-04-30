<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user</title>
</head>
<body>
<form action="/param/saveUser" method="post">
    姓名：<input type="text" name="username"/><br>
    年龄：<input type="text" name="age"/><br>
    生日：<input type="text" name="birthday"/><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>