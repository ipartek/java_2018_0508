<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
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
<h2>Usuarios Conectados</h2>
<ol>
	<%
		HashMap<String, Usuario> usuariosConectados = (HashMap<String, Usuario>)application.getAttribute("uConectados");
		for(HashMap.Entry<String, Usuario> uConectado : usuariosConectados.entrySet()){
		    %>
		    	<li><%=uConectado.getValue().getNombre()%></li>
		    <%
		}
	%>
</ol>