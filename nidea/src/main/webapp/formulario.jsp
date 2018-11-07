<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Categoria"%>
<%@page import="com.ipartek.formacion.nidea.model.ProductosDao"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<!--  -->
<%@page import="com.ipartek.formacion.nidea.pojo.*"%>

	<main role="main" class="container">
		<h1>Usuario nuevo</h1>
		<form action="formulario" method="post">	
			<p class="font-italic text-secondary">Los campos con * son obligatorios</p>
			<div class="form-row">
				<div class="col">
					
					<label for="nombre" class="obligatorio">Nombre usuario</label>
					<input type="text" class="form-control" autofocus name="nombre" required="required" placeholder="Nombre del nuevo usuario" tabindex="1" pattern="[a-zA-Z\s]{5,}"></p>
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					
					<label for="nombre" class="obligatorio">DNI</label>
					<input type="text" class="form-control" autofocus name="nombre" required="required" placeholder="Dni del usuario" tabindex="1" pattern="[a-zA-Z\s]{5,}"></p>
				</div>
			</div>
			<%-- <%
				ArrayList<Categoria> cats = (ArrayList<Categoria>)request.getAttribute("categorias");
			
			
			%>
				<div class="col">
				<!-- <p class="font-italic text-secondary">Los campos con * son obligatorios</p> -->
					<label for="categoria">Categoria</label>
					<select name="categoria" class="custom-select">
						
						  <option selected>Seleciona la categoria</option>
						  <%
						  	for(Categoria c : cats){
						  		
						  	
						  %>
						  <option value="<%=c.getCodigo()%>"><%=c.getNombre()%></option>
						  <%
						  	}
						  %>
					</select>
				</div>
			</div>
			 --%>
			
			<!-- <div class="form-row">
				
				<div class="col">
					
						<label for="codigo">Prestado a</label>
						<select name="categoria" class="custom-select">
						
						  <option selected>Selecione un usuario</option>
						  
						  <option value=""></option>
						 
					</select>
				</div>
			</div> -->
<!-- 			<div class="form-row">
				<div class="col">
					<label>Fecha del prestamo</label>
					<input type="date">
				</div>
			</div> -->
			<!-- <div class="form-row">
				<div class="col">
					<label>Fecha del prestamo</label>
					<input type="date">
				</div>
			</div> -->
			<!-- <div class="form-row">
				<div class="col">
					<label>Fecha del prestamo</label>
					<input type="date">
				</div>
			</div> -->
				
				<!-- <div class="col">
					
						<label for="codigo">Codigo ISBN</label>
						<input type="text" class="form-control" name="codigo" required placeholder="Código del Producto" tabindex="3">
				</div> -->
				<!-- <div class="col">
				<p class="font-italic text-secondary">Los campos con * son obligatorios</p>
					<label for="categoria">Prestado a</label>
					<select name="categoria" class="custom-select">
						
						  <option selected>Seleciona un usuario</option>
						  <
						  <option value=""></option>
						  
					</select>
				</div> -->
				<!-- <div class="form-group">
					
						<label for="precio">Precio</label>
						<input type="number" class="form-control" name="precio" required placeholder="Precio del Producto" tabindex="4">
						<label for="oferta">Oferta: </label>
						<input type="checkbox" class="form-control" name="oferta" tabindex="2">
					
				</div> -->
				<!-- <div class="form-group">
					
						<label for="oferta">Oferta: </label>
						<input type="checkbox" class="form-control" name="oferta" tabindex="2">
					
				</div> -->
				<!-- <div class="form-group">
					<p><label for="descripcion">Subir Imagen: </label></p>
					<input type=file name="imagen" class="form-control-file" id="customFile"   ></input>
				
				</div> -->
				<!-- <div class="form-group">
					<p><label for="descripcion">Descripcion: </label></p>
					<textarea type=text name="descripcion" required placeholder="Descripcion" tabindex="6" rows="10" cols="82"></textarea>
				
				</div> -->
				<!-- <div class="form-group">
				<label>Desde el dia :</label>
	        	<input id="date" type="date">
	        	<label>Hasta el dia :</label>
	        	<input id="date2" type="date">
	        </div>	 -->
			
	        
	        <input class="btn secondary btn-lg btn-block" type="submit" value="Enviar" id="enviar"/>
			</div>	
			
			
					
			
		</form>
		
		
		
		
		
		
		
	
		
	</main>


<%@include file="includes/footer.jsp" %>