<%@page import="java.net.URLDecoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>
<%@page import="com.ipartek.formacion.youtube.Video"%>
<%@page import="java.util.ArrayList"%>


<c:set var="idioma" value="${(not empty sessionScope.idioma)?sessionScope.idioma:'es_ES' }" />
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="idiomas" /> 


<!DOCTYPE html>
<html lang="${idioma}">

<head>

<!-- Comenza todas las URLs desde el href indicado -->
<base href="<%=request.getContextPath()%>/">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Youtube Video Play List </title>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

<!-- Bootstrap core CSS -->
<link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css"
	rel="stylesheet">
	
 <link href="css/shop-item.css" rel="stylesheet">    
 <link href="css/styles.css" rel="stylesheet">

</head>

<body>

