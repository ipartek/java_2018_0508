<!-- Directivas para usar Tags el prefijo es  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%-- <%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.pojo.Comentarios"%>
<%@page import="com.ipartek.formacion.pojo.Alerts"%>
<%@page import="com.ipartek.formacion.pojo.Video"%> --%>
<%@page import="com.ipartek.formacion.youtube.controller.VideoYoutubeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>


<%-- <c:set var="idioma" value="${not empty sessionScope.idoma)?sessionScope }"/> --%>
<%
String idioma = "";
	Cookie[] cookiesTest = request.getCookies();
	for( Cookie c : cookiesTest ){
		if ( "cookieIdioma".equals(c.getName())){
			idioma = c.getValue();
			break;
		}	
	}
		
%>
<fmt:setLocale value="<%=idioma %>" />
<fmt:setBundle basename="idiomas" /> 
<!DOCTYPE html>
<html lang="en">

  <head>

	<!-- Comenza todas las URLs desde el href indicado -->
	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Youtube Video Play List</title>

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	
    <!-- Bootstrap core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css" rel="stylesheet">
	<!-- Fontawasome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<!-- Estilos propios pero no termina de cogerlos -->
	<link rel="stylesheet" href="css/styles.css" >
	 <!-- Bootstrap core JavaScript -->
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/home.js"></script>
	

  </head>

  <body>

