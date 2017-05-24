<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages2</title>
</head>
<body>
Кто : ${sender.username}
Кому: ${recipient.username}

<c:forEach var="message" items="${messages}">
    <tr>
        <td>
            <p><c:out value="${message.text}"/></p>
        </td>
    </tr>
</c:forEach>


<form:form method="post" action="/messages" modelAttribute="newMessage">
    <form:input path="text" id="btn-input" type="text" class="form-control input-sm" placeholder="Type your message here..." />
    <form:input path="status" id="btn-input" type="hidden" value="new" class="form-control input-sm"/>
    <form:input path="sender.id" value="${sender.id}" id="btn-input" type="hidden" class="form-control input-sm"/>
    <form:input path="recipient.id" value="${recipient.id}" id="btn-input" type="hidden" class="form-control input-sm"/>

    <button type="submit" class="btn btn-warning btn-sm" id="btn-chat">Send</button>
</form:form>
</body>
</html>
