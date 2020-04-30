<%@page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Title</h2>
<h1>访问页面成功</h1>
<br/>
<h1>访问成功</h1>
<h3>查询所有的数据</h3>
<c:forEach items="${ list }" var="user">
    ${ user.username }-----${user.password}<br>
</c:forEach>
</body>
</html>
