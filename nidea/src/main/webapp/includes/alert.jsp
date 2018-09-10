
<%@page import="com.ipartek.formacion.nidea.pojo.Alerts"%>
<%
	//PAra poder mostrar una alerta es necesario enviar un parametro llamado alert por la request
	Alerts alert = (Alerts) request.getAttribute("alert");
	if(alert != null){
		
	
%>

<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  <p><%=alert%></p>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
</div>

<%
	//cerramos aqui el if para englobar el div dentro de la condicion 
	}
%>
