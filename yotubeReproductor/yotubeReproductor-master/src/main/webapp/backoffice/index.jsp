<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.formacion.youtube.Usuario"%>


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title></title>

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	
    <!-- Bootstrap core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css" rel="stylesheet">

	<link rel="stylesheet" href="css/styles.css" >
	
  </head>

  <body>
  
<img src="https://www.hopperlink.com/wp-content/uploads/2017/05/backoffice_02.jpg" 	alt="imagen backoffice" width="50%" height="50%">

<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	if (u == null) {
		out.print("<p style=\"color:red\">Usuario nulo, se ha saltado el login!!!</p>");
	} else {
		out.print("Usuario: " + u.getNombre() + "<br>");
	}
%>
*Solo pueden entrar usuarios logeados
<br>
<h1>ESTAMOS EN EL BACKOFFICE</h1>
<h2>Listado de Usuario conectados</h2>

<%

	HashMap<String, Usuario> usuariosConectados = (HashMap<String, Usuario>) application.getAttribute("uConectados");
	for( HashMap.Entry<String,Usuario> uConectado : usuariosConectados.entrySet()){
		
    %>
    <li><%=uConectado.getValue().getNombre()%></li>
    <%
   
 
}
%>
</body>
  </html>