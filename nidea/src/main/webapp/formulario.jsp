<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

	<main role="main" class="container">
	
		<div class="row">
			<div class="col-12 col-md-6 offset-md-2">
				<h1 class="text-primary text-left">Alta Producto</h1>
		
				${alerta}
				
				<form action="formulario" method="post" class="">
				
					<p class="font-italic">Los campos con * son obligatorios</p>
					
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">*</span>
						</div>
						<input class="form-control" type="text" name="nombre" required autofocus placeholder="Nombre del producto" tabindex="1">
					</div>
					<div class="form-row">
						
						<div class="col">
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">*</span>
								</div>
								<input class="form-control" type="text" name="codigo" required placeholder="Codigo del producto" tabindex="3">
							</div>
						</div>
						
						<div class="col">
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">*</span>
								</div>
								<input class="form-control" type="number" name="precio" required step="0.1" tabindex="4">
							</div>
						</div>
						
						<div class="col">
							<div class="form-group">
								<label for="oferta">Oferta</label>
								<input type="checkbox" name="oferta" tabindex="2">
							</div>
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