<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%
	boolean accessSignal = (boolean) request.getAttribute("accessSignal");
	String estilo = (String) request.getAttribute("estilos");
	if ("alert alert-success".equals(estilo) ){
		
	
%>
	<h1>Tras intentar hacer login</h1>
	<div class="alert alert-success" role="alert">
	  <h2>Su autentificacion a sido satiscactoria. Gracias por visitarnos</h2>
	</div>
<%
	}else{
		
	
%>
	<div class="alert alert-danger" role="alert">
	  <h2>Lo sentimos pero no hemos encontrado coincidencias con las datos facilitados</h2>
	  <h3>Intentelo de nuevo <a href="registroUsuarios.jsp">Registro</a></h3>
	</div>
<% 
	}
%>
	


<%@include file="includes/footer.jsp" %>