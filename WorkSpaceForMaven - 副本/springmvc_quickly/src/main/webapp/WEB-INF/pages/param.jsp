<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>param form</title>
</head>
<body>
<form action="/param/saveAccount" method="post">
    账号：<input type="text" name="name"/><br>
    密码：<input type="text" name="password"/><br>
    金额：<input type="text" name="money"/><br>
    用户姓名：<input type="text" name="user.username"/><br>
    用户年龄：<input type="text" name="user.age"/><br>

    用户姓名（list)：<input type="text" name="list[0].username"/><br>
    用户年龄（list)：<input type="text" name="list[0].age"/><br>
    用户姓名（list)：<input type="text" name="list[1].username"/><br>
    用户年龄（list)：<input type="text" name="list[1].age"/><br>

    用户姓名（map)：<input type="text" name="map['one'].username"/><br>
    用户年龄（map)：<input type="text" name="map['one'].age"/><br>
    用户姓名（map)：<input type="text" name="map['two'].username"/><br>
    用户年龄（map)：<input type="text" name="map['two'].age"/><br>
    <input type="submit" value="提交"/>
</form>
<br/>
<a href="/param/testServlet">测试ServletAPI</a>
</body>
</html>