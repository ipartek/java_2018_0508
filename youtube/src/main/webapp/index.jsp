<%

	/*
		Redireccionamos al HomeController para poder cargar la información
		necesaria en la vista home.jsp.
	*/
	
	response.sendRedirect(request.getContextPath() + "/inicio");


	/*
		También podemos usar el fichero 'web.xml' para decir cual es la URL inicial	.
	*/

%>