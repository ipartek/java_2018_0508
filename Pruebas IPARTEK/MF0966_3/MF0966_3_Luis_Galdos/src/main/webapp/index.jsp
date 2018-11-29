<%@page import="com.ipartek.formacion.personas.controller.HomeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<!-- HEADER STARTS HERE -->
	<%@ include file="include/header.jsp"%>

<div class="container">

	<!-- NAVBAR STARTS HERE -->
	<%@ include file="include/navbar.jsp"%>

	<div class="row">
		<div class="col"><h1>Listado de Personas</h1></div>
	</div>
	
	<%@ include file="include/alert.jsp"%>
	<%@ include file="include/alert-datos.jsp"%>
	
	<div class="row justify-content-center">
		<div class="col">
			<a href="inicio?op=<%= HomeController.OP_CARGAR_DATOS  %>" class="btn btn-danger">Cargar Datos</a>
		</div>
		<div class="col">
			<a href="inicio?id=-1&op=<%= HomeController.OP_IR_FORMULARIO %>" class="btn btn-success mb-3">Crear Nuevo</a>
		</div>
	</div>
	
	 <div class="row">
     		<!--  DATATBLE -->
     		<table id="tablaOrdenable" class="display" style="width:100%">
	        <thead>
	            <tr>
	            	<th>DNI</th>
	                <th>Nombre</th>
	                <th>1º Apellido</th>
	                <th>2º Apellido</th>	
	                <th>E-mail</th>
	                <th>Puesto</th>	
	                <th>Acciones</th>                
	            </tr>
	        </thead> 
	        
	        <tbody id="tableBody">
	        	<c:forEach items="${ personas }" var="p">
		            <tr>
		                <td>${ p.dni }</td>
		                <td>${ p.nombre }</td>
		                <td>${ p.apellido1 }</td>
		                <td>${ p.apellido2 }</td>
		                <td>${ p.email }</td>
		                <td>${ p.rol }</td>		
		                <td><a href="inicio?id=${ p.id }&op=${ HomeController.OP_IR_FORMULARIO }">Editar</a></td>                
		            </tr>
	            </c:forEach>
	        </tbody>
	         
	        <tfoot>
	            <tr>
	               	<th>DNI</th>
	                <th>Nombre</th>
	                <th>1º Apellido</th>
	                <th>2º Apellido</th>	
	                <th>E-mail</th>
	                <th>Puesto</th>	
	                <th>Acciones</th>		
	            </tr>
	        </tfoot>
    	</table> <!-- TABLE#tablaOrdenable -->	

	</div>
</div>

<%@ include file="include/footer.jsp"%>


