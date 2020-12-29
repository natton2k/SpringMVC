<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="login" method="POST">
    Username <input type="text" name="txtUsername"/> <br/>
    Password <input type="password" name="txtPassword"/> <br/>
    <input type="submit" name="btnLogin" value="Login"/>
    <input type="reset" value="Reset"/>
</form>
<a href="register_taglib">Click here to create new account</a>
<br>
<a href="shop">Click here to buy book</a>
</body>
</html>
