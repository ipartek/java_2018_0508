<%@page import="com.ipartek.formacion.nidea.pojo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
	
		<div class="row">
			<div class="col-12 col-md-8 offset-md-2">
				<h1 class="text-primary text-left">Alta Producto</h1>
		
				${alerta}
				
				<form action="formulario" method="post" class="">
				
					<p class="font-italic">Los campos con * son obligatorios</p>
					
					<div class="form-row form-group">
						<div class="col">
							<label for="nombre"><i class="fas fa-asterisk fa-sm text-danger"></i>Nombre:</label>
							<input class="form-control" type="text" name="nombre" required autofocus placeholder="Nombre del producto" tabindex="1">
						</div>
						<div class="col">
							<label for="categoria">Seleccione la categoria:</label>
							<select class="custom-select" name="categoria">
								<c:forEach var="categoria" items="${Categorias}">
									<option value="${categoria.id}">${categoria.codigo} - ${categoria.nombre}</option>
						       	</c:forEach>
						     </select>
						</div>
					</div>
					<!-- / .form-row -->
					
					<div class="form-row form-group">
						
						<div class="col">
								<label for="codigo"><i class="fas fa-asterisk fa-sm text-danger"></i>Codigo:</label>
								<input class="form-control" type="text" name="codigo" required placeholder="Codigo del producto" tabindex="3">
						</div>
						
						<div class="col">
								<label for="codigo"><i class="fas fa-asterisk fa-sm text-danger"></i>Precio:</label>
								<input class="form-control" type="number" name="precio" required step="0.1" tabindex="4">
						</div>
						
						<div class="col text-center">
								<label for="oferta">Oferta:</label>
								<input class="form-control" type="checkbox" name="oferta" tabindex="2">
						</div>
					</div>
					<!-- /.form-row -->
					
					<div class="form-group">
						<textarea class="form-control" name="descripcion" rows="5" placeholder="Breve descripcion" resizable="false" tabindex="6"></textarea>
					</div>
					 
					<input type="submit" value="Dar Alta" class="btn btn-block btn-outline-success">
				
				</form>
			</div>
		</div>
		<!-- /.row -->
		
	</main>

<%@include file="includes/footer.jsp" %>