<!DOCTYPE HTML>
<%@page import="com.ipartek.formacion.gestor.videos.pojo.Libro"%>
<html lang="es">
<head>
<meta charset="utf-8">

	<title>Registrar un libro</title>
	<meta name="author" content="Luis">

</head>

<body>

	<h1>Confirmar Registro de Libro</h1>
	
	<p> Título: ${libro.titulo} </p>
	<p> Autor: ${libro.autor} </p>
	<p> Editorial: ${libro.editorial} </p>
	<p> ISBN: ${libro.isbn} </p>
	<p> Número de páginas: ${libro.numPaginas} </p>
	<p> Prestado:
	 <% 
	 	Libro l = (Libro) request.getAttribute("libro"); // Casteamos el libro
		
	 	if (  l.isPrestado()   ) { // Si es prestado
			out.print("Sí");
	 	
		} else { // Si no es prestado
			out.print("No");
		}
	
	%>
	
	
	<form name="registro-libro" method="get" action="registrar-libro">
	<input type="submit" value="Confirmar">
	</form>
	
	
	

</body>
</html>