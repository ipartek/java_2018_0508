<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<%@include file="../includes/alert.jsp"%>

	<main role="main" class="container">

		<h1>Nuevo Perro</h1>
		
		<form action="backoffice/alta" method="post">
		
			<div class="form-row">
			
				<div class="form-group col">
					<label for="nombre">Nombre:</label>
					<input type="text" id="nombre" name="nombre" class="form-control" autofocus required placeholder="Máximo 50 caracteres" />
				</div>
			
				<div class="form-group col">
					<label for="edad">Edad(años):</label>
					<input type="number" id="edad" name="edad" class="form-control" min="1" required placeholder="1" />
				</div>
			
				<div class="form-group col">
					<label for="raza">Raza:</label>
					<input type="text" id="raza" name="raza" class="form-control" required placeholder="Ej: Mastín beagle, pastor...etc." />
				</div>
			
			</div>
		
			<div class="form-row">
			
				<div class="form-group col">
					<label for="id">ID:</label>
					<input type="text" id="id" name="id" class="form-control" required pattern="[0-9]{2}-[0-9]{4}-[0-9]{4}" />
				</div>
			
				<div class="form-group col">
					<label for="peso">Peso(Kg):</label>
					<input type="number" id="peso" name="peso" class="form-control" min="1" required placeholder="5Kg" step="0.1" />
				</div>
			
				<div class="form-group col">
					<label for="apadrinado">Apadrinado:</label>
					<select class="form-control" name="apadrinado">
						<option value="1">No</option>
						<option value="0">Sí</option>
					</select>
				</div>
				
			</div>
		
			<div class="form-row">
			
				<div class="form-group col">
					<label for="lat">Latitud:</label>
					<input type="number" id="lat" name="lat" class="form-control" required step=0.01 />
				</div>
			
				<div class="form-group col">
					<label for="long">Longitud:</label>
					<input type="number" id="long" name="long" class="form-control" required step=0.01 />
				</div>
			
			</div>
			
			<div class="form-row">
			
				<div class="form-group col">
					<label for="img">Imagen(URL):</label>
					<input type="text" id="img" name="img" class="form-control" required placeholder="https://imagen_de_ejemplo.png" />
				</div>
			
			</div>
			
			<input type="submit" class="btn btn-success btn-block" value="Dar de alta" />
		
		</form>

				
	</main>

<%@include file="../includes/footer.jsp"%>