<%--
  Created by IntelliJ IDEA.
  entity.User: 张梓健
  Date: 2024/4/20
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            text-align: center;
        }
    </style>
</head>
<body>
<form action="login" method="post">
    <h1>SSO Server</h1>
    Username: <input type="text" name="username" /><br/><br/>
    Password: <input type="password" name="password" /><br/><br/>
    <input type="submit" value="Login" />
</form>
</body>
</html>