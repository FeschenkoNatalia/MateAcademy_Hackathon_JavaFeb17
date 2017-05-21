<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Login</title>

    <link rel="stylesheet"  href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>">
    <style type="text/css">body{padding-top:40px;padding-bottom:40px;background-color:#f5f5f5;}.form-signin{max-width:300px;padding:19px 29px 29px;margin:0 auto 20px;background-color:#fff;border:1px solid #e5e5e5;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-webkit-box-shadow:0 1px 2px rgba(0,0,0,.05);-moz-box-shadow:0 1px 2px rgba(0,0,0,.05);box-shadow:0 1px 2px rgba(0,0,0,.05);}.form-signin .form-signin-heading,.form-signin .checkbox{margin-bottom:10px;}.form-signin input[type="text"],.form-signin input[type="password"]{font-size:16px;height:auto;margin-bottom:15px;padding:7px 9px;}</style>

</head>
<body>
<div class="container">
    <c:if test="${not empty logout}">
        <div class="msg">${logout}</div>
    </c:if>
    <form:form class="form-signin" method="post" action="/login" modelAttribute="user">
        <c:if test="${not empty error}">
            <div class="msg"><h4 style="color: red">${error}</h4></div>
        </c:if>
        <form:label path="username">Name</form:label>
        <form:input class="input-block-level" type="text" path="username"/>

        <form:label path="password">Password</form:label>
        <form:input class="input-block-level" path="password" type="password"/>

        <button class="btn btn-large btn-primary" type="submit">Log In</button>
        <h6>or</h6>
        <a href="<c:url value="/registration"/>" class="btn btn-large btn-primary">Registration</a>
        </form:form>
</div>



</body>
</html>