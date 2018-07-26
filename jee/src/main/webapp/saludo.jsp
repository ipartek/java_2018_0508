<!doctype html>

<%@include file="includes/navbar.jsp"%>
<%@include file="includes/header.jsp"%>
		<h1>Saludo</h1>

		<%
			//recibir Atributo en una JSP
			String nombre = (String)request.getAttribute("nombreCompleto");
			out.println(nombre);			
		%>		
		
		
		<hr>
		Expression Language
		<b>${nombreCompleto}</b>
		
		<hr>
		
		<%=request.getAttribute("nombreCompleto")%>
		
<p class="text-danger">${msg}</p>
<%@include file="includes/footer.jsp"%>