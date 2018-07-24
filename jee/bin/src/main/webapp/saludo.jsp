<!doctype html>

<%@page import="java.beans.Expression"%>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Saludo</title>
<meta name="description"
	content="App Web 3.0 para gestionar prestamo de libros">
<meta name="author" content="Asier Cornejo">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>



	<h1>
	
	
		<%
			//Esto es java
	String nombre = (String)request.getAttribute("nombreCompleto");
		/*String nombre = (String) request.getAttribute("nombre");
		String apellido1 = (String) request.getAttribute("ap1");
		String apellido2 = (String) request.getAttribute("ap2");*/
		if(request.getMethod().equalsIgnoreCase("GET")){
		//	out.print("<p>Bienvenido</p>" + nombre+" "+apellido1+" "+apellido2);
		
			
		}else{
			
			out.print("<p>Bienvenido</p>" + nombre);
		}
	
			
		%>
	</h1>

		<hr>
		Expression Language
		<b> ${nombreCompleto}</b>
		
		
		 <hr>
	<script src="js/scripts.js"></script>
</body>
</html>