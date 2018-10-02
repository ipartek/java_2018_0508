

<%@page import="com.ipartek.formacion.youtube.Alert"%>
<%
	Alert alert=(Alert)request.getAttribute("alert");
	if(alert !=null){
%>		
	<div class="container">
		<div class="alert <%=alert.getTipo() %> alert-dismissible fade show" role="alert">
		  <p><%=alert.getTexto() %> <a href="formulario.jsp">click aqui si desea agregar otro producto</a></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		  <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</div>
		
		
<%	} %>


<!-- 
* Nuevo enlace alertas.
* alertas.jsp
* Crear pojo:
	alert-danger
	5 constantes: alert alert-primary
			  alert-secondary
			  alert-success
			 info:dado de alta correctamente,quieres crear nuevo registro.==> si es que si, enlace a crear nuevo formulario.
			 1º Constructor por defecto:
			 tipo: alert-danger 
			 Texto:lo sentimos ha surgido ago inesperado.
			 2º constructor: el tipo y parametro que yo quiera.
			 
			 
-->