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

            .well {
              background-color:#80ff80;
            }
            .bg-success{
              background-color: blue;
              text-align: center;
              color:black;
            }
            .bg-primary{
              background-color: purple;
              color:black;
            }
            .bg-danger{
              background-color: yellow;
              color:black;
            }
            .bg-info{
              background-color: red;
              color:black;
            }
        </style>
    </head>
    <body>
      <div class="navbar navbar-inverse">
          <!--<a class="pull-left" href="index.html"><img src="static/images/ligatyperow2.png" width="100" height="50"></a><!-->

          <a href="/" class="navbar-brand">Strona główna</a>

              <ul class="nav navbar-nav">

                <li><a href="myteam-4-4-2">Edytuj swoją drużynę</a></li>
                <li><a href="transfers">Transfery</a></li>
                <li><a href="bet-games">Terminarz i wyniki meczów</a></li>
                  <li><a href="#">Klasyfikacja graczy</a></li>
                    <li><a href="rules">Zasady</a></li>
                  <li><a href="contact">Kontakt</a></li>
                  <c:if test="${adminu eq '28'}">             <li class="dropdown">

                                      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Panel administratora
                                          <span class="caret"></span></a>
                                      <ul class="dropdown-menu">
                                          <li><a href="new-game">Dodaj nowy mecz</a></li>
                                          <li><a href="new-clubs">Dodaj Klub</a></li>
                                          <li><a href="new-player">Dodaj Zawodnika</a></li>
                                          <li><a href="points-manager">Zarządzaj punktami</a></li>
                                      </ul>  </li></c:if>
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
      <center><h2> <span color="green" class="label label-default">Witaj w Fantasy Local League ${pageContext.request.userPrincipal.name}.</span></h2> <br></center>

        <br>   <c:choose>
<c:when test="${mode == 'MODE_MYTEAM-4-4-2'}">
<form class="form-horizontal" method="POST" action="save-myteam">


          <div container>

          <div class="row">
            <div class="col-12 col-md-8 col-sm-12">
            <div class="jumbotron">    <table class="table  text-center">

              <tr height="25px">
                <div class="dropdown">
                  <button class="btn btn-default dropdown-toggle btn-lg" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Formacja
                <span class="caret"></span></button>
                   <ul class="dropdown-menu">
                 <li>    <a href="myteam-4-4-2"> 4-4-2 </a></li>
                 <li>     <a href="myteam-4-3-3"> 4-3-3 </a></li>
                 <li>     <a href="myteam-4-5-1"> 4-5-1 </a></li>
                 <li>     <a href="myteam-5-4-1"> 5-4-1 </a></li>
                 <li>     <a href="myteam-5-3-2"> 5-3-2 </a></li>
                 <li>     <a href="myteam-3-5-2"> 3-5-2 </a> </li>
                   </ul>
                 </div>
              </tr>



              <tbody>
              <tr>
              <th width="20%"></td>
              <th class="text-center">

                </td>
              <th width="20%">  <h5 class="bg-success">Bramkarz</h>
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
                 <select class="form-control cascadingDropDown"  name="mplayer4">
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
              <td><h5 class="bg-danger">POMOCNIK</h>
                  <select class="form-control cascadingDropDown"  name="mplayer6">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-danger">POMOCNIK</h>
                 <select class="form-control cascadingDropDown"  name="mplayer7">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td></td>
              <td><h5 class="bg-danger">POMOCNIK</h>
                 <select class="form-control cascadingDropDown"  name="mplayer8">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td><h5 class="bg-danger">POMOCNIK</h>
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
              <td><h5 class="bg-info">NAPASTNIK</h>
                 <select class="form-control cascadingDropDown"  name="mplayer10">
                <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
                  <option value="${player.id}">
                    ${player.firstname} ${player.lastname}

                  </option> </c:when>  </c:choose>
                </c:forEach></select></td>
              <td></td>
              <td><h5 class="bg-info">NAPASTNIK</h>
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
            <div class="col-6 col-md-4">  <div class="well well-sm">
              <div class="text-center">
                <c:set var = "budgett" scope = "session" value = "${100000-budget}"/>
            Twój aktualny budżet to:  <b><c:out value = "${budgett}"/></b> <br>
            Wybierz formację i wybierz piłkarzy, którzy będą grali w twojej podstawowej 11.
             <br>
<input type="hidden" name="formation" value="4-4-2"/>
        <input type="submit" class="btn btn-primary" value="Zapisz"/>
</div></div></div></div></div>
</form>
</c:when>

 <c:when test="${mode == 'MODE_MYTEAM-4-3-3'}">
<form class="form-horizontal" method="POST" action="save-myteam">


   <div container>

   <div class="row">
     <div class="col-12 col-md-8 col-sm-12">
     <div class="jumbotron">    <table class="table  text-center">

       <tr height="25px">
         <div class="dropdown">
           <button class="btn btn-default dropdown-toggle btn-lg" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
             Formacja
         <span class="caret"></span></button>
            <ul class="dropdown-menu">
          <li>    <a href="myteam-4-4-2"> 4-4-2 </a></li>
          <li>     <a href="myteam-4-3-3"> 4-3-3 </a></li>
          <li>     <a href="myteam-4-5-1"> 4-5-1 </a></li>
          <li>     <a href="myteam-5-4-1"> 5-4-1 </a></li>
          <li>     <a href="myteam-5-3-2"> 5-3-2 </a></li>
          <li>     <a href="myteam-3-5-2"> 3-5-2 </a> </li>
            </ul>
          </div>
       </tr>



       <tbody>
       <tr>
       <th width="20%"></td>
       <th class="text-center">

         </td>
       <th width="20%">  <h5 class="bg-success">Bramkarz</h>
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
          <select class="form-control cascadingDropDown"  name="mplayer4">
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
       <td></td>
       <td><h5 class="bg-danger">POMOCNIK</h>
          <select class="form-control cascadingDropDown"  name="mplayer6">
         <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
           <option value="${player.id}">
             ${player.firstname} ${player.lastname}

           </option> </c:when>  </c:choose>
         </c:forEach></select></td>
       <td><h5 class="bg-danger">POMOCNIK</h>
          <select class="form-control cascadingDropDown"  name="mplayer7">
         <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
           <option value="${player.id}">
             ${player.firstname} ${player.lastname}

           </option> </c:when>  </c:choose>
         </c:forEach></select></td>
       <td><h5 class="bg-danger">POMOCNIK</h>
          <select class="form-control cascadingDropDown"  name="mplayer8">
         <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
           <option value="${player.id}">
             ${player.firstname} ${player.lastname}

           </option> </c:when>  </c:choose>
         </c:forEach></select></td>
       <td></td>
       </tr>
       <tr height="40px">

       </tr>
       <tr>
       <td></td>
       <td><h5 class="bg-info">NAPASTNIK</h>
          <select class="form-control cascadingDropDown"  name="mplayer9">
         <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
           <option value="${player.id}">
             ${player.firstname} ${player.lastname}

           </option> </c:when>  </c:choose>
         </c:forEach></select></td>
         <td><h5 class="bg-info">NAPASTNIK</h>
           <select class="form-control cascadingDropDown"  name="mplayer10">
           <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
             <option value="${player.id}">
               ${player.firstname} ${player.lastname}

             </option> </c:when>  </c:choose>

           </c:forEach></select></td>
       <td><h5 class="bg-info">NAPASTNIK</h>
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
     <div class="col-6 col-md-4">  <div class="well well-sm">
       <div class="text-center">
         <c:set var = "budgett" scope = "session" value = "${100000-budget}"/>
     Twój aktualny budżet to:  <b><c:out value = "${budgett}"/></b> <br>
     Wybierz formację i wybierz piłkarzy, którzy będą grali w twojej podstawowej 11.
      <br>
<input type="hidden" name="formation" value="4-3-3"/>
        <input type="submit" class="btn btn-primary" value="Zapisz"/>
</div></div></div></div></div>
</form>
</c:when>

<c:when test="${mode == 'MODE_MYTEAM-4-5-1'}">
<form class="form-horizontal" method="POST" action="save-myteam">


  <div container>

  <div class="row">
    <div class="col-12 col-md-8 col-sm-12">
    <div class="jumbotron">    <table class="table  text-center">

      <tr height="25px">
        <div class="dropdown">
          <button class="btn btn-default dropdown-toggle btn-lg" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            Formacja
        <span class="caret"></span></button>
           <ul class="dropdown-menu">
         <li>    <a href="myteam-4-4-2"> 4-4-2 </a></li>
         <li>     <a href="myteam-4-3-3"> 4-3-3 </a></li>
         <li>     <a href="myteam-4-5-1"> 4-5-1 </a></li>
         <li>     <a href="myteam-5-4-1"> 5-4-1 </a></li>
         <li>     <a href="myteam-5-3-2"> 5-3-2 </a></li>
         <li>     <a href="myteam-3-5-2"> 3-5-2 </a> </li>
           </ul>
         </div>
      </tr>



      <tbody>
      <tr>
      <th width="20%"></td>
      <th class="text-center">

        </td>
      <th width="20%">  <h5 class="bg-success">Bramkarz</h>
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
         <select class="form-control cascadingDropDown"  name="mplayer4">
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
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer6">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer7">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer8">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer9">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer10">
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
      <td></td>
        <td><h5 class="bg-info">NAPASTNIK</h>
          <select class="form-control cascadingDropDown"  name="mplayer11">
          <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
            <option value="${player.id}">
              ${player.firstname} ${player.lastname}

            </option> </c:when>  </c:choose>

          </c:forEach></select></td>
      <td></td>
      <td></td>
      </tr>

      </tbody>
      </table>

    </div>
    </div>
    <div class="col-6 col-md-4">  <div class="well well-sm">
      <div class="text-center">
        <c:set var = "budgett" scope = "session" value = "${100000-budget}"/>
    Twój aktualny budżet to:  <b><c:out value = "${budgett}"/></b> <br>
    Wybierz formację i wybierz piłkarzy, którzy będą grali w twojej podstawowej 11.
     <br>
<input type="hidden" name="formation" value="4-5-1"/>
       <input type="submit" class="btn btn-primary" value="Zapisz"/>
</div></div></div></div></div>
</form>
</c:when>


<c:when test="${mode == 'MODE_MYTEAM-5-4-1'}">
<form class="form-horizontal" method="POST" action="save-myteam">


  <div container>

  <div class="row">
    <div class="col-12 col-md-8 col-sm-12">
    <div class="jumbotron">    <table class="table  text-center">

      <tr height="25px">
        <div class="dropdown">
          <button class="btn btn-default dropdown-toggle btn-lg" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            Formacja
        <span class="caret"></span></button>
           <ul class="dropdown-menu">
         <li>    <a href="myteam-4-4-2"> 4-4-2 </a></li>
         <li>     <a href="myteam-4-3-3"> 4-3-3 </a></li>
         <li>     <a href="myteam-4-5-1"> 4-5-1 </a></li>
         <li>     <a href="myteam-5-4-1"> 5-4-1 </a></li>
         <li>     <a href="myteam-5-3-2"> 5-3-2 </a></li>
         <li>     <a href="myteam-3-5-2"> 3-5-2 </a> </li>
           </ul>
         </div>
      </tr>



      <tbody>
      <tr>
      <th width="20%"></td>
      <th class="text-center">

        </td>
      <th width="20%">  <h5 class="bg-success">Bramkarz</h>
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
  <td><h5 class="bg-primary">OBROŃCA</h>
     <select class="form-control cascadingDropDown"  name="mplayer4">
    <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
      <option value="${player.id}">
        ${player.firstname} ${player.lastname}

      </option>   </c:when>  </c:choose>
    </c:forEach></select>  </td>
      <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
         <select class="form-control cascadingDropDown"  name="mplayer5">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
          <option value="${player.id}" value="${player.price}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
        <select class="form-control cascadingDropDown"  name="mplayer6">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      </tr>
      <tr height="40px">

      </tr>
      <tr>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer7">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer8">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer9">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer10">
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
      <td></td>
        <td><h5 class="bg-info">NAPASTNIK</h>
          <select class="form-control cascadingDropDown"  name="mplayer11">
          <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
            <option value="${player.id}">
              ${player.firstname} ${player.lastname}

            </option> </c:when>  </c:choose>

          </c:forEach></select></td>
      <td></td>
      <td></td>
      </tr>

      </tbody>
      </table>

    </div>
    </div>
    <div class="col-6 col-md-4">  <div class="well well-sm">
      <div class="text-center">
        <c:set var = "budgett" scope = "session" value = "${100000-budget}"/>
    Twój aktualny budżet to:  <b><c:out value = "${budgett}"/></b> <br>
    Wybierz formację i wybierz piłkarzy, którzy będą grali w twojej podstawowej 11.
     <br>
<input type="hidden" name="formation" value="5-4-1"/>
       <input type="submit" class="btn btn-primary" value="Zapisz"/>
  </div></div></div></div></div>
</form>
</c:when>

<c:when test="${mode == 'MODE_MYTEAM-5-3-2'}">
<form class="form-horizontal" method="POST" action="save-myteam">


  <div container>

  <div class="row">
    <div class="col-12 col-md-8 col-sm-12">
    <div class="jumbotron">    <table class="table  text-center">

      <tr height="25px">
        <div class="dropdown">
          <button class="btn btn-default dropdown-toggle btn-lg" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            Formacja
        <span class="caret"></span></button>
           <ul class="dropdown-menu">
         <li>    <a href="myteam-4-4-2"> 4-4-2 </a></li>
         <li>     <a href="myteam-4-3-3"> 4-3-3 </a></li>
         <li>     <a href="myteam-4-5-1"> 4-5-1 </a></li>
         <li>     <a href="myteam-5-4-1"> 5-4-1 </a></li>
         <li>     <a href="myteam-5-3-2"> 5-3-2 </a></li>
         <li>     <a href="myteam-3-5-2"> 3-5-2 </a> </li>
           </ul>
         </div>
      </tr>



      <tbody>
      <tr>
      <th width="20%"></td>
      <th class="text-center">

        </td>
      <th width="20%">  <h5 class="bg-success">Bramkarz</h>
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
  <td><h5 class="bg-primary">OBROŃCA</h>
    <select class="form-control cascadingDropDown"  name="mplayer4">
    <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
      <option value="${player.id}">
        ${player.firstname} ${player.lastname}

      </option> </c:when>  </c:choose>
    </c:forEach></select>  </td>
      <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
         <select class="form-control cascadingDropDown"  name="mplayer5">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
          <option value="${player.id}" value="${player.price}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
        <select class="form-control cascadingDropDown"  name="mplayer6">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      </tr>
      <tr height="40px">

      </tr>
      <tr>
      <td></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer9">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer7">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer8">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td></td>
      </tr>
      <tr height="40px">

      </tr>
      <tr>
      <td></td>
      <td><h5 class="bg-info">NAPASTNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer10">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
        <td></td>
      <td><h5 class="bg-info">NAPASTNIK</h>
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
    <div class="col-6 col-md-4">  <div class="well well-sm">
      <div class="text-center">
        <c:set var = "budgett" scope = "session" value = "${100000-budget}"/>
    Twój aktualny budżet to:  <b><c:out value = "${budgett}"/></b> <br>
    Wybierz formację i wybierz piłkarzy, którzy będą grali w twojej podstawowej 11.
     <br>
<input type="hidden" name="formation" value="5-3-2"/>
       <input type="submit" class="btn btn-primary" value="Zapisz"/>
  </div></div></div></div></div>
</form>
  </c:when>

  <c:when test="${mode == 'MODE_MYTEAM-3-5-2'}">
<form class="form-horizontal" method="POST" action="save-myteam">


  <div container>

  <div class="row">
    <div class="col-12 col-md-8 col-sm-12">
    <div class="jumbotron">    <table class="table  text-center">

      <tr height="25px">
        <div class="dropdown">
          <button class="btn btn-default dropdown-toggle btn-lg" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            Formacja
        <span class="caret"></span></button>
           <ul class="dropdown-menu">
         <li>    <a href="myteam-4-4-2"> 4-4-2 </a></li>
         <li>     <a href="myteam-4-3-3"> 4-3-3 </a></li>
         <li>     <a href="myteam-4-5-1"> 4-5-1 </a></li>
         <li>     <a href="myteam-5-4-1"> 5-4-1 </a></li>
         <li>     <a href="myteam-5-3-2"> 5-3-2 </a></li>
         <li>     <a href="myteam-3-5-2"> 3-5-2 </a> </li>
           </ul>
         </div>
      </tr>



      <tbody>
      <tr>
      <th width="20%"></td>
      <th class="text-center">

        </td>
      <th width="20%">  <h5 class="bg-success">Bramkarz</h>
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

    <tr height="40px">

    </tr>
      <tr>
      <td class="text-center" ></td>
      <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
         <select class="form-control cascadingDropDown"  name="mplayer2">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
  <td> <h5 class="bg-primary">OBROŃCA</h>
     <select class="form-control cascadingDropDown"  name="mplayer3">
    <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
      <option value="${player.id}">
        ${player.firstname} ${player.lastname}

      </option>   </c:when>  </c:choose>
    </c:forEach></select> </td>
      <td class="text-center"><h5 class="bg-primary">OBROŃCA</h>
         <select class="form-control cascadingDropDown"  name="mplayer4">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Obrońca'}">
          <option value="${player.id}" value="${player.price}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td class="text-center"></td>
      </tr>
      <tr height="40px">

      </tr>
      <tr>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer5">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer6">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer7">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer8">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Pomocnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
      <td><h5 class="bg-danger">POMOCNIK</h>
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
      <td><h5 class="bg-info">NAPASTNIK</h>
         <select class="form-control cascadingDropDown"  name="mplayer10">
        <c:forEach var="player" items="${players}"><c:choose><c:when test="${player.position eq 'Napastnik'}">
          <option value="${player.id}">
            ${player.firstname} ${player.lastname}

          </option> </c:when>  </c:choose>
        </c:forEach></select></td>
        <td></td>
      <td><h5 class="bg-info">NAPASTNIK</h>
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
    <div class="col-6 col-md-4">  <div class="well well-sm">
      <div class="text-center">
        <c:set var = "budgett" scope = "session" value = "${100000-budget}"/>
    Twój aktualny budżet to:  <b><c:out value = "${budgett}"/></b> <br>
    Wybierz formację i wybierz piłkarzy, którzy będą grali w twojej podstawowej 11.
     <br>
<input type="hidden" name="formation" value="3-5-2"/>
       <input type="submit" class="btn btn-primary" value="Zapisz"/>
</div></div></div></div></div>
</form>
</c:when>

<c:when test="${mode == 'MODE_MYTEAM'}">

<div class="container">
      <h3><center> Twój aktualny skład:</center></h3>


<c:if test="${formation eq '4-4-2'}">
 <div class="jumbotron">    <table class="table  text-center">

   <tr height="85px">

   </tr>

   <tbody>
   <tr>
   <th width="20%"></td>
   <th width="20%"></td>
   <th width="20%">  <h3 class="bg-success">${p1.firstname}<br> ${p1.lastname}</h>
         </td>
   <th width="20%"></td>
   <th width="20%"></td>
   </tr>

 <tr height="40px">

 </tr>
   <tr>
   <td class="text-center" ><h3 class="bg-primary">${p2.firstname}<br> ${p2.lastname}</h>
   </td>
   <td class="text-center"><h3 class="bg-primary">${p3.firstname}<br> ${p3.lastname}</h>
    </td>
 <td>  </td>
   <td class="text-center"><h3 class="bg-primary">${p4.firstname}<br> ${p4.lastname}</h>
    </td>
   <td class="text-center"><h3 class="bg-primary">${p5.firstname}<br> ${p5.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td><h3 class="bg-danger">${p6.firstname}<br> ${p6.lastname}</h>
      </td>
   <td><h3 class="bg-danger">${p7.firstname}<br> ${p7.lastname}</h>
    </td>
   <td></td>
   <td><h3 class="bg-danger">${p8.firstname}<br> ${p8.lastname}</h>
    </td>
   <td><h3 class="bg-danger">${p9.firstname}<br> ${p9.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td></td>
   <td><h3 class="bg-info">${p10.firstname}<br> ${p10.lastname}</h>
      </td>
   <td></td>
   <td><h3 class="bg-info">${p11.firstname}<br> ${p11.lastname}</h>
     </td>
   <td></td>
   </tr>

   </tbody>
   </table>

 </div>
</c:if>
<c:if test="${formation eq '4-3-3'}">

 <div class="jumbotron">    <table class="table  text-center">

   <tr height="85px">

   </tr>
   <tbody>
   <tr>
   <th width="20%"></td>
   <th width="20%">

     </td>
   <th width="20%">  <h3 class="bg-success">${p1.firstname}<br> ${p1.lastname}</h>
         </td>
   <th width="20%">

  </td>
   <th width="20%"></td>
   </tr>

 <tr height="40px">

 </tr>
   <tr>
   <td class="text-center" ><h3 class="bg-primary">${p2.firstname} <br> ${p2.lastname}</h>
   </td>
   <td class="text-center"><h3 class="bg-primary">${p3.firstname}<br>  ${p3.lastname}</h>
    </td>
 <td>  </td>
   <td class="text-center"><h3 class="bg-primary">${p4.firstname} <br> ${p4.lastname}</h>
    </td>
   <td class="text-center"><h3 class="bg-primary">${p5.firstname} <br> ${p5.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td>  </td>
   <td><h3 class="bg-danger">${p6.firstname}<br>  ${p6.lastname}</h>
  </td>
   <td><h3 class="bg-danger">${p7.firstname}<br>  ${p7.lastname}</h>
 </td>
   <td><h3 class="bg-danger">${p8.firstname}<br>  ${p8.lastname}</h>
    </td>
   <td>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td></td>
   <td><h3 class="bg-info">${p9.firstname} <br> ${p9.lastname}</h>
      </td>
   <td><h3 class="bg-info">${p10.firstname}<br>  ${p10.lastname}</h>
 </td>
   <td><h3 class="bg-info">${p11.firstname}<br>  ${p11.lastname}</h>
     </td>
   <td></td>
   </tr>

   </tbody>
   </table>

 </div>
</c:if>
<c:if test="${formation eq '4-5-1'}">
 <div class="jumbotron">    <table class="table  text-center">

   <tr height="85px">

   </tr>

   <tbody>
   <tr>
   <th width="20%"></td>
   <th width="20%"></td>
   <th width="20%">  <h3 class="bg-success">${p1.firstname}<br> ${p1.lastname}</h>
         </td>
   <th width="20%"></td>
   <th width="20%"></td>
   </tr>

 <tr height="40px">

 </tr>
   <tr>
   <td class="text-center" ><h3 class="bg-primary">${p2.firstname}<br> ${p2.lastname}</h>
   </td>
   <td class="text-center"><h3 class="bg-primary">${p3.firstname}<br> ${p3.lastname}</h>
    </td>
 <td>  </td>
   <td class="text-center"><h3 class="bg-primary">${p4.firstname}<br> ${p4.lastname}</h>
    </td>
   <td class="text-center"><h3 class="bg-primary">${p5.firstname}<br> ${p5.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td><h3 class="bg-danger">${p6.firstname}<br> ${p6.lastname}</h>
      </td>
   <td><h3 class="bg-danger">${p7.firstname}<br> ${p7.lastname}</h>
    </td>
   <td><h3 class="bg-danger">${p8.firstname}<br> ${p8.lastname}</h>
   </td>
   <td><h3 class="bg-danger">${p9.firstname}<br> ${p9.lastname}</h>
    </td>
   <td><h3 class="bg-danger">${p10.firstname}<br> ${p10.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td></td>
   <td></td>
   <td><h3 class="bg-info">${p11.firstname}<br> ${p11.lastname}</h></td>
   <td></td>
   <td></td>
   </tr>

   </tbody>
   </table>

 </div>
</c:if>
<c:if test="${formation eq '5-4-1'}">
 <div class="jumbotron">    <table class="table  text-center">

   <tr height="85px">

   </tr>

   <tbody>
   <tr>
   <th width="20%"></td>
   <th width="20%"></td>
   <th width="20%">  <h3 class="bg-success">${p1.firstname}<br> ${p1.lastname}</h>
         </td>
   <th width="20%"></td>
   <th width="20%"></td>
   </tr>

 <tr height="40px">

 </tr>
   <tr>
   <td class="text-center"><h3 class="bg-primary">${p2.firstname}<br> ${p2.lastname}</h>
   </td>
   <td class="text-center"><h3 class="bg-primary">${p3.firstname}<br> ${p3.lastname}</h>
    </td>
 <td> <h3 class="bg-primary">${p4.firstname}<br> ${p4.lastname}</h>
  </td>
   <td class="text-center"><h3 class="bg-primary">${p5.firstname}<br> ${p5.lastname}</h>
    </td>
   <td class="text-center"><h3 class="bg-primary">${p6.firstname}<br> ${p6.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td><h3 class="bg-danger">${p7.firstname}<br> ${p7.lastname}</h>
      </td>
   <td><h3 class="bg-danger">${p8.firstname}<br> ${p8.lastname}</h>
    </td>
   <td>
   </td>
   <td><h3 class="bg-danger">${p9.firstname}<br> ${p9.lastname}</h>
    </td>
   <td><h3 class="bg-danger">${p10.firstname}<br> ${p10.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td></td>
   <td></td>
   <td><h3 class="bg-info">${p11.firstname}<br> ${p11.lastname}</h></td>
   <td></td>
   <td></td>
   </tr>

   </tbody>
   </table>

 </div>
</c:if>
<c:if test="${formation eq '5-3-2'}">
 <div class="jumbotron">    <table class="table  text-center">

   <tr height="85px">

   </tr>

   <tbody>
   <tr>
   <th width="20%"></td>
   <th width="20%"></td>
   <th width="20%">  <h3 class="bg-success">${p1.firstname}<br> ${p1.lastname}</h>
         </td>
   <th width="20%"></td>
   <th width="20%"></td>
   </tr>

 <tr height="40px">

 </tr>
   <tr>
   <td class="text-center"><h3 class="bg-primary">${p2.firstname}<br> ${p2.lastname}</h>
   </td>
   <td class="text-center"><h3 class="bg-primary">${p3.firstname}<br> ${p3.lastname}</h>
    </td>
 <td> <h3 class="bg-primary">${p4.firstname}<br> ${p4.lastname}</h>
  </td>
   <td class="text-center"><h3 class="bg-primary">${p5.firstname}<br> ${p5.lastname}</h>
    </td>
   <td class="text-center"><h3 class="bg-primary">${p6.firstname}<br> ${p6.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td>
      </td>
   <td><h3 class="bg-danger">${p7.firstname}<br> ${p7.lastname}</h>
    </td>
   <td><h3 class="bg-danger">${p8.firstname}<br> ${p8.lastname}</h>
   </td>
   <td><h3 class="bg-danger">${p9.firstname}<br> ${p9.lastname}</h>
    </td>
   <td>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td></td>
   <td><h3 class="bg-info">${p10.firstname}<br> ${p10.lastname}</h></td>
   <td></td>
   <td><h3 class="bg-info">${p11.firstname}<br> ${p11.lastname}</h></td>
   <td></td>
   </tr>

   </tbody>
   </table>

 </div>
</c:if>
<c:if test="${formation eq '3-5-2'}">
 <div class="jumbotron">    <table class="table  text-center">

   <tr height="85px">

   </tr>

   <tbody>
   <tr>
   <th width="20%"></td>
   <th width="20%"></td>
   <th width="20%">  <h3 class="bg-success">${p1.firstname}<br> ${p1.lastname}</h>
         </td>
   <th width="20%"></td>
   <th width="20%"></td>
   </tr>

 <tr height="40px">

 </tr>
   <tr>
   <td class="text-center">
   </td>
   <td class="text-center"><h3 class="bg-primary">${p2.firstname}<br> ${p2.lastname}</h>
    </td>
 <td><h3 class="bg-primary">${p3.firstname}<br> ${p3.lastname}</h>  </td>
   <td class="text-center"><h3 class="bg-primary">${p4.firstname}<br> ${p4.lastname}</h>
    </td>
   <td class="text-center">
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td><h3 class="bg-danger">${p5.firstname}<br> ${p5.lastname}</h>
      </td>
   <td><h3 class="bg-danger">${p6.firstname}<br> ${p6.lastname}</h>
    </td>
   <td><h3 class="bg-danger">${p7.firstname}<br> ${p7.lastname}</h></td>
   <td><h3 class="bg-danger">${p8.firstname}<br> ${p8.lastname}</h>
    </td>
   <td><h3 class="bg-danger">${p9.firstname}<br> ${p9.lastname}</h>
    </td>
   </tr>
   <tr height="40px">

   </tr>
   <tr>
   <td></td>
   <td><h3 class="bg-info">${p10.firstname}<br> ${p10.lastname}</h>
      </td>
   <td></td>
   <td><h3 class="bg-info">${p11.firstname}<br> ${p11.lastname}</h>
     </td>
   <td></td>
   </tr>

   </tbody>
   </table>

 </div>
</c:if>
</div>
</c:when>
</c:choose>
          <br>

                                        <script src="static/js/jquery-1.11.1.min.js"></script>
                                <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>
