<%@include file="header.jsp" %>
email.img = "/WEB-INF/resources/bootstrap/img/email.png"
<head>
    <meta content="text/html">
</head>

<div class="container">
    <h1><c:out value="${map.1}"/></h1>
    <c:forEach var="friend" items="${friends}">
        <div class="jumbotron">

            <h1><a href="<c:out value="/friends?id=${friend.id}"/>">
                <c:out value="${friend.username}"/>
            </a></h1>
            <p><a class="btn btn-lg btn-success" href="#" role="button">delete</a></p>
            <p><a class="btn btn-lg btn-success" href="/messages?recipient=${friend.id}" role="button">send massage</a>
                <c:if test="${numberOfNotReadMessages > 0}">
                    ${numberOfNotReadMessages}
                    <img src="<c:url value="/resources/bootstrap/img/email.png"/>" style="width:24px;height:24px;">
                </c:if>
            </p>

        </div>
    </c:forEach>
</div>


</body>
</html>
