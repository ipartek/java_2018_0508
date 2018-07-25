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
	<form action="ahorcado">
		<input type="submit" value="Start">
	</form>
	<%
		
		out.println("<div center>" );
		String pc = (String) request.getAttribute("pc");
		if(pc != null && pc.contains("*")){
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
	

	
	 <div class="ahorcado"></div>
</body>
</html>