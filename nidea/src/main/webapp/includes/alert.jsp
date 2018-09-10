<%@page import="com.ipartek.formacion.nidea.pojo.Alert"%>
<%
	/* Muestra alerta cuando enviamos un parámetro 'alert' por la request. */
	
	Alert a = (Alert)request.getAttribute("alert");

	if(a != null){

%>

	<div class="container">
		<div class="alert <%=a.getTipo() %> alert-dismissible fade show" role="alert">
		
			<p><%=a.getTexto() %></p>
			
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			
		</div>
		
	</div>

<%
	}	//Cierre del if
%>