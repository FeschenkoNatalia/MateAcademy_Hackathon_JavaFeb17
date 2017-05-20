<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet"  href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>">
    <style type="text/css">body{padding-top:40px;padding-bottom:40px;background-color:#f5f5f5;}.form-signin{max-width:300px;padding:19px 29px 29px;margin:0 auto 20px;background-color:#fff;border:1px solid #e5e5e5;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-webkit-box-shadow:0 1px 2px rgba(0,0,0,.05);-moz-box-shadow:0 1px 2px rgba(0,0,0,.05);box-shadow:0 1px 2px rgba(0,0,0,.05);}.form-signin .form-signin-heading,.form-signin .checkbox{margin-bottom:10px;}.form-signin input[type="text"],.form-signin input[type="password"]{font-size:16px;height:auto;margin-bottom:15px;padding:7px 9px;}</style>

</head>
<body>
    <form:form method="post" action="/registration" modelAttribute="newUser" class="form-signin">

        <form:label path="username">Login</form:label>
        <form:input class="input-block-level" type="text" path="username" placeholder="your login"/><br>

        <form:label path="password">Password</form:label>
        <form:input type="password" name="pass1" path="password" placeholder="example: pass1234"/></br>

        <form:label path="password">Confirm Password</form:label>
        <input type="password" name="pass2" placeholder="re-enter your password"/></br>

        <form:label path="email">Email</form:label>
        <form:input type="text" path="email" placeholder="example@gmail.com"/></br>

        <button type="submit" class="btn btn-large btn-primary">Registration</button>

    </form:form>
</body>
</html>
