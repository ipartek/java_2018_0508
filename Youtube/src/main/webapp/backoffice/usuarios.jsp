<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
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

<h2>Listado Usuarios Conectados: </h2>
<ol>
<%
	
   	Map<String, Usuario> usuariosConectados = (HashMap<String, Usuario>) application.getAttribute("uConectados");

	for (Map.Entry<String, Usuario> entry : usuariosConectados.entrySet()) {
		
		%>
    	<li><%=entry.getValue().getNombre()%></li>
    	<%
	}
%>
</ol>

