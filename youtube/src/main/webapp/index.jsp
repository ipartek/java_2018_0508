<%
	/*Redirecciones al VideoYoutubeController para poder cargar la vista necesaria home.jsp*/
	response.sendRedirect(request.getContextPath()+"/inicio");

/*
	Tambien podemos usar el fichero "web.xml" para decir cual es la pagina inicial
*/
%>