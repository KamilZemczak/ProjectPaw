<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Fantasy Local League</title>

    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
<div class="container">
  <c:if test="${pageContext.request.userPrincipal.name != null}">
      <form id="logoutForm" method="POST" action="${contextPath}/logout">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </form>

      <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

      <a href="/home" class="navbar-brand">PAPA</a>



  </c:if>
  <nav class="navbar-fixed-top">
  <nav class="navbar navbar-default">
    <div class="container-fluid">


      <div class="navbar-header">


        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">

        <!-- Hides information from screen readers -->
          <span class="sr-only"></span>

          <!-- Draws 3 bars in navbar button when in small mode -->
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>

        <!-- You'll have to add padding in your image on the top and right of a few pixels (CSS Styling will break the navbar) -->
        <a class="pull-left" href="main.html#"><img src="static/images/ligatyperow.png" width="130" height="60"></a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
  	  <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><h4>Panel uzytkownika<span class="caret"></span></h4></a>
            <ul class="dropdown-menu">
              <li><a href="#PP" data-toggle="modal">Typuj mecze</a></li>
              <li><a href="#MB" data-toggle="modal">Twoje typy</a></li>
            </ul>
          </li>
          <li><a href="#"><h4>Wyniki meczow</h4></a></li>
          <li><a href="#"><h4>Klasyfikacja graczy</h4></a></li>
          <li><a href="#"><h4>Kontakt</h4></a></li>

        </ul>
        <!-- navbar-left will move the search to the left -->


        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form>
</c:if>

<button class = "pull-right btn-primary btn-sm"  onclick="document.forms['logoutForm'].submit()">Logout</button>



          </div>

      </div><!-- /.navbar-collapse -->
    </nav></nav>
    <br>   <br>   <br>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

    <center>   <h2>Welcome ${pageContext.request.userPrincipal.name} | <button class = "btn-primary btn-sm"  onclick="document.forms['logoutForm'].submit()">Logout</button></h2></center>

    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/static/js/bootstrap.min.js"></script>
</body>
</html>
