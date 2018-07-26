<!doctype html>

<%@page import="java.util.Iterator"%>
<%@page import="com.ipartek.formacion.gestor.libros.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>
<html lang="es">
<head>
	<meta charset="utf-8">
	
	<title>Gestion Libros</title>
	<meta name="description" content="App Web Java 3.0 para Gestionar Prestamo de Libros">
	<meta name="author" content="Adrian Perozzo">
	
	<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<%@ include file = "includes/navbar.jsp" %>

	<h1>Libros Prestados</h1>
	
	<table>
	
		<thead>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>ISBN</th>
				<th>Editorial</th>
				<th>Estado</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Libro> biblioteca = (ArrayList<Libro>)(request.getAttribute("biblioteca"));
			 	Iterator<Libro> it=biblioteca.iterator();
			%>
	
			<%while(it.hasNext()){
              Libro libro=it.next();%>
             <tr class="<%= (libro.isPrestado()==true)?"prestado":"libre" %>">
             	<td><%= libro.getId() %></td>
             	<td><%= libro.getTitulo() %></td>
             	<td><%= libro.getIsbn() %></td>
             	<td><%= libro.getEditorial() %></td>
             	<td><%= (libro.isPrestado()==true)?"Prestado":"Libre" %></td>
              </tr>
              <%}%>  
		</tbody>
		
	</table>
	
	<%@ include file = "includes/footer.jsp" %>