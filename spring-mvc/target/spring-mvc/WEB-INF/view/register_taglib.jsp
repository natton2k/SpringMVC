<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: natton
  Date: 14-Dec-20
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./resources/css/main.css">
    <title>Register Using Spring Taglib</title>
</head>
<body>
    <h1>Register Page</h1>
    <form:form method="post" action="registerTaglib" modelAttribute="user">
        <table>
            <tr>
                <td>
                    <form:label path="username">Username</form:label>
                </td>
                <td>
                    <form:input path="username"/>
                </td>
                <td>
                    <form:errors path="username" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Password</form:label>
                </td>
                <td>
                    <form:password path="password"/>
                </td>
                <td>
                    <form:errors path="password" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="confirmPassword">Confirm password</form:label>
                </td>
                <td>
                    <form:password path="confirmPassword"/>
                </td>
                <td>
                    <form:errors path="confirmPassword" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="lastname">Last name</form:label>
                </td>
                <td>
                    <form:input path="lastname"/>
                </td>
                <td>
                    <form:errors path="lastname" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Register"/>
                    <input type="reset" value="Reset"/>
                </td>
            </tr>
        </table>
    </form:form>
    <a href="login">Return to login</a>
</body>
</html>
