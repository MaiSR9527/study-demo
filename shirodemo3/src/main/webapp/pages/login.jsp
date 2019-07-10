<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/loginUser" method="post">
        用户名：<input type="text" name="username"><br>
        密 码：<input type="password" name="password"><br>
        <button type="submit">登录</button>
    </form>
</body>
</html>
