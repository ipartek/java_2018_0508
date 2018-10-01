<%
/*
redireccionamos al HomeController para poder cargar la informacion necesario en la Visa home.jsp
*/
response.sendRedirect(request.getContextPath() + "/inicio");
/*
<<tambien podemos usar el fichero web.xml para decir cual es la URL Inicial
*/


%>