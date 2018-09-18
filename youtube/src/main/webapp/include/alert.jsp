<%@page import="com.ipartek.formacion.youtube.pojo.Alert"%>
<%
      	//Gestion de Alertas para el usuario      	
        Alert alert = (Alert)request.getAttribute("alert");
      	if ( alert == null ){
      		alert = (Alert)session.getAttribute("alert");
      		session.setAttribute("alert", null); // eliminar atributo de session
      	}
      
      	if( alert != null){
      	%>
      		<div class="container">
				<div class="alert <%=alert.getTipo()%> alert-dismissible fade show" role="alert">
					<p><%=alert.getTexto()%></p>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
      <%	
      }      
%>	