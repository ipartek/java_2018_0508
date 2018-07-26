<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
	
<%out.print("<p>Mensaje desde Java</p>");%>
	<h1>CMS GESTION LIBROS</h1>
	<!-- SPRITE -->
	<div class="ahorcado"></div>
	<style>
		.ahorcado{
			border:1px solid red;
			width:75px;
			height: 100px;
			overflow: hiddden;
			background-image: url(img/ahorcado.jpg);
			background-position-x:616px;
		}
		.fallo0{background-position-x:616px;}
		.fallo1{background-position-x:539px;}
		.fallo2{background-position-x:462px;}
		.fallo3{background-position-x:462px;}
		.fallo4{background-position-x:462px;}
		.fallo5{background-position-x:462px;}
		.fallo6{background-position-x:462px;}
	</style>
	
	
	<p> - POST - </p>
	<form action="bienvenida" method="post">
		<input name="nombre" type="text" placeholder="Dime tu nombre">
		<p class="text-danger">${msg}</p>
		<input type="submit" value="enviar">
	</form>
	
	<!-- AHORCADO --><br><br>
	
<%@ include file="includes/footer.jsp" %>
	
 