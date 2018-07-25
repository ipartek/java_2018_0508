<%@ include file="includes/header.jsp" %>	
<%@ include file="includes/navbar.jsp" %>
	
	<%
		//Esto es Java
		
		out.print("<p>Soy Java</p>");
	
	%>
			
	<form action="saludo" method="post">
	
		<input type="text" name="nombrePost" placeholder="Escribe tu nombre" />
		<p class="text-danger">${msg}</p>
		<input type="submit" value="enviar"/>
	
	</form>
<%@ include file="includes/footer.jsp" %>