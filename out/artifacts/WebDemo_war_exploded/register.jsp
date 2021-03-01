<%--
  Created by IntelliJ IDEA.
  User: jackson
  Date: 2021/2/28
  Time: 11:21 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>注册界面</title>
</head>
<body>
<form action="RegistServlet" method="post">
    <h3>注册界面</h3>
    账号：<input name="username" type="text"><br>
    密码：<input name="password" type="password"><br>
    <input type="submit" value="注册">
</form>

</body>
</html>
