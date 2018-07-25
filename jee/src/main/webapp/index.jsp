<%@ include file="includes/header.jsp" %>		
<%@ include file="includes/navbar.jsp" %>
	
		<h1>CMS Prestamos Libros</h1>
		
		<%
			//Esto es java
			out.print("<p>Soy Java</p>");
		%>
		
		<form action="saludo" method="post">
			<input name="nombre" type="text" placeholder="Dime tu nombre"><br>
			<input name="apellido1" type="text" placeholder="Dime tu primer apellido"><br>
			<input name="apellido2" type="text" placeholder="Dime tu segundo apellido"><br>
			<p style="color: red">${msg}</p>
			<input type="submit" value="Enviar">
		</form>

<%@ include file="includes/footer.jsp" %>