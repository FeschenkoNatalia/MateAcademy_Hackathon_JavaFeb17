<%@include file="header.jsp"%>

<div class="container">
    <c:forEach  var="friend" items="${friends}">
        <div class="jumbotron">

                <h1><a href="<c:out value="/friends?id=${friend.id}"/>">
                    <c:out value="${friend.username}"/>
                </a></h1>
            <p><a class="btn btn-lg btn-success" href="#" role="button">delete</a></p>
            <p><a class="btn btn-lg btn-success" href="<c:url value="/messages?recipient=${friend.id}"/>" role="button">send massage</a></p>
        </div>
    </c:forEach>
</div>


</body>
</html>
