<%@ include file="includes/header.jsp"%>

<h1>RESUMEN DEL LIBRO ${titulo}</h1>

<ul>
	<li>Titulo: ${libro.titulo}</li>
	<li>ISBN: ${libro.isbn}</li>
	<li>Editorial: ${libro.editorial}</li>
	<li>Prestado: ${libro.prestado}</li>
</ul>

<%@ include file="includes/footer.jsp"%>