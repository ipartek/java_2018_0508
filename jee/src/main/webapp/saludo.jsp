<%@page import="com.ipartek.formacion.gestor.libros.controller.SaludoController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Saludo</title>
</head>
<body>
	<h1>Saludamos</h1>
	<%
	//recibir atributos en un jsp
	String nombre=(String)request.getAttribute("nombreCompleto");
	out.print(nombre);
	%>
	
	<%=request.getAttribute("nombreCompleto")%>
	
</body>
</html>