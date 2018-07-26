<%@page import="com.ipartek.formacion.gestor.libros.controller.ConversorController"%>
<%@include file="includes/navbar.jsp"%>
<%@include file="includes/header.jsp"%>

	<h1>CONVERSOR METROS TO PIES</h1>
	
	<form action="conversor" method="post">
		<label>Metros</label>
		<input name="valor" type="text" placeholder="metros">
		<input type="submit" value="Convertir" />
		<input name="formulario" type="hidden" value="<%=ConversorController.FORMULARIO1%>">
		<br/>
		<span class="resultado"> ${resultadoPies}</span>
		
	</form>
	
	<form action="conversor" method="post">
		<label>Pies </label>
		<input name="valor" type="text" placeholder="pies">
		<input type="submit" value="Convertir" />
		<input name="formulario" type="hidden" value="<%=ConversorController.FORMULARIO1%>">
		<br/>
		<span class="resultado"> ${resultadoMetros}</span>
	
	</form>

	<p class="text-danger">${msg}</p>
	
<%@include file="includes/footer.jsp"%>