<%@page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>success</title>
<body>
<h1>访问成功</h1>
<c:forEach items="${list}" var="account">
    ${account.id}---
    ${account.name}---
    ${account.money}<br/>
</c:forEach>
</body>
</html>