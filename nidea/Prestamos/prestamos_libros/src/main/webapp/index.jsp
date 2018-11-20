<%

	/*
	    Redireccionamos al HomeController para poder cargar la informacion
	    necesaria en la Vista home.jsp
	*/
	
	response.sendRedirect(request.getContextPath() + "/inicio");

	/*
	
		asdfghjkTambien podemos usar el fichero "web.xml" para decir cual es la URL Inicial	ertyuioitrewqertghj
	*/

	
%>