<%@ include file="includes/header.jsp"%>
<h1>CMS Prestamos Libros</h1>
<%@ include file="includes/navbar.jsp"%>

<form action="saludo" method="post">

	<input name="nom" type="text" placeholder="Dime tu Nombre">
	<p class="text-danger">${msg}</p>

	<input type="submit" value="Enviar">

</form>

<%@ include file="includes/footer.jsp"%>