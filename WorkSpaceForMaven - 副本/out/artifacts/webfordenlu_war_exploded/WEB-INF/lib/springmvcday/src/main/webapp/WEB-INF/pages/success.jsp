<%--
  Created by IntelliJ IDEA.
  User: 龍城
  Date: 2019/9/14
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>文件上传成功</h1>
<%--<h1>访问成功</h1>--%>
<%--<h3>查询所有的数据</h3>--%>
<%--<c:forEach items="${list}" var="user">--%>
    <%--${ user.username }-----${user.password}<br>--%>
<%--</c:forEach> <br>--%>
<%--<%--%>
    <%--System.out.println("浏览器success.jsp执行...");--%>
<%--%>--%>
<%--<br>--%>
<h1>访问成功</h1>
<c:forEach items="${list}" var="account">
    ${account.id}---
    ${account.name}---
    ${account.money}<br>
</c:forEach>

</body>
</html>
