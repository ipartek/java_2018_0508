	<%@ include file = "includes/header.jsp" %>

	<%@ include file = "includes/navbar.jsp" %>

	<h1>Saludo</h1>
	
	<%
		String nombre = (request.getAttribute("nombre")!=null)?(String) request.getAttribute("nombre"):" ";
		String ap1 = (request.getAttribute("ap1")!=null)?(String) request.getAttribute("ap1"):" ";
		String ap2 = (request.getAttribute("ap2")!=null)?(String) request.getAttribute("ap2"):" ";
		
		out.print("<p>"+nombre+" "+ap1+" "+ap2+"</p>");
	%>
	
	<%@ include file = "includes/footer.jsp" %>