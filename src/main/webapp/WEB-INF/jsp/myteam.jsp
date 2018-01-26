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

                  <li><a onclick="document.forms['logoutForm'].submit()" href="#"><span class="glyphicon glyphicon-log-out" ></span> Wyloguj sie ${pageContext.request.userPrincipal.name} </a></li>

              </ul>
      </div>
        <br>

          <form class="form-horizontal" method="POST" action="save-myteam">


          <div container>
          <div class="row">
            <div class="col-12 col-md-8 col-sm-12">
            <div class="jumbotron">    <table class="table  text-center">

              <tr height="75px">

              </tr>



              <tbody>
              <tr>
              <th width="20%"></td>
              <th class="text-center">

                </td>
              <th width="20%">  <h5 class="bg-primary">Bramkarz</h>
                    <select class="form-control cascadingDropDown" name="mplayer1">
                    <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Bramkarz'}">
                      <option value="${player.id}">
                        ${player.firstname} ${player.lastname}
                      </option> </c:when>  </c:choose>
                    </c:forEach></select></td>
              <th class="text-center">

             </td>
              <th width="20%"></td>
              </tr>
            </tr>
            <tr height="40px">

            </tr>
              <tr>
              <td class="text-center" ><h5 class="bg-primary">OBROŃCA</h>
                 <select class="form-control cascadingDropDown"  name="mplayer2">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option>   </c:when>  </c:choose>
                </c:forEach></select></td>
              <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
                 <select class="form-control cascadingDropDown"  name="mplayer3">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
          <td>  </td>
              <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
                 <select class="form-control cascadingDropDown"  name="mplayer4" name="tcounter">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}" value="${player.price}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
                <select class="form-control cascadingDropDown"  name="mplayer5">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              </tr>
              <tr height="40px">

              </tr>
              <tr>
              <td><h5 class="bg-primary">POMOCNIK</h>
                  <select class="form-control cascadingDropDown"  name="mplayer6">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-primary">POMOCNIK</h>
                 <select class="form-control cascadingDropDown"  name="mplayer7">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td></td>
              <td><h5 class="bg-primary">POMOCNIK</h>
                 <select class="form-control cascadingDropDown"  name="mplayer8">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-primary">POMOCNIK</h>
                 <select class="form-control cascadingDropDown"  name="mplayer9">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              </tr>
              <tr height="40px">

              </tr>
              <tr>
              <td></td>
              <td><h5 class="bg-primary">NAPASTNIK</h>
                 <select class="form-control cascadingDropDown"  name="mplayer10">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td></td>
              <td><h5 class="bg-primary">NAPASTNIK</h>
                <select class="form-control cascadingDropDown"  name="mplayer11">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>

                </c:forEach></select></td>
              <td></td>
              </tr>

              </tbody>
              </table>

            </div>
            </div>
            <div class="col-6 col-md-4">  <div class="well well-sm"><div class="text-center">
                <c:set var = "budgett" scope = "session" value = "${100000-budget}"/>
            Twój aktualny budżet to:  <b><c:out value = "${budgett}"/></b> <br>
            Wybierz formację i wybierz piłkarzy, którzy będą grali w twojej podstawowej 11.
             <br>
               <input type="submit" class="btn btn-primary" value="Zapisz"/>

          </div></div>
          </div><div class="text-center">



        </div></div></div>



  <!--    <div class="table-responsive">
          <table class="table table-striped table- bordered text-left">
              <thread>
                  <tr>
                    <th>id zawodnika</th>
                    <th>Imię i nazwisko</th>

                    <th>Pozycja</th>
                    <th>Cena</th>
                  </tr>
              </thread>
              <tbody>

<c:set var = "z1" value = "${userteam.player1}"/>

                      <tr>
                        <td>${userteam.player1} </td>
                        <td>  ${player.firstname} ${player.lastname}</td>
                        <td>  ${player.position}</td>
                        <td>${player.price}</td>
                      </tr>

                  </tbody>
                  </table>
                </div> -->
          <br></form>

                                        <script src="static/js/jquery-1.11.1.min.js"></script>
                                <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>
