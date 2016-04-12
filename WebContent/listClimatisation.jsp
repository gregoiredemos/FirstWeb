<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>


<%-- <h1>Votre nom: ${nom}</h1>  --%>




<c:choose>
   <c:when test="${not empty nom}" >
 <div> ${sessionScope.nom} est connecté </div> 
 <a href="LogoutController"> se déconnecter</a><br/>
 </c:when> 

  <c:otherwise>
   <a href="LoginController"> se connecter</a><br/>
 </c:otherwise> 
  </c:choose>
  
 <a href="ClimatisationController">saisie d'une climatisation </a><br/>
 <br/>
 <br/>
 
 
  
 
 
   <c:forEach var="clim" items="${climatisations}" >
   <!--  il appelle getTemperature-->
  <h3>${rechercheDataErreur}</h3>
  
 <h1 style= "color:red"> ${clim.nomAppareil}</h1><br/>
    <h3>${clim.temperature}</h3>
    <h3>${clim.pression}</h3>
    <h3>${clim.tauxHumidite}</h3> 
   
   
    </c:forEach>



</body>
</html>