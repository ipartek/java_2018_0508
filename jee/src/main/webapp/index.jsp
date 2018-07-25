
<%@ include file="includes/header.jsp" %>



	<h1>CMS Prestamos Libros</h1>
	
	<%@ include file="includes/navbar.jsp" %>
	
	<form action="saludo" method="post">
		Nombre:<input name="nom" type="text">
		<p style="color: red">${msg }</p>
		<input type="submit" value="enviar">
	</form>
	<%@ include file="includes/footer.jsp" %>