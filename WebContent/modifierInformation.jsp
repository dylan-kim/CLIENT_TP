<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.servlet.CalculDistanceServlet" %>
<%@ page import="com.servlet.AfficherInformationServlet" %>

<%@ page import="com.dto.VilleDTO" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<!-- Semantic UI 2.4.1-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
    
	<title>Distance Ville France</title>
	
	
</head>

<body>
	<div class="ui five item menu">
	  <a class="item" href="<c:url value="calculDistance"/>">Distance Ville | FRANCE</a>
	  <a class="item" href="<c:url value="afficherInformation"/>">Information Ville | FRANCE</a>
	  <a class="item active">Modifier Ville | ${ville.getNomCommune()}</a>
	</div>
	
	<div class="ui three item menu">
		<form class="ui form" action="modifierInformation" method="POST">
		  <div class="field">
		    <label>Code Commune</label>
		    <input type="hidden" name="codeCommune" value="${ ville.getCodeCommune() }">
		    <input type="text" name="" placeholder="${ ville.getCodeCommune() }" value="${ ville.getCodeCommune() }" disabled type="hidden">
		  </div>
		  <div class="field">
		    <label>Nom Commune</label>
		    <input type="text" name="nomCommune" value="${ ville.getNomCommune() }">
		  </div>
		  <div class="field">
		    <label>Code Postal</label>
		    <input type="text" name="codePostal" value="${ ville.getCodePostal() }">
		  </div>
		  <div class="field">
		    <label>Libelle Acheminement</label>
		    <input type="text" name="libelleAcheminement" value="${ ville.getLibelleAcheminement() }">
		  </div>
		  <div class="field">
		    <label>Ligne 5</label>
		    <input type="text" name="ligne5" value="${ ville.getLigne5() }">
		  </div>
		  <div class="field">
		    <label>Latitude</label>
		    <input type="text" name="latitude" value="${ ville.getLatitude() }">
		  </div>
		  <div class="field">
		    <label>Longitude</label>
		    <input type="text" name="longitude" value="${ ville.getLongitude() }">
		  </div>
		  <button class="ui button" type="submit">Submit</button>
		</form>
	</div>	
	
	
</body>

</html>