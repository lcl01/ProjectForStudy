<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>上传结果</title>  
<script
	src="${pageContext.request.contextPath}/static/lib/jquery-1.11.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/lib/jquery.metadata.js"></script>
<script
	src="${pageContext.request.contextPath}/static/lib/jquery.validate.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>  
<body>  
<c:if test="${not empty fileurl }">
<script type="text/javascript">
var sure = confirm("文件上传成功，已保存至：\n"+'${fileurl}')
if(sure){
	window.history.go(-1);
}else{
	window.history.go(-1);
}
//alert("文件上传成功，已保存至：\n"+'${fileurl}')
</script>
</c:if>
</body>  
</html>  