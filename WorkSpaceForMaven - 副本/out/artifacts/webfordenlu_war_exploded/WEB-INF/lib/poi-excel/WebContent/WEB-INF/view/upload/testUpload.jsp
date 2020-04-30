<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.metadata.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {  
    $('body').on('change',$('#ImportPicInput'),function(){  
          $( "#importPicName").val($( "#ImportPicInput").val());  
    });  
    
    $.ajaxFileUpload({  
        type: "POST",  
        url: "/toolkit/importPicFile.do",  
        data:{picParams:text},//要传到后台的参数，没有可以不写  
        secureuri : false,//是否启用安全提交，默认为false  
        fileElementId:'ImportPicInput',//文件选择框的id属性  
        dataType: 'json',//服务器返回的格式  
        async : false,  
        success: function(data){  
            if(data.result=='success'){  
                //coding  
            }else{  
                //coding  
            }  
        },  
        error: function (data, status, e){  
            /coding  
        }  
    });  
}); 
</script>

</head>
<body>
<input type ="file" id="ImportPicInput" name= "myfile" style=" display: none" />  
      <div class ="input-append">  
             <label for ="importPicName"> 上传原始图片：</label >  
             <input type ="text" class="input-large" id= "importPicName" />  
             <a class ="btn btn-default" onclick= "$('#ImportPicInput').click();" > 打开</ a>  
      </div > 
       
</body>
</html>