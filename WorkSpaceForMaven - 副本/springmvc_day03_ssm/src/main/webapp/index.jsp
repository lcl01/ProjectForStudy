<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<title>ssm</title>
<body>
<h3>账号操作</h3>
<a href="/account/findAll">查询所有账号</a>
<br/>
<form action="/account/save" method="post">
    姓名：<input type="text" name="name"><br/>
    金额：<input type="text" name="money"> <br/>
    <input type="submit" value="提交"/>
</form>
<br/>
</body>
</html>
