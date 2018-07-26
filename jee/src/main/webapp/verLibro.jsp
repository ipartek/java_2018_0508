
	<%@page import="com.ipartek.formacion.gestor.libros.pojo.Libro"%>

	<%@ include file = "includes/header.jsp" %>

	<%@ include file = "includes/navbar.jsp" %>
	
	
	<div class="media justify ">
		
		<h1>Ver Libro</h1>


		<h2>Titulo: ${libro.getTitulo()}</h2>
		<h2>ISBN: ${libro.getIsbn()}</h2>
		<h2>Editorial: ${libro.getEditorial()}</h2>
		<%
		Libro l = (Libro)request.getAttribute("libro");
		%>
		<h2>Prestado: <%=(l.isPrestado())?"Prestado":"Libre"%></h2>

	</div>

	<%@ include file = "includes/footer.jsp" %>