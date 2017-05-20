<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>${title}</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet"  href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>">


</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">НаЗв'язку</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" action="/search">
                <div class="form-group">
                    <input type="text" placeholder="Search" name="username" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Search</button>
            </form>
        </div>
    </div>
</nav>