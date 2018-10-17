<%@page import="com.casa.practicas.pojo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


    <!-- Page Content -->

    <h1>Formulario perros</h1>
	    <div class="formularioAlta row" >
	    
	    <div class="col form-alta-contenido" >
			<form action="registroPerros" method="post">
				  <div class="form-row">
				  <div class="form-group col-md-6">
				      <label for="nombrePerro">Nombre</label>
				      <input type="text" class="form-control" name="nombrePerro" autofocus required="required" placeholder="Nombre del perro" pattern="[A-Za-z]{5,45}">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="razaPerro">Raza</label>
				      <input type="text" class="form-control" name="razaPerro" required="required" placeholder="La raza del perro" ">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="edadPerro">Edad</label>
				      <input type="number" class="form-control" required="required" name="edadPerro" placeholder="Edad del perro">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="pesoPerro">Peso</label>
				      <input type="number" class="form-control" required="required" name="pesoPerro" placeholder="Peso del perro">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="chipPerro">Identificacion Chip</label>
				      <input type="text" class="form-control" required="required" name="chipPerro"
				       pattern="\d{[A-Za-z0-9],2}-\d{[A-Za-z0-9],4}-\d{[A-Za-z0-9],4}"

				      required  placeholder="formato DD-DDDD-AAAA">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="imagenPerro">Imagen del perro</label>
				      <input type="text" class="form-control" required="required" name="imagenPerro"  placeholder="direccion de la foto">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="latitudChip">Latitud Chip</label>
				      <input type="text" class="form-control" required="required" name="latitudChip" placeholder="Latitud ">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="longitudChip">Longitud Chip</label>
				      <input type="text" class="form-control" required="required" name="longitudChip" placeholder="Longitud">
				    </div>
				    <div class="form-group col-md-6">
				      <label for="apadrinadoPerro">Apadrinado</label>
				      <input type="checkbox"  name="apadrinadoPerro"">
				    </div>

				  <div class="center-button">
				  	<button  type="submit" class="btn btn-success ">Nueva Alta</button>
				  </div>
			</form>
			</div>
	    </div>
	    </div>
	    </div>



