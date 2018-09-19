<%@page import="java.util.Iterator"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@page import="java.util.HashMap"%>
<%
	/*
		Redireccionamos al Homecontroller para poder cargar la informacion necesaria en la vista home.jsp
	
	*/
	response.sendRedirect(request.getContextPath() + "/inicio");

	/*
	
	Tambien podemos usar el fichero web.xml para decir cual es la url inicial
	
	*/
%>
