<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>



	<main role="main" class="container">
		<h1>Formulario Alta Producto</h1>
		
		
		<form action="formulario" method="post" novalidate>
		
			
			<input type="text" name="codigo" required placeholder="Código del Producto">
		
			<input type="submit" value="Nueva Alta">
		</form>
		
		
	</main>


<%@include file="includes/footer.jsp" %>