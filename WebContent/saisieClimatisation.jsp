<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="Climatisation.js"></script>

</head>

<body>

<c:choose>

 <c:when test="${not empty sessionScope.nom}" >
 <div> ${sessionScope.nom} est connecté </div> 
 <a href="LogoutController"> se déconnecter</a><br/>
 </c:when> 
 
  <c:otherwise>
  <a href="LoginController"> se connecter</a><br/>
 </c:otherwise>
 </c:choose>
  
 <a href="ListClimatisationController">Liste des climatisations </a>

 <br/>
 <br/>




<form action="ClimatisationController"method="post">   

<label> Nom de l'appareil </label><input id="sourceNbId" type="text" value="${nomAppareil}" name="nomAppareil" /> <span style= "color:red"> ${nomAppareilFaux}</span><br/><span id="nbId" style= "color:red"></span>

<label> Temperature </label><input type="text" value="${temperature} " name="temperature" /> <span style= "color:red"> ${temperatureErreur}</span><br/>
<label>Tauxhumidite </label><input type="text" value="${tauxhumidite}" name="tauxhumidite" /><span style= "color:red"> ${tauxhumiditeErreur}</span><span style= "color:red">${tauxhumiditeFaux}</span><br/>
<label>Pression </label><input type="text" value="${pression}" name="pression" /><span style= "color:red"> ${pressionErreur}</span><span style= "color:red">${pressionFaux}<br/></span><br>
<input type="submit" value="Enregistrer" name="action" /><br/> <span> ${sauvegardeErreur} </span>
</form>

</body>
</html>