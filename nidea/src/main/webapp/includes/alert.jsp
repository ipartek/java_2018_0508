<%
	// Muestra Alerta cuando enviamos parametro 'alert' por la Request
	String alert = (String)request.getAttribute("alert");
	if ( alert != null ){
%>
	<div class="container">
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
		  <p><%=alert%></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</div>
<%
	} //cierre if
%>	