<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
	
	<%
		//Esto es Java
		/*
		String nombreCompleto = (String)request.getAttribute("nombreCompleto");
		
		out.print("<h1>Hola " + nombreCompleto + "</h1>"); //Forma de escribir una variable
		
		String nombrePost = (String)request.getAttribute("nombrePost");
		
		out.print("<h1>Nombre = " + nombrePost + "</h1>");
		*/
	%>
	
	<h1>${msgBienvenida}</h1>
	
	<hr/>
	
	Expression Language
	<b>${nombreCompleto}</b>  <!-- Forma de escribir una variable -->
	
	<hr/>
	
	<%=request.getAttribute("nombreCompleto") %> <!-- Forma de escribir una variable -->

<%@ include file="includes/footer.jsp" %>