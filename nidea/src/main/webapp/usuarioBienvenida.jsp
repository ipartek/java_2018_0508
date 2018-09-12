<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<h1>Mensaje de registro de usuarios</h1>
<%
	String msg = (String) request.getAttribute("msg");
	boolean error = (boolean) request.getAttribute("error");
	String nombreUsuario = (String) request.getAttribute("nombre");
	if (error == false){
		
	
%>
	<div class="alert alert-success" role="alert">
	  <h2>Mensaje satisfactorio si el registro a sido correcto</h2>
	   <p>${msg}</p>
	   <p>Gracias por haberse registrado {nombreUsuario}</p>
	</div>
<%
	}else{
		
	
%>
<div class="alert alert-danger" role="alert">
  <h2>Mensaje Error si el registro a sido in	correcto</h2>
  <p>${msg}</p>
  <p>Intentelo de nuevo gracias</p>
</div>	
<%
	}
%>

<%@include file="includes/footer.jsp" %>