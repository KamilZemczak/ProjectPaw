<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta http-equiv="Expires" content="Sat, 01 Dec 2001, 00:00:00 GMT">

        <title>Task Manager | Home</title>

        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/css/style.css" rel="stylesheet">

        <!--[if lt IE 9]>
        <script src="static/js/html5shiv.min.js"></script>
        <script src="static/js/respond.min.js"></script>
        <!endif]-->
    </head>
    <body>


        <div class="navbar navbar-inverse">
            <!--<a class="pull-left" href="index.html"><img src="static/images/ligatyperow2.png" width="100" height="50"></a><!-->

            <a href="/" class="navbar-brand">Strona glowna</a>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">                 
                  
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Panel uzytkownika
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                              <sec:authorize access="hasRole('ADMIN')"><li><a href="bet-games">Obstaw mecz</a></li></sec:authorize
                            <li><a href="your-games">Twoje typy</a></li>
                        </ul></li>>
                    <li class="dropdown">                       
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Panel administratora
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="new-game">Dodaj nowy mecz</a></li>
                            <li><a href="all-games">Zarzadzaj meczami</a></li>
                        </ul>  </li>
                    <li><a href="#">Klasyfikacja graczy</a></li>
                    <li><a href="#">Kontakt</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <form id="logoutForm" method="POST" action="${contextPath}/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </c:if>

                    <li><a onclick="document.forms['logoutForm'].submit()" href="#"><span class="glyphicon glyphicon-log-out" ></span> Wyloguj </a></li>

                </ul>
            </div>

        </div>


        <c:choose>
            <c:when test="${mode == 'MODE_HOME'}">
                <div class="container" id="homeDiv">
                    <div class="jumbotron text-center">
                        <h1>Witaj w lidze typerow ${pageContext.request.userPrincipal.name}.</h1>
                    </div>
                </div>
            </c:when>
            <c:when test="${mode == 'MODE_GAMES'}">
                <div class="container text-center" id="gamesDiv">
                    <h3>Wszystkie mecze</h3>
                    <hr>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered text-left">
                            <thread>
                                <tr>
                                    <th>ID</th>
                                    <th>Kolejka</th>
                                    <th>Druzyna 1 (gospodarze)</th>
                                    <th>Druzyna 2 (goscie)</th>
                                    <th>Data spotkania</th>
                                    <th>Wynik</th>
                                    <th>Zakonczony</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thread>
                            <tbody>
                                <c:forEach var="game" items="${games}">
                                    <tr>
                                        <td>${game.id}</td>
                                        <td>${game.round}</td>
                                        <td>${game.homeTeam}</td>
                                        <td>${game.awayTeam}</td>
                                        <td>${game.dateGame}</td>
                                        <td>${game.scoreHomea} : ${game.scoreAwaya}</td>
                                        <td>${game.finished}</td>
                                        <td><a href="update-game?id=${game.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                        <td><a href="delete-game?id=${game.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
                <div class="container text-center">
                    <h3>Dodaj mecz</h3>
                    <hr>
                    <form class="form-horizontal" method="POST" action="save-game">
                        <input type="hidden" name="id" value="${game.id}"/>
                        <div class="form-group">
                            <label class="control-label col-md-3">Numer kolejki</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="round" value="${game.round}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Druzyna 1 (gospodarze)</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="homeTeam" value="${game.homeTeam}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Druzyna 2 (goscie)</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="awayTeam" value="${game.awayTeam}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Data spotkania</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="dateGame" value="${game.dateGame}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Wynik 1 druzyny (gospodarze)</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="scoreHomea" value="${game.scoreHomea}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Wynik 2 druzyny (goscie)</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="scoreAwaya" value="${game.scoreAwaya}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Zakonczony</label>
                            <div class="col-md-7">
                                <input type="radio" class="col-sm-1" name="finished" value="true"/>
                                <div class="col-sm-1">Yes</div>
                                <input type="radio" class="col-sm-1" name="finished" value="false" checked/>
                                <div class="col-sm-1">No</div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Save"/>
                        </div>
                    </form>
                </div>
            </c:when>
            <c:when test="${mode == 'MODE_BETS'}">
                <div class="container text-center" id="gamesDiv">
                    <h3>Twoje typy</h3>
                    <hr>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered text-left">
                            <thread>
                                <tr>
                                    <th>Kolejka</th>
                                    <th>Druzyna 1 (gospodarze)</th>
                                    <th>Druzyna 2 (goscie)</th>
                                    <th>Data spotkania</th>
                                    <th>Twoj wynik</th>
                                    <th>Wynik koncowy</th>
                                    <th>Zakonczony</th>
                                    <th>Punkty</th>
                                </tr>
                            </thread>
                            <tbody>
                                <c:forEach var="game" items="${games}">
                                    <tr>
                                        <td>${game.round}</td>
                                        <td>${game.homeTeam}</td>
                                        <td>${game.awayTeam}</td>
                                        <td>${game.dateGame}</td>
                                        <td>${type.scoreHomep} : ${type.scoreHomep}</td>
                                        <td>${game.scoreHomea} : ${game.scoreAwaya}</td>
                                        <td>${game.finished}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:when test="${mode == 'MODE_BET'}">
                <div class="container text-center">
                    <h3>Obstaw</h3>
                    <hr>
                    <form class="form-horizontal" method="POST" action="save-bet">
                        <input type="hidden" name="game_id" value="${game.id}"/>

                        Mecz ktory wlasnie obstawiasz to: ${game.homeTeam} + ${game.awayTeam}.<br>

                        <div class="form-group">
                            <label class="control-label col-md-3">Wynik 1 druzyny (gospodarze)</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="scoreHomep" value="${type.scoreHomep}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Wynik 2 druzyny (goscie)</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="scoreAwayp" value="${type.scoreAwayp}"/>
                            </div>
                        </div>
                        <div class="form-group">                  
                            <input type="submit" class="btn btn-primary" value="Obstaw"/>       
                        </div>
                    </form>
                </div>
            </c:when>
            <c:when test="${mode == 'MODE_BETSS'}">
                <div class="container text-center" id="gamesDiv">
                    <h3>Wszystkie mecze do obstawienia</h3>
                    <hr>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered text-left">
                            <thread>
                                <tr>
                                    <th>Kolejka</th>
                                    <th>Druzyna 1 (gospodarze)</th>
                                    <th>Druzyna 2 (goscie)</th>
                                    <th>Data spotkania</th>
                                    <th>Twoj wynik</th>
                                    <th>Wynik koncowy</th>
                                    <th>Zakonczony</th>
                                    <th></th>
                                </tr>
                            </thread>
                            <tbody>
                                <c:forEach var="game" items="${games}">
                                    <tr>
                                        <td>${game.round}</td>
                                        <td>${game.homeTeam}</td>
                                        <td>${game.awayTeam}</td>
                                        <td>${game.dateGame}</td>
                                        <td>${type.scoreHomep} : ${type.scoreHomep}</td>
                                        <td>${game.scoreHomea} : ${game.scoreAwaya}</td>
                                        <td>${game.finished}</td>
                                        <td><a href="bet-bet?id=${game.id}"><span class="glyphicon glyphicon-usd"></span></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
        </c:choose>
        <script src="static/js/jquery-1.11.1.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>