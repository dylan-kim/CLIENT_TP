<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.servlet.PageVilleServlet" %>
<%@ page import="com.servlet.PageInformationVilleServlet" %>


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
	  <a class="item" href="<c:url value="pageVilleServlet"/>">Distance Ville | FRANCE</a>
	  <a class="item" href="<c:url value="pageInformationVilleServlet"/>">Information Ville | FRANCE</a>
	</div>
</body>

</html>