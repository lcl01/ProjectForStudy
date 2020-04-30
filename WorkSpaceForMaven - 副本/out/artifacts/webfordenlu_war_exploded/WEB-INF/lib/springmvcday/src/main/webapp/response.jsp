<%--
  Created by IntelliJ IDEA.
  User: 龍城
  Date: 2019/9/15
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery.min.js"></script>
<script>
    $(function(){
        $("#btn").click(function(){
//            data1=JSON.stringify({username:"tom",password:"123",age:30});
            $.ajax({
                url:'user/testJson',
                contentType:' application/json;charset=UTF-8',
                data:'{"username":"张鑫","password":"123","age":18}',
                dataType:'json',
                type:'post',
                success:function(data){
//                    alert(data);
//                    alert(data.addressName);
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
    <title>Title</title>
</head>

<body>
<h3>ResponseBody响应json数据</h3>
<input type="button" value="提交" id="btn"/><br>
<h3>有回值void</h3>
<a href="user/testVoid">无返回值</a><br>
<h3>返回ModelAndView对象</h3>
<a href="user/testModelAndView">ModelAndView</a><br>
<h3>转发和重定向</h3>
<a href="user/testForwardOrRedirect">ForwardOrRedirect</a>
</body>
</html>
