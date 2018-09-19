<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
	
		<%
		Usuario u = (Usuario)session.getAttribute("usuario");
		if(u==null){
			%>
			<p style="color:red">Usuario nulo, se ha saltado el login!!!</p>
			<%
			
		}else{
			%>
			<p style="color:black">Usuario: <%=u.getNombre() %></p>
			<%
		}
			%>
		
		<p>ESTAMOS EN EL BACKOFFICE</p>
		<p>solo usuarios registrados pueden acceder aqui</p>
		<img alt="" src="https://abelvalverde.files.wordpress.com/2015/04/unknown-11.jpeg">
		
		<h2>LISTADO DE USUARIOS CONECTADOS</h2>
		<%
	HashMap<String, Usuario> usuariosConectados = (HashMap<String, Usuario>)application.getAttribute("uConectados");
		for(HashMap.Entry<String,Usuario> uConectado:usuariosConectados.entrySet()){
			
			
		
		%>
			<li><%=uConectado.getValue().getNombre()%></li>
		
		<%
		
	}
%>
	</body>
</html>