<%@page import="com.ipartek.formacion.gestor.libros.controller.ConversorController"%>

<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

	<h1>Conversor</h1>
	
	<form action="conversor" method="get">
		<label for="unidad">Metros => Pies</label>
		<input type="text" name="unidad" value="<%=request.getAttribute("resultado1")%>">
		<input type="hidden" name="formulario" value="<%=ConversorController.FORMULARIO1%>">
		<input type="submit" value="Convertir">	
	</form>
	
	<form action="conversor" method="get">
		<label for="unidad">Pies => Metros</label>
		<input type="text" name="unidad"  value="${resultado2}">
		<input type="hidden" name="formulario" value="<%=ConversorController.FORMULARIO2%>">
		<input type="submit" value="Convertir">	
	</form>
		
	<p>${mensaje}</p>
				
<%@ include file="includes/footer.jsp" %>