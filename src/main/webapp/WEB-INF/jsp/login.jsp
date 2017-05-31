<!DOCTYPE html>
<html lang="pl">
<head>
<meta charset="UTF-8">


<meta http-equiv="X-UA-Compatible" content="IE=edge">


<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Logowanie</title>
<link href="${contextPath}/static/css/bootstrap.css" rel="stylesheet">
<link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/static/css/common.css" rel="stylesheet">

<style>
.jumbotron{
    background-color:#b5953f;
    color:white;
}
/* Adds borders for tabs */
.tab-content {
    border-left: 1px solid #ddd;
    border-right: 1px solid #ddd;
    border-bottom: 1px solid #ddd;
    padding: 10px;
}
.nav-tabs {
    margin-bottom: 0;
}
</style>

</head>
<body>

<!-- CONTAINERS -->
<!-- container puts padding around itself while container-fluid fills the whole screen. Bootstap grids require a container. -->
<div class="container">

<!-- page-header adds space aroundtext and enlarges it. It also adds an underline at the end -->

<center> <img src="static/images/ligatyperow.png" width="200" height="140"> </center>


<div class="row">
<div class="col-md-4">

</div>

<div class="col-md-4">
<div class="jumbotron text-center">
  <form method="POST" action="${contextPath}/login" class="form-signin">
<h2>LOGOWANIE:</h2>

      <div class="form-group ${error != null ? 'has-error' : ''}">
      <span>${message}</span>
  <input name="username" type="text" class="form-control" placeholder="Login" autofocus="true"/>

  <input name="password" type="password" class="form-control" placeholder="Haslo"/>
  <span>${error}</span>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


    <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj sie</button>
</div>
</div>
</div>
</div>

<center><p>Jesli nie masz konta: <a href="${contextPath}/registration"> Zarejestruj sie</a></p></center>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
