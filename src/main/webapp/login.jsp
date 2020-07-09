<%--
  Created by IntelliJ IDEA.
  User: Z1358
  Date: 2020/7/9
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var user = {
                "userName":"zhangsan",
                "userPassword":"test"
            };
            $.ajax({
                url:"/space_war/user/login",
                data:JSON.stringify(user),
                type:"POST",
                contentType:"application/json;charset=UTF-8",
                dataType:"JSON",
                success:function(data){
                    alert(data.code+"---"+data.message+"----"+data.data);
                    $("#test").html(data.data); //在html页面id=test的标签里显示html内容
                }
            })
        })
    </script>
</head>
<body>
<div id="test"></div>
</body>
</html>
