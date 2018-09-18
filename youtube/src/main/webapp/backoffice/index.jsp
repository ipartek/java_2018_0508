<%@page import="com.ipartek.formacion.pojo.Usuario"%>

<h1>ESTAMOS EN EL BACKOFFICE </h1>
*Solo pueden entrar usuarios logeados <br>
 <% 
	Usuario u = (Usuario)session.getAttribute("usuario");
	if ( u == null ){		
		out.print("<p style=\"color:red\">Usuario nulo, se ha saltado el login!!!</p>");		
	}else{		
		out.print("Usuario: " + u.getNombre() + "<br>");
	}
%>