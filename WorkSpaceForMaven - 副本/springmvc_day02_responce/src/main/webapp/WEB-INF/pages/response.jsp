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
    <title>resopnse</title>
</head>
<body>
<h3>返回字符串</h3>
<a href="/user/testReturnString">返回字符串</a><br>
<a href="/user/userUpdate">修改用户（表单回显）</a>
<br/>
<h3>无返回值void</h3>
<a href="/user/testVoid">无返回值</a>
<br/>
<h3>返回ModelAndView对象</h3>
<a href="/user/testModelAndView">ModelAndView</a>
<br/>
<h3>转发和重定向</h3>
<a href="/user/testForwardOrRedirect">ForwardOrRedirect</a>
<br/>
<h3>ResponseBody响应json数据</h3>
<input type="button" value="提交" id="btn"/>
</body>
</html>
