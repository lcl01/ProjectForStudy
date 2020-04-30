<%@page contentType="text/html; charset=UTF-8" language="java" %>
<script src="../../js/jquery-1.11.0.min.js"></script>
<script>
    $(function(){
        $("#btn").click(function(){
            // alert("ok");
            $.ajax({
                url:"/user/testJson",
                contentType:"application/json;charset=UTF-8",
                data:'{"username":"tom","password":"123","age":30}',
                dataType:"json",
                type:"post",
                success:function(data){
                    alert(data);
                    alert(data.username);
                    alert(data.password);
                    alert(data.age);
                }

            });
        })
    })
</script>
<html>
<head>
    <title>fileUp</title>
</head>
<body>
<form action="/user/testFileUpload1" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"><br/>
    <input type="submit" value="上传">
</form>
<br/>
<form action="/user/testFileUpload2" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"><br/>
    <input type="submit" value="上传">

</form>
<br/>
<form action="/user/testFileUpload3" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"><br/>
    <input type="submit" value="上传">

</form>
<br/>
<a href="/user/testException">异常处理</a>
<br/>
<body>
<a href="/user/testInterceptor">自定义拦截器</a>
</body>
</body>
</html>