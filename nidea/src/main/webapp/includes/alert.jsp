<%@page import="com.ipartek.formacion.nidea.pojo.Alert"%>
<%
	// Para poder mostrar una alerta es necesario enviar un parametro llamado 'alert' por la request
	Alert alert = (Alert)request.getAttribute("alert");
	if(alert != null){
%>
	<div class="container">
		<div class="alert alert-<%=alert.getTipo() %> alert-dismissible fade show" role="alert">
		  <strong><%=alert.getTexto() %></strong>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</div>
<%
	}
	// cierre if
%>