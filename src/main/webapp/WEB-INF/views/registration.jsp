<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Register</title>
</head>
<body>

    <form:form method="post" action="/registration" modelAttribute="newUser">

        <form:label path="username">Login</form:label>
        <form:input type="text" path="username"/><br>

        <form:label path="password">Password</form:label>
        <form:input type="password" name="pass1" path="password" placeholder="example password"/></br>

        <form:label path="password">Confirm Password</form:label>
        <input type="password" name="pass2" placeholder="example password"/></br>

        <form:label path="email">Email</form:label>
        <form:input type="text" path="email" placeholder="example@gmail.com"/></br>

        <button type="submit">Registration</button>

    </form:form>
</body>
</html>
