<%@page import="org.apache.taglibs.standard.tag.el.core.ForEachTag"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>


	<main role="main" class="container">
		<h1>Formulario Alta Producto</h1>
		<p>Los campos con * son obligatorios</p>
		
		<form action="formulario" method="post">
		
			<div class="form-row">
				<div class="col">
				 	<div class="form-group">
				 		<label for="nombre" class="required obligatorio">Nombre:</label>
						<input type="text" name="nombre" autofocus class="form-control" required placeholder="Nombre" tabindex="1">				
					</div>	
				</div><!-- col -->
				
				<div class="col">
				<label for="categoria">Selecciona Categoria:</label>
				<%
					ArrayList <Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("categorias");
				
				%>
					<select name="categoria" class="custom-select">
					<% for (Categoria c: categorias){%>
						
					<option value="<%=c.getId()%>"><%=c.getNombre() %></option>
						
					<%} %>
						
					  
					</select>
				</div><!-- col -->
			
			</div>
			<div class="form-row">
			
				<div class="col">
					
					<div class="form-group">
						<label for="codigo" class="obligatorio">Codigo:</label>			
						<input type="text" name="codigo" class="form-control" required placeholder="Codigo del Producto" tabindex="3">
					</div>
				</div>	
				
				<div class="col">	
					<div class="form-group">
						<label for="precio" class="obligatorio">Precio:</label>	
						<input type="number" name="precio" class="form-control" required step="0.1" placeholder="precio" tabindex="4">
					</div>
				</div>	
					
				<div class="col">	
					<div class="form-group">
						<label for="oferta" class="d-block text-center" >Oferta</label>						
						<input type="checkbox" name="oferta" class="form-control" tabindex="2">						
					</div>
				</div>	 
					
			</div>		
			<!-- .form-row -->		
			
			<div class="form-group">
				<label for="descripcion">Descripcion:</label>
				<textarea name="descripcion" rows="5" class="form-control" tabindex="5"></textarea>
			</div>
			
			<div class="form-group">
				<label for="imagen">Imagen</label>
				<input type="file" class="file" name="archivo" data-preview-file-type="any">
			</div>
		
			<div class="form-group">
				<input type="submit" value="Nueva Alta" class="btn btn-primary btn-block">
			</div>	
		</form>
		
		
	</main>


<%@include file="includes/footer.jsp" %>