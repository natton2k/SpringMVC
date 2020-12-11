<%--
  Created by IntelliJ IDEA.
  User: natton
  Date: 29-Nov-20
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./resources/css/main.css">
    <script src="./resources/js/register.js"></script>
    <title>Register Page</title>
</head>
<body>
<h1>Register Page</h1>
<div id="registerForm">
    <table>
        <tr>
            <td>Username</td>
            <td id="usernameRow"><input type="text" id="txtUsername"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td id="passwordRow"><input type="password" id="txtPassword"/></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td id="confirmPassword"><input type="password" id="txtConfirmPassword"/></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td id="lastNameRow"><input type="text" id="txtLastname"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit" onclick="register()">Register</button>
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</div>
<a href="login">Click here to return to login</a>
</body>
</html>




