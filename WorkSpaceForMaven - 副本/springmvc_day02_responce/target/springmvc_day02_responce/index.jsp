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
    <title>hhhh</title>
</head>
<body>
<h2>Title</h2>
<a href="/user/re">响应页面</a>
<br/>
<a href="/user/up">更新页面</a>
<br/>
<a href="/user/userc">文件上传</a>
<br/>
</body>

</html>
