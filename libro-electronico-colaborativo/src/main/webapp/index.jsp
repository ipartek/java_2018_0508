<%

	/**
	    Redireccionamos al HomeController para poder cargar la informacion
	    necesaria en la Vista home.jsp
	*/
	
	response.sendRedirect(request.getContextPath() + "/inicio");
	
%>