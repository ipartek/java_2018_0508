<%@ include file ="includes/header.jsp" %>
	
	<%@ include file ="includes/navbar.jsp" %>
	
	<h1>CMS Préstamo Libros</h1>

	<!--<a href="saludo?nombre=pepe"> Saludar </a>
		<a href="saludo?nombre=pepe&ape1=otilio&ape2=gomez"> Saludar </a>-->
	 
	<%
		//Esto es Java
		out.print("<p>Soy Java</p>");
	%>	
	 	
	<form action="saludo" method="post" >	
		<input name="user" type="text" placeholder="Dime tu nombre">
		<p class="text-danger">${msg}</p>
		<input type="submit" value="Enviar">	
	</form>

<%@ include file ="includes/footer.jsp" %>