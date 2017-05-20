<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Register</title>
</head>
<body>
    <form:form method="post" action="/registration" modelAttribute="newUser">

        <form:label path="login">Login</form:label>
        <form:input type="text" path="login"/><br>

        <form:label path="password">Password</form:label>
        <form:input type="password" path="password" placeholder="example password"/></br>

        <form:label path="confirmPassword">Confirm Password</form:label>
        <form:input type="password" path="confirmPassword" placeholder="example password"/></br>

        <form:label path="email">Email</form:label>
        <form:input type="text" path="email" placeholder="example@gmail.com"/></br>

        <button type="submit">Registration</button>

    </form:form>
</body>
</html>
