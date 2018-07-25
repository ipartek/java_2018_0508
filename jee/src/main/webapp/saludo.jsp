<%@ include file="includes/header.jsp" %>		
<%@ include file="includes/navbar.jsp" %>

		<h1>Saludos</h1>

		<%
			//recibir Atributo en una JSP con GET
			String nombreCompleto = (String)request.getAttribute("nombreCompleto");
			out.println(nombreCompleto);
			
		%>	
		
		<hr>
		<!-- Expression Language -->
		<b>${nombreCompleto}</b>
		
		<hr>
		
		<%=request.getAttribute("nombreCompleto") %>	

<%@ include file="includes/footer.jsp" %>