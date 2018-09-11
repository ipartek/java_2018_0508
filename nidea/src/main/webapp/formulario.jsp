<%@page import="com.ipartek.formacion.nidea.pojo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
	
		<h1>Formulario de Alta de Producto</h1>
		<p id="obligatorios-txt">Los campos con * son obligatorios</p>
		
		<form action="formulario" method="post" novalidate>

			<div class="form-row">
			
				<div class="col">
	
					<div class="form-group">
						<label for="nom" class="required">Nombre:</label>
						<input type="text" class="form-control" id="nom" name="nombre" required autofocus tabindex="1" placeholder="Nombre del producto" />
					</div>
				
				</div>
				
				<div class="col">
				
					<label for="cat">Seleccione una categoría:</label>
					
					<%
						//Recuperar atributo 'categorias' enviado desde el controlador
						ArrayList<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
					
					%>
				
					<select id="cat" class="custom-select" name="categoria">
					
						<%for(Categoria c : categorias){ %>
							<option value="<%=c.getId() %>"><%=c.getCodigo() + " - " + c.getNombre() %></option>
						<%} %>
						
					</select>
				
				</div>
			
			</div>
			
			
			<div class="form-row">
			
				<div class="form-group col">
					<label for="cod" class="required">Código:</label>
					<input type="text" class="form-control" id="cod" name="codigo" required tabindex="3" placeholder="Código del producto" />
				</div>
					
				<div class="form-group col">
					<label for="precio" class="required">Precio:</label>
					<input type="number" class="form-control" id="precio" name="precio" step="0.1" required tabindex="4" placeholder="Precio del producto" />
				</div>
					
				<div class="form-group form-check col text-center mt-4">
					<input type="checkbox" class="form-check-input" id="oferta" name="oferta" tabindex="2">
					<label class="form-check-label" for="oferta">Oferta</label>
				</div>
				
			</div> <!-- /.form-row -->
			
			<div class="form-group">
				<label for="desc" class="required">Descripción:</label>
				<textarea id="desc" class="form-control" name="descripcion" required placeholder="Descripción del producto" rows="3" tabindex="5" /></textarea>
			</div>
			
			<!--  
			<div class="form-group">
				<label for="img">Imagen(URL):</label>
				<input type="text" class="form-control" id="img" name="imagen" tabindex="6" placeholder="Imagen del producto" />
			</div>
			-->
			<button type="submit" class="btn btn-outline-primary btn-block" tabindex="7">Dar de alta</button>
				
		</form>
	
	</main>

<%@include file="includes/footer.jsp" %>