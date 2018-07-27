<%@page import="com.ipartek.formacion.gestor.libros.pojo.Libro"%>
<%@include file="includes/navbar.jsp"%>
<%@include file="includes/header.jsp"%>
		<h1>Detalles del libro</h1>
		
		<%
			Libro l = (Libro)request.getAttribute("libro");
		%>
		
		<h2>Titulo: <span class="normal">${libro.getTitulo()}</span></h2>
		<h2>ISBN: <span class="normal">${libro.getIsbn()}</span></h2>
		<h2>Editorial:<span class="normal"> ${libro.getEditorial()}</span></h2>
		<h2>prestado:<span class="normal"> ${prestado}</span></h2>
		
		
	<%@include file="includes/footer.jsp"%>