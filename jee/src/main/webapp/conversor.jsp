<!DOCTYPE HTML>
<%@page import="com.ipartek.formacion.gestor.videos.controller.ConversorController"%>
<html lang="es">
<head>
<meta charset="utf-8">

	<title>Conversor de medidas de longitud</title>
	<meta name="author" content="Luis">
	<link rel="stylesheet" href="css/styles.css?v=2.0">
	<link rel="stylesheet" href="css/conversorstyles.css?v=2.0">
</head>

<body>

	<%@ include file="includes/navbar.jsp"%>

	<h1>Conversor de metros a pulgadas </h1>
	
	<p> Admite conversión de números decimales o flotantes.<p>
	<p> Formato aceptado: 0.0</p>
	
	<select name="unidad">
  		<option value="Pies" selected>Pies</option> 
  		<option value="Pulgadas">Pulgadas</option>
	</select>

	<form name="conversor" method="post">
		<input type="text" name="num" placeholder="Valor a convertir." autocomplete="off" autofocus>
		<input type="submit" name="operacion" value="Metros a">	
		<label>${unidad}</label>
		<input type="submit" name="operacion" value="a Metros">
	</form>
	<span>${msg}</span>

</body>
</html>