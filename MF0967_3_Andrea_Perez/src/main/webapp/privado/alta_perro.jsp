<%@page import="com.ipartek.formacion.perrera.model.Perro"%>
<%@ include file="../includes/header.jsp"%>

<%@ include file="../includes/navbar.jsp"%>

<main role="main" class="container"> 
	
<div class="contenedor col-8">
	<%@include file="/includes/alert.jsp"%>
	<div class="row justify-content-center">
		<h1 class="col col-md-12 centrar-text">Alta Perro</h1>
	</div>

	<div class="row justify-content-center">
		<small id="login-small" class="col col-md-9">Los campos con *
			son obligatorios</small>
	</div>
	<form id="login-form" action="registro" method="post">

		<div class="form-row justify-content-center">

			<div class="col col-md-9">

				<div class="apdrinar">
					
					<label for="apadrinado" >Apadrinado</label>
					 <input	type="checkbox" class="form-control" id="apadrinado" name="apadrinado" placeholder="edad del animal" value="${perro.apadrinado }" /> 
				</div>
				<div class="datos_perruno col-6">	
					<label for="nombre"	class="required">Nombre</label> <input type="text"
						class="form-control" id="nombre" name="nombre" autofocus
						required placeholder="Nombre del animal" value="${p.nombre }" />
				
				
				<div class="form-group">
					<label for="edad" class="required">edad</label> <input
						type="number" class="form-control" id="edadUsuario" name="edad"
						required placeholder="Edad del animal" value="${p.edad}" />
				</div>
				
				<div class="form-group">
					<label for="raza" class="required">Raza</label> <input type="text"
						class="form-control" id="raza" name="raza" required
						placeholder="Raza del animal" value="${p.raza}" />
				</div>
				<div class="form-group">
					<label for="peso" class="required">Peso</label> <input
						type="number" class="form-control" id="peso" name="peso" required
						placeholder="Kg del animal" value="${p.peso}" />
				</div>
				</div>
					<div class="chip">
						<label for="chip" class="required">Nº chip</label> 
						<input type="text" class="form-control " id="numero1" name="numero1" required maxlength="2" 
						placeholder="formato de 2 numeros" value="${p.chip.numero }" />
						
						<input type="text" class="form-control" id=numero2 name="numero2" required
						placeholder="Formato de 4 numeros" value="3333" maxlength="4"/>
						
					<input
						type="text" class="form-control " id="anyo" name="anyo" required
						placeholder="anyo actual" value="2018" maxlength="${p.chip.anyo }"/>
					
					<input
						type="number" class="form-control" id="latitud" name="latitud" required
						placeholder="latitud" value="1111" maxlength="${p.chip.latitud}"/>	
					<input
						type="number" class="form-control" id="chlongitud" name="longitud" required
						placeholder="longitud" value="2222" maxlength="${p.chip.longitud}"/>	
						
					</div>					
					
						<input type="file" name="imagen"  value="${perro.img }"/>
				</div>
					
				
				


				<button type="submit" class="btn btn-outline-primary btn-block">Aceptar</button>

			</div>

		</div>

	</form>


</div>
<!-- /.contenedor --> </main>
<%@ include file="../includes/footer.jsp"%>