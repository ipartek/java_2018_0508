<%@page import="com.ipartek.formacion.nidea.pojo.Alert"%>
<%
	// Muestra Alerta cuando enviamos parametro "alert" por la Request
	Alert alert = (Alert)request.getAttribute("alert");
	if( alert != null ){
	
%>
	<div class="container">
		<div class="alert <%=alert.getTipo()%> alert-dismissible fade show" role="alert">
		  <p><%=alert.getTexto() %></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</div>
	
<%
	}
%>