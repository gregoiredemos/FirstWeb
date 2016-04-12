<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage de la date du jour</title>
</head>

<body>
<h1> 
La date du jour est: ${dateDuJours}</h1>

<h1> Il est: ${monheure} </h1>

<h1>Les données mesurées par le capteur sont:</h1>

<h2> La temperature: ${clim1.getTemperature()} <br/>
La temperature Farenheit: ${clim1.temperatureFarenheit} <br/>
La pression: ${clim1.pression} <br/>
Le nom de l'appareil:  ${clim1.nomAppareil} <br/>

</h2>


</body>
</html>