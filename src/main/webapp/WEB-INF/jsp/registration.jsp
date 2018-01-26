<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Rejestracja</title>

        <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/static/css/common.css" rel="stylesheet">

        <style>
            .jumbotron{
                background-color:#009500;
                color:white;
            }
        </style>
    </head>

    <body>

        <div class="container">

          <center> <img src="static/images/fantasylocal.png" width="210" height="120">

            <div class="row">
                <div class="col-md-4">
                </div>
                <div class="col-md-4">
                    <div class="jumbotron text-center">

                        <h2>REJESTRACJA:</h2>
                        <form:form method="POST" modelAttribute="userForm" class="form-signin">

                            <spring:bind path="username">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="username" class="form-control" placeholder="Login"
                                                autofocus="true"></form:input>
                                    <form:errors path="username"></form:errors>
                                    </div>
                            </spring:bind>

                            <spring:bind path="password">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="password" path="password" class="form-control" placeholder="Hasło"></form:input>
                                    <form:errors path="password"></form:errors>
                                    </div>
                            </spring:bind>

                            <spring:bind path="passwordConfirm">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="password" path="passwordConfirm" class="form-control"
                                                placeholder="Powtórz hasło"></form:input>
                                    <form:errors path="passwordConfirm"></form:errors>
                                    </div>
                            </spring:bind>

                            <button class="btn btn-lg btn-primary btn-block" type="submit">Zarejestruj</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/static/js/bootstrap.min.js"></script>
    </body>
</html>
