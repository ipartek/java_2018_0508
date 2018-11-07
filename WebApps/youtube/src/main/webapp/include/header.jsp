<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- CLASES PROPIAS -->
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Properties"%>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<c:set var="locale" value="${ not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES' }" scope="session" />
<fmt:setLocale value="${ locale }" />
<fmt:setBundle basename="idiomas" /> 

<!DOCTYPE html>
<html lang="${ locale }">

  <head>
  
	<!-- Comenza todas las URLs desde el href indicado -->
	<base href="${ pageContext.request.contextPath }/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="lista.repr"/></title>

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
	
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/bootstrap/css/bootstrap-toggle.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="vendor/bootstrap/css/shop-item.css" rel="stylesheet">
    
    <!-- My own CSS -->
    <link href="css/styles.css?v10" rel="stylesheet"></link>
    

  </head>

  <body>
  
