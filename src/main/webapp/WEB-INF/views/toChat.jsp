<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToChat</title>
</head>
<body>
    <form:form method="post" action="/toChat" modelAttribute="newMessage">
        <form:input type="hidden" path="sender.id" value="${sender.id}"/>
        <form:input type="hidden" path="recipient.id"  value="${recipient.id}"/>
        <form:input path="text" type="text"/>
        <button type="submit">Send</button>
    </form:form>
</body>
</html>
