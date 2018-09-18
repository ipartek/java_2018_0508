<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>


<!DOCTYPE html>
<html lang="en">

  <head>

	<!-- Comenza todas las URLs desde el href indicado -->
	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Youtube Video Play List</title>

  </head>

  <body>
	<h1>ESTAMOS EN EL BACKOFFICE</h1>
	<br/>
	<p>*Solo pueden entrar usuarios logeados</p><br/>
	
	<%
	
		Usuario u = (Usuario)session.getAttribute("usuario");
		if(u == null){
			%>
				<p style="color:red">Usuario nulo, se ha saltado el login!!</p>
			<%
		}else{
			%>
				<p>Usuario: <%=u.getNombre() %></p>
			<%
		}
	
	%>
	
	<img src="http://www.land-of-web.com/wp-content/uploads/2012/04/w394.jpg" alt="imagen-backoffice"/>

  </body>

</html>
