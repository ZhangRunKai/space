<%--
  Created by IntelliJ IDEA.
  User: Z1358
  Date: 2020/7/6
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试json</title>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var user = {
                "id":2,
                "userName":"李四"
            };
            $.ajax({
                url:"/space_war/user/json",
                data:JSON.stringify(user),
                type:"POST",
                contentType:"application/json;charset=UTF-8",
                dataType:"JSON",
                success:function(data){
                    alert(data.id+"---"+data.userName);
                }
            })
        });
    </script>
</head>
<body>
</body>
</html>
