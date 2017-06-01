<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages2</title>
    <script src="<c:url value="/resources/bootstrap/js/jquery-3.2.1.min.js"/>"></script>
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

<div id="feedback"></div>


<form:form method="post" action="/messages" modelAttribute="newMessage" id="search-form">
    <input type=hidden class="form-control" value="${recipient.id}">
    <form:input path="text" id="btn-input" type="text" class="form-control input-sm" placeholder="Type your message here..." />
    <form:input path="status" id="btn-input" type="hidden" value="new" class="form-control input-sm"/>
    <form:input path="sender.id" value="${sender.id}" id="btn-input" type="hidden" class="form-control input-sm"/>
    <form:input path="recipient.id" value="${recipient.id}" id="btn-input" type="hidden" class="form-control input-sm"/>

    <button type="submit" class="btn btn-warning btn-sm" id="btn-chat">Send</button>
</form:form>

<script>
    jQuery(document).ready(function($) {
        $("#search-form").ondisplay(function(event) {

            event.preventDefault();
            searchViaAjax();

        });
    });

    function searchViaAjax() {
        var data = {}
        data["query"] = $("#query").val();

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/messages/update",
            data : JSON.stringify(data),
            dataType : 'json',
            timeout : 5000,
            success : function(data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error : function(e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done : function(e) {
                console.log("DONE");
            }
        });
    }

    function enableSearchButton(flag) {
        $("#btn-search").prop("disabled", flag);
    }

    function display(data) {
        var json = "<h4>Ajax Response</h4><pre>"
            + JSON.stringify(data, null, 4) + "</pre>";
        $('#feedback').html(json);
    }
</script>
</body>
</html>
