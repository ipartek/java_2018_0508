<%@page import="com.ipartek.formacion.nidea.pojo.Alert"%>
<%
	// Muestra Alerta cuando enviamos parametro 'alert' por la Request
	Alert alerta = (Alert) request.getAttribute("alerta");
	if ( alerta != null ){
%>
	<div class="container">
		<div class="alert alert-"<%=alerta.getPriority()%> alert-dismissible fade show" role="alert">
		  <p><%=alerta.getMsg()%></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</div>
<%
	} //cierre if
%>	
