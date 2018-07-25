<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Conversor</title>
<meta name="description"
	content="App web Java 3.0 para gestionar préstamos de libros">
<meta name="author" content="raul">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>Conversor</h1>
	
	
	<form action="conversor">
		<input name="m2p" type="text" placeholder="Introduce metros"> 
		 
		
		 
		<br> 
		<input type="submit" value="Convertir a pies">
	</form>
	<form action="conversor">
		<input name="p2m" type="text" placeholder="Introduce pies"> 
		<br> 
		<input type="submit" value="Convertir a metros">
	</form>
	
	<%
		//Recibir atributo de una JSP
		String piesConvertidos = (String) request.getAttribute("piesConvertidos");
		String msg = (String) request.getAttribute("msg");
		//int vidas =(Integer) request.getAttribute("vidas");
		
		out.println("<p> Test");
		 if (piesConvertidos != null){
			out.println("<p> El resultado es:  " +piesConvertidos);
		}
		 
		

		
	%>
	<!--  
	<form action="conversor">
		<input name="formulario" type="text" placeholder="Introduce pies"> 
		<br> 
		<input type="hidden" value="1">
	</form>
	-->
	

</body>
</html>