
<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>


	<main role="main" class="container">
			
	<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Codigo</th>
      <th scope="col">Precio</th>
      <th scope="col">Descripcion</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>${producto.nombre}</td>
      <td>${producto.codigo}</td>
      <td>${producto.precio}</td>
      <td>${producto.descripcion}</td>
    </tr>
  </tbody>
</table>	
		
		
		
		
		
	</main>


<%@include file="includes/footer.jsp" %>

<!-- El toString del resultado.jsp hacer un card:
			 imagen,al lado del titulo poner simbolo del dolar.
			 si esta en oferta PONER algo 	que represente que está en oferta.
			 
			 
			 en forma dinamica por CSS:
			 en el label  class "required" poner asterisco con el seudoselector befor. -->

