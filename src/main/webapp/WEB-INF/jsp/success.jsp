<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/4/28
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h2><br><font style="color: green">成功导入啦，，，兄弟姐妹们！！！!</font></h2><br/><br/>
    <div>
        <form action="/user/queryById" property="account" method="post" align="center">
            <input style="height: 25px" class="text" name="account">
            <button style="height: 25px" class="btn btn-warning"  type="submit" >登录</button>
        </form>
    </div>
</body>
</html>
