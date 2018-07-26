<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Ahorcado</title>
<meta name="description"
	content="App web Java 3.0 para gestionar préstamos de libros">
<meta name="author" content="raul">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>Ahorcado</h1>
	<div width="50%">
		<form action="ahorcado">
			<input name="mostrarPalabra" type="submit" value="Start">
		</form>
	</div>
	<div width="50%">
		<form action="ahorcado">
			<input name="reiniciar" type="submit" value="restart">
		</form>
	</div>
	
	<%
		
		out.println("<div center>" );
		String pc = (String) request.getAttribute("pc");
		String Sugerencias = (String) request.getAttribute("Sugerencias");
		if(pc != null && pc.contains("*")){
			out.println("<h2> Sugerencia : " + Sugerencias);
			out.println("<h2> Adivina la palabra : " + pc);
		}else{
			if(pc != null && !pc.contains("*")){
				out.println("<h2> Enhorabuena !! Acertartes la palabra : " + pc);
				
				
			}
		}
		
		out.println("</div>" );
	%>
	
	<form action="ahorcado">
		<input name="letraAhorcado" type="text" placeholder="Escribe letra..."> 
		<br> 
		<input type="submit" value="Enviar"> 
	</form>
	

	<%
		//Recibir atributo de una JSP
		String usuarioLetra = (String) request.getAttribute("letraAhorcado");
		String msg = (String) request.getAttribute("msg");
		//int vidas =(Integer) request.getAttribute("vidas");
		
		
		 if (usuarioLetra != null){
			out.println("<p> Letra seleccionada " +usuarioLetra);
		}
		 
		if (msg != null){
			out.println("<br>");
			out.println(msg);
		}
		if(request.getAttribute("vidas") != null){
			out.println("<br>");
			out.print("Le quedan "+request.getAttribute("vidas")+" vidas");
		}

		
	%>
	
	<%
	String stilos = (String) request.getAttribute("stilos");
	out.println("<br>");
	if (stilos != null){
		out.println(stilos);
	}
	
	%>

	
	 <div class="${stilos }"></div>
</body>
</html>