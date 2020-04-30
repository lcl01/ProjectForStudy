<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<heml>
    <head>
        <title>anno</title>
    </head>
    <body>
    <h3>RequestParam入门案例</h3>

    <a href="/param/testRequestParam?name=哈哈&age=22">RequestParam</a>

    <br/>
    <h3>@RequestBody</h3>
    post请求jsp代码： <br>
    <!-- request body注解 -->
    <form action="/param/testRequestBody" method="post">
        用户名称：<input type="text" name="username" ><br/>
        用户密码：<input type="password" name="password" ><br/>
        用户年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="保存">
    </form>
    get请求jsp代码： <br>
    <a href="/param/testRequestBody?body=test">requestBody注解get请求</a>
    <br/>
    <h3>@PathVariable注解</h3>
    <!-- PathVariable注解 -->
    <a href="/param/testPathVariable/100">pathVariable注解</a>
    <br/>
    <form action="/param/testPathVariable" method="post">
        用户名称：<input type="text" name="username"><br/>
        <!-- <input type="hidden" name="_method" value="POST"> -->
        <input type="submit" value="保存"></form>
    <hr/>
    <!-- 更新 -->
    <form action="/param/testPathVariable" method="post">
        用户名称：<input type="text" name="username"><br/>
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="更新">
    </form>
    <hr/>
    <!-- 删除 -->
    <form action="/param/testPathVariable/1" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="删除">
    </form>
    <hr/>
    <!-- 查询一个 -->
    <form action="/param/testPathVariable/1" method="post">
        <input type="hidden" name="_method" value="GET">
        <input type="submit" value="查询">
    </form>
    <hr/>
    <br/>
    <h3>测试@RequestHeader注解</h3>
    <!-- RequestHeader注解 -->
    <a href="/param/testRequestHeader">获取请求消息头</a>
    <br/>
    <h3>测试@CookieValue注解</h3>
    <!-- CookieValue注解 -->
    <a href="/param/testCookieValue">CookieValue注解</a>
<br/>
    <h3>测试@ModelAttribute注解</h3>
    需求： 修改用户信息，要求用户的日期不能修改 jsp的代码：
    <!-- 修改用户信息 -->
    <form action="/param/testModelAttribute" method="post">
        用户名称：<input type="text" name="username" ><br/>
        用户年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="保存">
    </form>
    <br/>
    <h3>测试@ModelAttribute注解</h3>
    需求： 修改用户信息，要求用户的日期不能修改 jsp的代码：
    <!-- 修改用户信息 -->
    <form action="/param/testModelAttribute01" method="post">
        用户名称：<input type="text" name="username" ><br/>
        用户年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="保存">
    </form>
    <br/>
    <h3>测试@ModelAttribute注解</h3>
    需求： 修改用户信息，要求用户的日期不能修改 jsp的代码：
    <!-- 修改用户信息 -->
    <form action="/param/testModelAttribute02" method="post">
        用户名称：<input type="text" name="username" ><br/>
        用户年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="保存">
    </form>
    <br/>
    <h3>测试@SessionAttributes注解</h3>
    <!-- SessionAttribute注解的使用 -->
    <a href="/param/sessionAttributePut">存入SessionAttribute</a> <hr/>
    <a href="/param/sessionAttributeGet">取出SessionAttribute</a> <hr/>
    <a href="/param/sessionAttributeClean">清除SessionAttribute</a>
    </body>
</heml>