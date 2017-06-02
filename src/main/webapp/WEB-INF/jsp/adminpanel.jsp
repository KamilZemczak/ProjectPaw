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

        <title>Add bets</title>

        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/css/style.css" rel="stylesheet">

        <!--[if lt IE 9]>
        <script src="static/js/html5shiv.min.js"></script>
        <script src="static/js/respond.min.js"></script>
        <!endif]-->
    </head>
    <body>

        <div role="navigation">
            <div class="navbar navbar-inverse">
                <a href="/" class="navbar-brand">Strona glowna</a>  
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="new-bet">Dodaj zaklad</a></li>
                        <li><a href="all-bets">Wszystkie zaklady</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <c:choose>
            <c:when test="${mode == 'MODE_HOMEB'}">
                <div class="container" id="homeDiv">
                    <div class="jumbotron text-center">
                        <h1>Witaj w panelu administracyjnym</h1>
                    </div>
                </div>
            </c:when>
            <c:when test="${mode == 'MODE_BETS'}">
                <div class="container text-center" id="betsDiv">
                    <h3>Wszystkie zaklady</h3>
                    <hr>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered text-left">
                            <thread>
                                <tr>
                                    <th>ID zakladu</th>
                                    <th>Druzyna 1</th>
                                    <th>Druzyna 2</th>
                                    <th>Wynik 1</th>
                                    <th>Wynik 2</th>
                                    <th>Data spotkania</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thread>
                            <tbody>
                                <c:forEach var="bet" items="${bets}">
                                    <tr>
                                        <td>${bet.id_bet}</td>
                                        <td>${bet.homeTeam}</td>
                                        <td>${bet.awayTeam}</td>
                                        <td>${bet.scoreHomeTeamA}</td>
                                        <td>${bet.scoreAwayTeamA}</td>
                                        <td>${bet.matchDate}</td>
                                        <td><a href="update-bet?id=${bet.id_bet}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                        <td><a href="delete-bet?id=${bet.id_round}"><span class="glyphicon glyphicon-trash"></span></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:when test="${mode == 'MODE_NEWB' || mode == 'MODE_UPDATEB'}">
                <div class="container text-center">
                    <h3>Dodaj zaklad</h3>
                    <hr>
                    <form class="form-horizontal" method="POST" action="save-bet">
                        <input type="hidden" name="id" value="${bet.id_bet}"/>
                        <div class="form-group">
                            <label class="control-label col-md-3">Pierwsza druzyna (gospodarze)</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="homeTeam" value="${bet.homeTeam}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Druga druzyna (goscie)</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="awayTeam" value="${bet.awayTeam}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Wynik pierwszej druzyny</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="scoreHomeTeamA" value="${bet.scoreHomeTeamA}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Wynik drugiej druzyny</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="scoreAwayTeamA" value="${bet.scoreAwayTeamA}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Data spotkania</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="matchDate" value="${bet.matchDate}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Save"/>
                        </div>
                    </form>
                </div>
            </c:when>
        </c:choose>
        <script src="static/js/jquery-1.11.1.min.js"</script>
        <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>