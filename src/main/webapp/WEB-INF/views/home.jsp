<%@include file="header.jsp"%>

<div class="container">

    <c:if test="${not empty logout}">
        <div class="msg">${logout}</div>
    </c:if>

    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
            <p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
            </p>
            <div class="jumbotron">
                <h1>${user.username}</h1>

            </div>

            <div class="row">
                <div class="col-xs-6 col-lg-4">
                    <h2>Settings</h2>
                    <p><a class="btn btn-default" href="settings.jsp" role="button">Settings &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <h2>Friends</h2>
                    <p><a class="btn btn-default" href="<c:url value="/friends"/>" role="button">Friends &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->

            </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->


    <footer>
        <p>&copy; 2016 Company, Inc.</p>
    </footer>

</div><!--/.container-->
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="../../dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="offcanvas.js"></script>
</body>
</html>
