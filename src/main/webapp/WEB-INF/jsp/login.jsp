<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">


<meta http-equiv="X-UA-Compatible" content="IE=edge">


<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Logowanie</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">


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
<div class="page-header">
<center> <img src="static/images/ligatyperow.png" width="200" height="140"> </center>
</div>

<div class="row">
<div class="col-md-4">

</div>

<div class="col-md-4">
<div class="jumbotron text-center">

<h2>LOGOWANIE:</h2>
  <form class="navbar-form" role="search">
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Login">
    </div>
  </form>
  <form class="navbar-form" role="search">
<div class="form-group">
  <input type="password" class="form-control" placeholder="Haslo">
  </div>
  </form>
  <button href="#" type="submit" class = "btn-primary btn-sm">Zaloguj</button>
</div>
</div>

</div>
</div>

<center><p>Jesli nie masz konta: <a href="\register"> Zarejestruj sie</a></p></center>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
