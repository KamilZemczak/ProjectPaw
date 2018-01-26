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
        <link href="static/css/style.css" rel="stylesheet">
        <style>
        .tr{
          border-top:none;
          border-bottom:none;
          border-top:0px;
          border-bottom:0px;
          border-width:none;
          border-width:0px;
        }
            .jumbotron{

                background-image: url("${contextPath}/static/images/pitch.png") ;
                background-size: 100%;
                background-color: black;
                color:white;
                border: none;
                padding-right:  5px;
                padding-left:  5px;
                padding-top: 5px;
                padding-bottom: 20px;
            }
            .container{
              margin-right:  20px;
              margin-left:  20px;
            }
            .well {
              background-color:#80ff80;
            }


        </style>
    </head>
    <body>
      <div class="navbar navbar-inverse">
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

                  <li><a href="#">Klasyfikacja graczy</a></li>
                  <li><a href="contact">Kontakt</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                  <c:if test="${pageContext.request.userPrincipal.name != null}">
                      <form id="logoutForm" method="POST" action="${contextPath}/logout">
                          <input type="hidden" name="${_csrf.parameterName } " value="${_csrf.token } "/>
                      </form>
                  </c:if>

                  <li><a onclick="document.forms['logoutForm'].submit()" href="#"><span class="glyphicon glyphicon-log-out" ></span> Wyloguj sie ${pageContext.request.userPrincipal.name}. </a></li>

              </ul>
      </div>
        <br>

          <c:if test="${mode == 'MODE_CREATETEAME'}">
          <div class="alert alert-danger">
        <h5 color="red">Przekroczyłeś Budżet lub wybrałeś takich samych zawodników! Zbuduj drużynę jeszcze raz!</h5>
      </div>
        </c:if>
            <form class="form-horizontal" method="POST" action="save-userteam">


          <div container>
          <div class="row">
            <div class="col-12 col-md-8 col-sm-12">
            <div class="jumbotron">    <table class="table  text-center">

              <tr height="75px">

              </tr>



              <tbody>
              <tr>
              <th width="23%"></td>
              <th class="text-center">
            <h5 class="bg-primary">Bramkarz 1 </h>
                <select class="form-control cascadingDropDown" name="player1">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Bramkarz'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}
                  </option> </c:when>  </c:choose>
                </c:forEach></select>
                </td>
              <th width="18%"></td>
              <th class="text-center">
            <h5 class="bg-primary">Bramkarz 2 </h>
                <select class="form-control cascadingDropDown"  name="player2">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Bramkarz'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}
                  </option></c:when>  </c:choose>
                </c:forEach></select>
             </td>
              <th width="23%"></td>
              </tr>
            </tr>
            <tr height="40px">

            </tr>
              <tr>
              <td class="text-center" ><h5 class="bg-primary">OBROŃCA 1</h>
                 <select class="form-control cascadingDropDown"  name="player3">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option>   </c:when>  </c:choose>
                </c:forEach></select></td>
              <td class="text-center"><h5 class="bg-primary">OBROŃCA 2</h>
                 <select class="form-control cascadingDropDown"  name="player4">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td class="text-center"><h5 class="bg-primary">OBROŃCA 3</h>
                <select class="form-control cascadingDropDown"  name="player5">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td class="text-center"><h5 class="bg-primary">OBROŃCA 4</h>
                 <select class="form-control cascadingDropDown"  name="player6">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}" value="${player.price}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td class="text-center"><h5 class="bg-primary">OBROŃCA 5</h>
                <select class="form-control cascadingDropDown"  name="player7">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              </tr>
              <tr height="40px">

              </tr>
              <tr>
              <td><h5 class="bg-primary">POMOCNIK1</h>
                  <select class="form-control cascadingDropDown"  name="player8">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-primary">POMOCNIK2</h>
                 <select class="form-control cascadingDropDown"  name="player9">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-primary">POMOCNIK3</h>
                 <select class="form-control cascadingDropDown"  name="player10">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-primary">POMOCNIK 4</h>
                 <select class="form-control cascadingDropDown"  name="player11">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-primary">POMOCNIK 5</h>
                 <select class="form-control cascadingDropDown"  name="player12">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              </tr>
              <tr height="40px">

              </tr>
              <tr>
              <td></td>
              <td><h5 class="bg-primary">NAPASTNIK 1</h>
                 <select class="form-control cascadingDropDown"  name="player13">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-primary">NAPASTNIK 2</h>
                <select class="form-control cascadingDropDown"  name="player14">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-primary">NAPASTNIK 3</h>

                <select class="form-control cascadingDropDown"  name="player15">
                <c:forEach var="player" items="${players}">


                  <c:choose><c:when test="${player.position eq 'Napastnik'}">
                     <option value="${player.id}"/>
                    ${player.firstname} ${player.lastname}, cena: ${player.price}

                  </option>    </c:when>  </c:choose>

                </c:forEach></select></select>
              </td>
              <td>  </td>
              </tr>

              </tbody>
              </table>

            </div>
            </div>
            <div class="col-6 col-md-4" >
              <div class="well well-sm">
<div class="text-center">
            <h2>Witaj ${pageContext.request.userPrincipal.name} w Fantasy Local League! </h2>
            <br>
  <p>      Tutaj stworzysz swój zespół złożony z zawdoników Twojej lokalnej ligi piłkarskiej.
          Wybieraj jednak mądrze, twój budżet to <b>100 000 zł</b>. W tej kwocie możesz wybrać 15 zawodników: <b>3</b> napastników,
          <b>5</b> pomocników, <b>5</b> obrońców i <b>2</b> bramkarzy. Piłkarze nie mogą się też powtarzać. Gdy wybierzesz ich poprawnie kliknij
           przycisk "Zapisz" aby przejść do następnego etapu. Tam wybierzesz formację i podstawą 11.</p>
           <br>
          <h3> Życzymy udanej selekcji!</h3>

<input type="submit" class="btn btn-primary" value="Zapisz"/>


           <br>
        </div></div></div></div>
          </div><div class="text-center">


          <input type="hidden" name="user.id" value="${userteam.id}"/>

</div></div>
    <!--     <input type="hidden" name="tcounter" value="${budget}"/>
        <c:if test = "${budget > 80000}">
          <c:out value = "${budget}"/>
        </c:if>-->
      </form>

          <br>

                                        <script src="static/js/jquery-1.11.1.min.js"></script>
                                <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>
