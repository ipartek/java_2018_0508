
<%@page
	import="com.ipartek.formacion.gestor.libros.controller.ConversorController" %>

<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>



<h1>Conversor</h1>


<form class="conversor" action="conversor" method="get">
	<input type="text" name="unidadMetros" value="${resultado1}" /> <label
		for="unidad">Metros => Pies</label> <input type="hidden"
		name="formulario " value=<%=ConversorController.FORMULARIO1%> /> <input
		type="submit" value="Convertir" />
</form>


<form class="conversor" action="conversor" method="get">
	<input type="text" name="unidadPies" value="${resultado2}" /> <label
		for="unidad">Pies => Metros</label> <input type="hidden"
		name="formulario " value=<%=ConversorController.FORMULARIO2%> /> <input
		type="submit" value="Convertir" />
</form>

<p>${msg}</p>

<%@ include file="includes/footer.jsp" %>