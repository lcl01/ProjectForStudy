<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>入门案例</h3>

<a href="hello">入门案例</a>
<a href="param/testParam?username=张三&age=18">入门案例1</a>
<form action="param/saveAccount" method="post">
    账号: <input type="text" name="name"/><br>
    密码：<input type="password" name="password"/><br>
    金钱: <input type="text" name="money"/><br>
    用户姓名: <input type="text" name="user.username"/><br>
    用户年龄: <input type="text" name="user.age"/><br>
    用户姓名（list)：<input type="text" name="list[0].username"/><br>
    用户年龄（list)：<input type="text" name="list[0].age"/><br>
    用户姓名（list)：<input type="text" name="list[1].username"/><br>
    用户年龄（list)：<input type="text" name="list[1].age"/><br>

    用户姓名（map)：<input type="text" name="map['one'].username"/><br>
    用户年龄（map)：<input type="text" name="map['one'].age"/><br>
    用户姓名（map)：<input type="text" name="map['two'].username"/><br>
    用户年龄（map)：<input type="text" name="map['two'].age"/><br>
    <input type="submit" value="提交">
</form>
<br>
<form action="param/saveUser" method="post">
    姓名：<input type="text" name="username"/><br>
    年龄：<input type="text" name="age"/><br>
    生日：<input type="text" name="birthday"/><br>
    <input type="submit" value="提交"/>
</form>
<br>
<a href="param/testServlet">测试ServletAPI</a>
<br>
<h3>RequestParam入门案例</h3>
<a href="anno/testRequestParam?name=哈哈&age=18">RequestParam</a><br>
<h3>@RequestBody</h3>
post请求jsp代码： <br>
<!-- request body注解 -->
<form action="anno/testRequestBody" method="post">
    用户名称：<input type="text" name="username" ><br/>
    用户密码：<input type="password" name="password" ><br/>
    用户年龄：<input type="text" name="age" ><br/>
    <input type="submit" value="保存">
</form>
get请求jsp代码： <br>
<a href="anno/testRequestBody?body=test">requestBody注解get请求</a><br>
<h3>@PathVariable注解</h3>
<!-- PathVariable注解 -->
<a href="anno/testPathVariable/100">pathVariable注解</a><br>
<form action="anno/testPathVariable" method="post">
    用户名称：<input type="text" name="username"><br/>
    <!-- <input type="hidden" name="_method" value="POST"> -->
    <input type="submit" value="保存"></form>
<hr/>
<!-- 更新 -->
<form action="anno/testPathVariable" method="post">
    用户名称：<input type="text" name="username"><br/>
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="更新">
</form>
<hr/>
<!-- 删除 -->
<form action="anno/testPathVariable/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除">
</form>
<hr/>
<!-- 查询一个 -->
<form action="anno/testPathVariable/1" method="post">
    <input type="hidden" name="_method" value="GET">
    <input type="submit" value="查询">
</form>
<hr/>
<h3>测试@RequestHeader注解</h3>
<!-- RequestHeader注解 -->
<a href="anno/testRequestHeader">获取请求消息头</a>
<hr>
<h3>测试@CookieValue注解</h3>
<!-- CookieValue注解 -->
<a href="anno/testCookieValue">CookieValue注解</a>
<hr>
<h3>测试@ModelAttribute注解</h3>
<!-- 修改用户信息 -->
<form action="anno/testModelAttribute" method="post">
    用户名称：<input type="text" name="username" ><br/>
    用户年龄：<input type="text" name="age" ><br/>
    <input type="submit" value="保存">
</form>
<br>
<h3>返回字符串</h3>
<a href="user/testReturnString">返回字符串</a><br>
<a href="user/userUpdate">修改用户（表单回显）</a>
<a href="response.jsp">修改用户（表单回显）1</a><br>
<a href="user/testFileUpload">文件上传</a>
<form action="user/testFileUpload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br>
    <input type="submit" value="上传"/><br>
</form>
<hr>
<form action="user/testFileUpload1" method="post" enctype="multipart/form-data">
    选择文件: <input type="file" name="upload"/>
    <input type="submit" value="上传"/>
</form>
<hr>
<a href="user/testException">异常处理</a><br>
<a href="user/testInterceptor">自定义拦截器</a>
<hr>
<h3>账号操作</h3>
<a href="account/findAll">查询所有</a>
<hr>
<form action="account/save" method="post">
    姓名： <input type="text" name="name"/><br>
    金额： <input type="text" name="money"/><br>
    <input type="submit" value="保存"><br>
</form>
</body>
</html>
