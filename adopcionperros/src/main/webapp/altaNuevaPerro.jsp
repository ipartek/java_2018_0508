<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>


<div class="contenedor">
<main role="main" class="container">

<p class="text-danger">${param.msg} ${requestScope.msg}</p>

<c:if test="${not empty sessionScope.usuario }">
	
		<h1>
			<i class="fas fa-archive"></i> Alta de Perro
		</h1>
		<small>Los campos con * son obligatorios</small>

		<form action="alta" method="post" class="form-alta-producto">

			<div class="form-row">

				<div class="form-group col-sm-10">
					<label for="nom" class="required">Nombre:</label> 
					<input type="text" class="form-control" id="nom" name="nombre" required autofocus  />
				</div>

				<div class="form-group col-sm-2">
					<label for="edad" class="required">Edad:</label> 
					<input
						type="number" class="form-control" id="edad" name="edad"
						required min="0" step="1"/>
				</div>

			</div>
			<!-- /.form-row -->

			<div class="form-row">

				<div class="form-group col">
					<label for="raza" class="required">Raza:</label> 
					<input type="text" class="form-control" id="raza" name="raza">
				</div>

				<div class="form-group col-sm-3">
					<label for="peso">Peso:</label> <input
						type="number" class="form-control" id="peso"
						name="peso" step="0.1" />
				</div>
				
				 <div class="form-group">
                        <label for="imagen" class="required">Imagen(URL):</label>
                        <input type="text" class="form-control" id="imagen" name="imagen" required placeholder="http://ejemplo-de-imagen.com" />
                    </div>
				

			</div>
			<!-- /.form-row -->

			<div class="form-group col-sm-3">
				<label for="desc">Apadrinado:</label>
				<input type="checkbox" name="apadrinado">
			</div>

			<div class="form-group col">
				<label for="numIdentificacion" class="required">Numero identidicador:</label> 
				<input type="text" class="form-control" id="numIdentificacion" name="numIdentificacion" required placeholder="DD-DDDD-AAAA" />
			</div>
			
				<div class="form-group col">
					<label for="longitud" class="required">Longitud:</label> 
					<input type="text" class="form-control" style="width: 15%" id="longitud" name="longitud">
				</div>
				<div class="form-group col">
					<label for="latitud" class="required">Latitud:</label> 
					<input type="text" class="form-control" style="width: 15%" id="latitud" name="latitud">
				</div>
			

			<button type="submit" class="btn btn-outline-primary btn-block">Dar de alta perro</button>

		</form>
		
		   </main>
		
	</div>
	</c:if>

</div>
<!-- /.contenido -->


<%@ include file="includes/footer.jsp"%>