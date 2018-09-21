<%

	/*
	    Redireccionamos al HomeController para poder cargar la informacion
	    necesaria en la Vista home.jsp
	*/
	
	response.sendRedirect(request.getContextPath() + "/inicio");

	/*
	
		Tambien podemos usar el fichero "web.xml" para decir cual es la URL Inicial	
	*/

	
%>