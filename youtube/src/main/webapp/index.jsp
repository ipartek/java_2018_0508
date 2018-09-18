<% 

	/*
	Redireccionamiento a inicio.
	*/
	
	response.sendRedirect(request.getContextPath() + "/inicio");

	/*
		Tambien se puede utilizar el fichero "web.xml", para especificar la URL de inicio
	*/
%>