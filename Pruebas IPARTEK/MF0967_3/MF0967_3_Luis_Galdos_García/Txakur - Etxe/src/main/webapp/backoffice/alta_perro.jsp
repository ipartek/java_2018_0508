<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file = "../include/header.jsp" %>

<%@ include file = "../include/navbar.jsp" %>

<main class="container mt-5" role="main">

	<c:if test="alert != null">
		<!-- Gestión de alertas -->
		<div class="row align-center">
	        <div class="col color-primary">
				<%@include file="/include/alert.jsp" %>
			</div>
		</div>
	</c:if>
	
	<!--  FORMULARIO DE ALTA DE PERROS -->
	<section>
		
		<form action="alta" method="post">
			<fieldset class="scheduler-border">
		    <legend class="scheduler-border">Datos del Perro</legend>
		    
		    <div class="form-group">
			    <label for="nombre">Nombre</label>
			    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="De 5 a 120 caracteres." required pattern=".{5, 120}">
		 	</div>
		  	<div class="form-group">
			    <label for="raza">Raza</label>
			    <input type="text" class="form-control" id="raza" name="raza" placeholder="De 5 a 120 caracteres." required pattern=".{5, 120}">
		 	</div>
		 	
		 	<div class="form-group">
			    <label for="raza">Imagen</label>
			    <input type="text" class="form-control" id="imagen" name="imagen" placeholder="Mínimo 5 caracteres." pattern=".{5,}">
		 	</div>
		  	<div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="edad">Edad</label>
			      <input type="number" class="form-control" id="edad" name="edad" placeholder="Ingrese un número." required>
			    </div>
			    <div class="form-group col-md-6">
			      <label for="peso">Peso</label>
			      <input type="number" class="form-control" id="peso" name="peso" placeholder="Ingrese un número. (Admite decimales)." required>
			    </div>
		  	</div> <!-- /.form-row -->
		  	
		  
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="adoptado" name="adoptado">
		      <label class="form-check-label" for="adoptado">Adoptado </label>
		    </div>
		  </div>
		</fieldset>
		<fieldset class="scheduler-border">
		    <legend class="scheduler-border">Datos del Chip</legend>
		    <div class="form-group">
			    <label for="numChip">Número</label>
			    <input type="text" class="form-control" id="numChip" name="numChip" placeholder="Formato: NNNN-NN-AAAA. Ejemplo: 1234-56-2018" required>
		  	</div>
		  	<div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="latitud">Latitud</label>
		      <input type="number" class="form-control" id="latitud" name="latitud" placeholder="Ingrese un número. (Admite decimales)." required>
		    </div>
		    <div class="form-group col-md-6">
		      <label for="longitud">Longitud</label>
		      <input type="number" class="form-control" id="longitud" name="longitud" placeholder="Ingrese un número. (Admite decimales)." required>
		    </div>
		  </div>
		</fieldset>
	
			<button type="submit" class="btn btn-block btn-danger">Dar de alta</button>
		</form>
	</section>
	

</main>

<!-- Pie de Página -->
<div class="row align-center fixed-bottom">
	<div class="col-md-12 color-primary">
		<%@ include file="/include/footer.jsp" %>
	</div>
</div>
