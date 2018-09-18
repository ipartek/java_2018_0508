ESTAMOS EN EL BACKOFFICE
*SOLO PUEDEN ENTRAR USUARIOS LOGUEADOS
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%

	Usuario u = (Usuario)session.getAttribute("usuario");
	if(u==null){
		%>
		Usuario Nulo, se ha saltado el login, nos quiere hackear!!!!1
	<%
	}else{
		%>
		Usuario: <%=u.getNombre() %>
	<%
	}

%>