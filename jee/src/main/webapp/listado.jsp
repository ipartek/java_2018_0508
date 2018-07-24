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

	<h1>Libros Prestados</h1>
	
	<table>
	
		<tr>
			<td>ID</td>
			<td>Titulo</td>
			<td>ISBN</td>
			<td>Editorial</td>
			<td>Estado</td>
		</tr>
	
		<%
			ArrayList<Libro> biblioteca = (ArrayList<Libro>)(request.getAttribute("biblioteca"));
		 	Iterator<Libro> it=biblioteca.iterator();
		%>
	
			<%while(it.hasNext()){
              Libro libro=it.next();%>
             <tr>
             	<td><%= libro.getId() %></td>
             	<td><%= libro.getTitulo() %></td>
             	<td><%= libro.getIsbn() %></td>
             	<td><%= libro.getEditorial() %></td>
             	<td><%= (libro.isPrestado()==true)?"Prestado":"Libre" %></td>
              </tr>
              <%}%>  
	
	</table>
	
	<script src="js/scripts.js"></script>
	
</body>

</html>