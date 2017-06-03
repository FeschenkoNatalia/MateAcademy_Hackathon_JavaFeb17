<%@include file="header.jsp"%>

<div class="container">
    <c:forEach  var="follower" items="${followers}">
        <div class="jumbotron">

            <h1><a href="<c:out value="/followers?id=${follower.id}"/>">
                <c:out value="${follower.username}"/>
            </a></h1>
            <p><a class="btn btn-lg btn-success" href="#" role="button">add to friends</a></p>
            <p><a class="btn btn-lg btn-success" href="<c:url value="/messages?recipient=${follower.id}"/>" role="button">send massage</a></p>
        </div>
    </c:forEach>
</div>


</body>
</html>