<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta http-equiv="Expires" content="Sat, 01 Dec 2001, 00:00:00 GMT">

        <title>Fantasy Local League</title>
          <link href="${contextPath}/static/css/bootstrap.css" rel="stylesheet">
        <link href="static/css/bootstrap.min.css" rel="stylesheet">

        <link href="${contextPath}/static/css/style.css" rel="stylesheet">
        <style>
            .jumbotron{
                background-color:#262626;
                color:white;
                padding-top: 5px;
                padding-bottom: 20px;
            }


        </style>
    </head>
    <body>


        <div class="navbar navbar-default">
            <!--<a class="pull-left" href="index.html"><img src="static/images/ligatyperow2.png" width="100" height="50"></a><!-->

            <a href="/" class="navbar-brand">Strona główna</a>

                <ul class="nav navbar-nav">

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Panel uzytkownika
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="bet-games">Obstaw mecz</a></li>
                            <li><a href="your-games">Twoje typy</a></li>
                        </ul></li>
                    <li class="dropdown">

                        <a class="dropdown-toggle" data-toggle="dropdown" user="mirek1234" href="#">Panel administratora
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="new-game">Dodaj nowy mecz</a></li>
                            <li><a href="all-games">Zarządzaj meczami</a></li>
                            <li><a href="all-types">Rozdaj punkty</a></li>
                            <li><a href="new-clubs">Dodaj Klub</a></li>
                            <li><a href="new-player">Dodaj Zawodnika</a></li>
                            <li><a href="points-manager">Zarządzaj punktami</a></li>
                        </ul>  </li>
                    <li><a href="#">Klasyfikacja graczy</a></li>
                    <li><a href="contact">Kontakt</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <form id="logoutForm" method="POST" action="${contextPath}/logout">
                            <input type="hidden" name="${_csrf.parameterName } " value="${_csrf.token } "/>
                        </form>
                    </c:if>

                    <li><a onclick="document.forms['logoutForm'].submit()" href="#"><span class="glyphicon glyphicon-log-out" ></span> Wyloguj sie ${pageContext.request.userPrincipal.name} </a></li>

                </ul>
        </div>


        <c:choose>
            <c:when test="${mode == 'MODE_HOME'}">
                <div class="container" id="homeDiv">
                    <center><h2> <span class="label label-default">Witaj w Fantasy Local League ${pageContext.request.userPrincipal.name}.</span></h2> <br></center>

                    <div class="jumbotron text-center">
                        <div class="modal-header">
                            <h3><center> Piłkarskie newsy:</center></h3>
                            <br>

                        </div>
                        <br>
                        <div class="row">

                            <div class="col-md-6">
                                <center> <h4><b>Oficjalnie: Patryk Sieczka to gej!</b></h4></center> <br>

                            </div>
                        </div>
                    </div>
                    <br>
                    <br><br>
                    <br><br>
                    <br><br>
                    <br><br>
                    <br><br>
                    <br><br>
                    <br><br>
                    <br><br>
                    <br><br>
                    <br><br>
                    <br>
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
                                        <th>Drużyna 1 (gospodarze)</th>
                                        <th>Drużyna 2 (goście)</th>
                                        <th>Data spotkania</th>
                                        <th>Wynik</th>
                                        <th>Zakończony</th>
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
                                    <input type="number" class="form-control" name="round" max="99" min="0" value="${game.round}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Drużyna 1 (gospodarze)</label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" name="homeTeam" value="${game.homeTeam}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Drużyna 2 (goście)</label>
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
                                <label class="control-label col-md-3">Wynik 1 drużyny (gospodarze)</label>
                                <div class="col-md-7">

                                    <input type="number" class="form-control" name="scoreHomea" max="25" min="0"  value="${game.scoreHomea}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Wynik 2 drużyny (goście)</label>
                                <div class="col-md-7">
                                    <input type="number" class="form-control" name="scoreAwaya" max="25" min="0" value="${game.scoreAwaya}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Zakończony</label>
                                <div class="col-md-7">
                                    <input type="radio" class="col-sm-1" name="finished" value="tak"/>
                                    <div class="col-sm-1">Tak</div>
                                    <input type="radio" class="col-sm-1" name="finished" value="nie" checked/>
                                    <div class="col-sm-1">Nie</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" value="Zapisz"/>
                            </div>



                        </form>
                    </div>
                </c:when>



                  <c:when test="${mode == 'MODE_CLUBS'}">
                    <div class="container text-center">
                        <h3>Dodaj Klub</h3>
                        <form class="form-horizontal" method="POST" action="save-clubs">
                          <input type="hidden" name="id" value="${game.id}"/>
                        <div class="form-group">
                            <label class="control-label col-md-3">Pełna nazwa Klub</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="name" value="${clubs.name}"/>
                            </div>

                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Dodaj"/>
                          </form>
                        </div>
                        <div class="container text-center" id="gamesDiv">
                            <h3>Drużyny:</h3>
                            <hr>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered text-left">
                                    <thread>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nazwa drużyny</th>
                                            <th></th>

                                        </tr>
                                    </thread>
                                    <tbody>
                                        <c:forEach var="clubs" items="${club}">
                                            <tr>
                                                <td>${clubs.id}</td>
                                                <td>${clubs.name}</td>
<td><a href="delete-clubs?id=${clubs.id}"><span class="glyphicon glyphicon-trash"></span></a></td>

                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>  </div>
                    </c:when>



                    <c:when test="${mode == 'MODE_PLAYER'}">
                      <div class="container text-center">
                          <h3>Dodaj Piłkarza</h3>
                          <form class="form-horizontal" method="POST" action="save-player">

                          <div class="form-group">
                              <label class="control-label col-md-3">Imię</label>
                              <div class="col-md-7">
                                  <input type="text" class="form-control" name="firstname" value="${player.firstname}"/>
                              </div>

                          </div>
                          <div class="form-group">
                              <label class="control-label col-md-3">Nazwisko</label>
                              <div class="col-md-7">
                                  <input type="text" class="form-control" name="lastname" value="${player.lastname}"/>
                              </div>

                          </div>
                          <div class="form-group">
                              <label class="control-label col-md-3">Data urodzin (rrrr-mm-dd)</label>
                              <div class="col-md-7">
                                  <input type="date" class="form-control" name="date_birth" value="${player.date_birth}"/>
                              </div>

                          </div>
                          <div class="form-group">
                              <label class="control-label col-md-3">Pozycja</label>
                              <div class="col-md-7">
                          <select class="form-control cascadingDropDown" name="position">
                                <option value="Napastnik"> Napastnik </option>
                              <option value="Pomocnik"> Pomocnik </option>
                              <option  value="Obrońca"> Obrońca </option>
                              <option value="Bramkarz"> Bramkarz </option>
                            </select>
                                </div>
                                </div>

                            <div class="form-group">
                                <label class="control-label col-md-3">Klub</label>
                                <div class="col-md-7">

                                  <select class="form-control cascadingDropDown"  name="club">
                                    <c:forEach var="clubs" items="${club}">
                                        <option value="${clubs.name}"> ${clubs.name}  </option>

                                        </c:forEach>
                                    </select>
                                </div>
                              </div>
                              <div class="form-group">
                                  <label class="control-label col-md-3">Cena</label>
                                  <div class="col-md-7">
                                      <input type="number" class="form-control" name="price" value="${player.price}"/>
                                  </div>
                              <hr>
                              </div>
                          <div class="form-group">
                              <input type="submit" class="btn btn-primary" value="Dodaj"/>
                            </form>
                          </div>
                          <div class="container text-center" id="gamesDiv">
                              <h3>Piłkarze:</h3>
                              <hr>
                              <div class="table-responsive">
                                  <table class="table table-striped table-bordered text-left">
                                      <thread>
                                          <tr>
                                              <th>ID</th>
                                              <th>Imię</th>
                                              <th>Nazwisko</th>
                                              <th>Data urodzenia</th>
                                              <th>Pozycja</th>
                                              <th>Klub</th>
                                              <th>Cena</th>
                                              <th></th>

                                          </tr>
                                      </thread>
                                      <tbody>
                                          <c:forEach var="player" items="${players}">
                                              <tr>
                                                  <td>${player.id}</td>
                                                  <td>${player.firstname}</td>
                                                  <td>${player.lastname}</td>
                                                  <td>${player.date_birth}</td>
                                                  <td>${player.position}</td>
                                                  <td>${player.club}</td>
                                                  <td>${player.price}</td>
                  <td><a href="delete-player?id=${player.id}"><span class="glyphicon glyphicon-trash"></span></a></td>

                                              </tr>
                                          </c:forEach>
                                      </tbody>
                                  </table>
                              </div>
                          </div></div>
                      </c:when>



                      <c:when test="${mode == 'MODE_POINTSMANAGER'}">
                         <div class="container text-center">
                             <h3>Zarządzaj punktami</h3>
                             <form class="form-horizontal" method="POST" action="save-points">
                         <!--            <input type="hidden" name="player.id" value="${playerpoints.player.id}"/>

                       <select class="form-control cascadingDropDown"  name="club">
                                   <c:forEach var="clubs" items="${club}">
                                       <option value=""> ${clubs.name}  </option>

                                       </c:forEach>
                                 </select> -->



                                   <hr>
                                   </div>
                                           <hr>
                                       <div class="container text-center" >
                               <div class="table-responsive">

                                   <c:forEach var="playerpoints" items="${players}" >
                                     <table class="table table-striped table-bordered text-left">
                                       <tr>
                                           <th>ID gracza</th>
                                           <td>${playerpoints.id} <input type="hidden" name="player.id" value="${playerpoints.id}"/> </td>
                                       </tr>
                                         <tr>
                                             <th>Imie i nazwisko</th>
                                             <td>${playerpoints.firstname} ${playerpoints.lastname}</td>
                                         </tr>
                                         <tr>
                                             <th>Strzelone gole </th>
                                             <td><input type="number" class="form-control" name="roundpoints" max="25" min="0"> </td>
                                         </tr>
                                         <tr>
                                             <th>Nr rundy</th>
                                             <td><div class="form-group">
                                                     <label class="control-labelcol-md-3"></label>
                                                     <div class="col-md-7">
                                                 <select class="form-controlcascadingDropDown" name="roundnr">
                                                       <option value="1"> 1 </option>
                                                     <option value="2"> 2 </option>
                                                     <option  value="3"> 3 </option>
                                                     <option value="4"> 4 </option>
                                                   </select>
                                                       </div>
                                                     </div></td>
                                         </tr>
                                         <tr>
                                             <th></th>
                                             <td>  <input type="submit" class="btn btn-primary"    value="Zapisz"/></td>
                                         </tr>

                                     </table>
                                     <hr />
                                 </c:forEach>

                                        <hr>
                                                                        <div class="table-responsive">
                                                                            <table class="table table-striped table- bordered text-left">
                                                                                <thread>
                                                                                    <tr>
                                                                                      <th>id pktów</th>
                                                                                      <th>id gracza</th>

                                                                                      <th>Nr rundy</th>
                                                                                      <th>Punkty za rundę</th>
                                                                                    </tr>
                                                                                </thread>
                                                                                <tbody>
                                                                                  <c:forEach var="playerpoints"   items="${playerpoint}">


                                                                                        <tr>
                                                                                          <td>${playerpoints.id}</td>
                                                                                          <td>  ${playerpoints.player.id}</td>
                                                                                          <td>  ${playerpoints.roundnr}</td>
                                                                                          <td>${playerpoints.roundpoints}</td>
                                                                                        </tr>
                                                                                        </c:forEach>
                                                                                    </tbody>
                                                                                    </table>
                                                                                    </div>
                                                                                    </form>

                                                                </div>  </div>
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
                                        <th>Drużyna 1 (gospodarze)</th>
                                        <th>Drużyna 2 (goście)</th>
                                        <th>Data spotkania</th>
                                        <th>Twój wynik</th>
                                        <th>Wynik końcowy</th>
                                        <th>Zakończony</th>
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
                                            <td>${game.scoreHomep} : ${game.scoreAwayp}</td>
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

                            Mecz ktory wlasnie obstawiasz to: ${game.homeTeam} vs ${game.awayTeam}.<br>

                            <div class="form-group">
                                <label class="control-label col-md-3">Wynik 1 drużyny (gospodarze)</label>
                                <div class="col-md-7">
                                    <input type="number" class="form-control" name="scoreHomep" max="25" min="0" value="${type.scoreHomep}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Wynik 2 drużyny (goście)</label>
                                <div class="col-md-7">
                                    <input type="number" class="form-control" name="scoreAwayp" max="25" min="0" value="${type.scoreAwayp}"/>
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
                                        <th>Drużyna 1 (gospodarze)</th>
                                        <th>Drużyna 2 (goście)</th>
                                        <th>Data spotkania</th>
                                        <th>Twój wynik</th>
                                        <th>Wynik końcowy</th>
                                        <th>Zakończony</th>
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
                                            <td>${game.scoreHomep} : ${game.scoreAwayp}</td>
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
                <c:when test="${mode == 'MODE_TYPES'}">
                    <div class="container text-center" id="typesDiv">
                        <h3>Wszystkie typy użytkowników</h3>
                        <hr>
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered text-left">
                                <thread>
                                    <tr>
                                        <th>ID typu</th>
                                        <th>Info</th>
                                        <th>Rzeczywisty wynik</th>
                                        <th>Wynik użytkownika</th>
                                        <th>Nazwa użytkownika</th>
                                        <th></th>
                                    </tr>
                                </thread>
                                <tbody>
                                    <c:forEach var="type" items="${types}">
                                        <tr>
                                            <td>${type.id}</td>
                                            <td></td>
                                            <td></td>
                                            <td>${type.scoreHomep} : ${type.scoreAwayp}</td>
                                            <td>${type.user}</td>
                                            <td><a href="add-points?id=${type.id}"><span class="glyphicon glyphicon-plus"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </c:when>
                <c:when test="${mode == 'MODE_PBETTT'}">
                    <div class="container text-center">
                        <h3>Obstaw</h3>
                        <hr>
                        <form class="form-horizontal" method="POST" action="save-point">
                            <input type="hidden" name="id" value="${type.id}"/>

                            <div class="form-group">
                                <label class="control-label col-md-3">Punkty:</label>
                                <div class="col-md-7">
                                    <input type="number" class="form-control" name="scoreHomep" max="25" min="0" value="${type.points}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" value="Dodaj punkty"/>
                            </div>
                        </form>
                    </div>
                </c:when>
                <c:when test="${mode == 'MODE_PBET'}">
                    <div class="container text-center">
                        <h3>Rozdaj punkty</h3>
                        <hr>
                        <form class="form-horizontal" method="POST" action="save-bet">
                            <input type="hidden" name="id" value="${type.id}"/>
                            <div class="form-group">
                                <label class="control-label col-md-3">Wynik 1 drużyny (gospodarze)</label>
                                <div class="col-md-7">
                                    <input type="number" class="form-control" name="scoreHomep" max="25" min="0" value="${type.scoreHomep}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Wynik 2 drużyny (goście)</label>
                                <div class="col-md-7">
                                    <input type="number" class="form-control" name="scoreAwayp" max="25" min="0" value="${type.scoreAwayp}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Punkty</label>
                                <div class="col-md-7">
                                    <input type="number" class="form-control" name="scoreAwayp" max="25" min="0" value="${type.points}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" value="Rozdaj punkty"/>
                            </div>
                        </form>
                    </div>
                </c:when>
                <c:when test="${mode == 'MODE_CONTACT'}">
                    <div class="container">

                        <center><h1>Najczęściej zadawane pytania:</h1></center>

                        <center>      <div class="jumbotron">
                                <h3><b>Zgłoś uwage</b></h3>

                                Masz jakiś ciekawy pomysł, który usprawni działanie serwisu? A może znalazłeś/aś jakiś błąd? Napisz nam o tym koniecznie.
                                <br><h3><b>Brak przypisanych punktów</b></h3>

                                Punkty w naszej Lidze Typerów nie zostały podliczone od razu? Cierpliwości,
                                system automatycznie aktualizuje stan punktów po wprowadzeniu wyników meczów.
                                W ciągu 24 godzin od wprowadzenia wyniku meczu w serwisie punkty na pewno sie pojawią.
                                <br><br>
                                <b>  Odpowiemy na każdą wiadomość jeśli tylko nie wpadnie do spamu, także śmiało! <b>
                                        </div>
                                        </center>
                                        <center><h1>Kontakt email:</h1></center>
                                        <center><h2> <span class="label label-default">pawelbodo7@gmail.com</span></h2> <br></center>
                                        <center> <img src="static/images/ligatyperow.png" width="200" height="140"></center>
                                        </div>
                                        </div>
                                        </div>
                                    </c:when>
                                </c:choose>



                                <script src="static/js/jquery-1.11.1.min.js"></script>
                                <script src="static/js/bootstrap.min.js"></script>
                                </body>
                                </html>
