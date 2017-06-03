<%@include file="header.jsp"%>

<div class="container">
    <c:forEach  var="subscriber" items="${subscribers}">
        <div class="jumbotron">

            <h1><a href="<c:out value="/subscribers?id=${subscriber.id}"/>">
                <c:out value="${subscriber.username}"/>
            </a></h1>
            <p><a class="btn btn-lg btn-success" href="#" role="button">delete</a></p>
            <p><a class="btn btn-lg btn-success" href="<c:url value="/messages?recipient=${subscriber.id}"/>" role="button">send massage</a></p>
        </div>
    </c:forEach>
</div>


</body>
</html>