<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
		<h1>Resultado</h1>
		
		
		<h2>Scriplet</h2>
		<%
			Producto p = (Producto)request.getAttribute("producto");
			out.print(p);
		%>
		
		<hr>
		
		<h2>EL - Expresion Lenguage</h2>
		${producto}
		
	</main>


<%@include file="includes/footer.jsp" %>