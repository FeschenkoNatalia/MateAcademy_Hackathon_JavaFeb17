<%@include file="header.jsp"%>
<div class="jumbotron">
    <c:if test="${not empty logout}">
        <div class="msg">${logout}</div>
    </c:if>
    <form:form class="form-signin" method="post" action="/J_SPRING_SECURITY_CHECK" modelAttribute="users">
        <c:if test="${not empty error}">
            <div class="msg">${error}</div>
        </c:if>

            <c:forEach var="user" items="${users}">
                <h3 align="center"><c:out value = "${user.username}"/>
                <a href="<c:url value="/addfriend?user=${user.id}"/>" name="user" class="btn btn-large btn-primary">Add to friend</a></h3>
                <br>
            </c:forEach>

        <div align="center"><a href="<c:url value="/"/>" class="btn btn-large btn-primary">Home</a></div>

    </form:form>
</div>
</body>
</html>
