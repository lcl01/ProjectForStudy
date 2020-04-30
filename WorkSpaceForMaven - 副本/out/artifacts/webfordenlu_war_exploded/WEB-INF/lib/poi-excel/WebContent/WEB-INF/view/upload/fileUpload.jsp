<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.metadata.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload</title>
<style type="text/css">
body{
padding-top:40px;
}
#main{
width:260px;
height:250px;
background-color:#0CF;
margin:auto;
}
#content{
padding-top:50px;
width:180px;
height:150px;
margin:auto;
text-align:left;
}
</style>
</head>
<!-- <body class="theme-blue">
	<div class="main-content clearfix">
		<div class="row clearfix"> -->
		<body>
		<script type="text/javascript">
		
		</script>
		<c:if test="${not empty message }">
				<div id="message" class="alert alert-success">
					<button class="close" data-dismiss="alert">x</button>
					${message }
				</div>
			</c:if>
			
		<div id="main">
			<div id="content">
			<form:form method="post" action="uploadFlie" enctype="multipart/form-data">
				<div class="form-group">
					 <input type="file" id="InputFile" name="file" class="form-control"  />
				</div>

<br>
				<div>
					<input  type="submit" value="Upload">
					<input  type="button" value="Cancel">
				</div>
			</form:form>
			</div>
		<!-- </div>
	</div> -->
	</div>
</body>
</html>