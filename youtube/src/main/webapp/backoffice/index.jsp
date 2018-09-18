<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>

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

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQufLDB7IpkmblOHc1JCmAQ68EWpaOm4Pn0COA5oanwu55yNiTAtQ" alt="imagen backoffice">