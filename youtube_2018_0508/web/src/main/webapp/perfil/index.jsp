<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>
<div class="container bootstrap snippet min-container">

	<div class="row">
		<div class="col-sm-10">
			<h1>Hola ${sessionScope.usuario.nombre}!!</h1>
		</div>

	</div>
	<div class="row">
		<div class="col-sm-3">
			<!--left col-->

			<ul class="list-group">
				<li class="list-group-item text-muted">Resumen Comentarios</li>
				<li class="list-group-item text-right totales"><span class="pull-left"><strong>Total
							Comentarios</strong></span><span class="badge">${totalComentario}</span></li>
				<li class="list-group-item text-right totales"><span class="pull-left"><strong>Total
							Publicados</strong></span><span class="badge">${cantApro}</span></li>
				<li class="list-group-item text-right totales"><span class="pull-left"><strong>Total
							Pendientes </strong></span><span class="badge"> ${cantNoApro}</span></li>

			</ul>
			<ul class="list-group">
				<li class="list-group-item text-muted">Resumen Videos</li>
				<li class="list-group-item text-right totales"><span class="pull-left"><strong>Total
							Agregados</strong></span><span class="badge">${videos.size()}</span></li>
			</ul>


		</div>
		<!--/col-3-->
		<div class="col-sm-9">

			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a href="#home" data-toggle="tab">Lista
						de tus videos</a></li>
				<li><a href="#messages" data-toggle="tab">Lista de tus
						comentarios</a></li>
				<li><a href="#settings" data-toggle="tab">Editar perfil</a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane active" id="home">
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Label 1</th>
									<th>Label 2</th>
									<th>Label 3</th>
									<th>Label</th>
									<th>Label</th>
									<th>Label</th>
								</tr>
							</thead>
							<tbody id="items">
								<tr>
									<td>1</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
									<td>Table cell</td>
								</tr>




							</tbody>
						</table>
						<hr>
						<div class="row">
							<div class="col-md-4 col-md-offset-4 text-center">
								<ul class="pagination" id="myPager"></ul>
							</div>
						</div>
					</div>
					<!--/table-resp-->

					<hr>

				</div>
				<!--/tab-pane-->
				<div class="tab-pane" id="messages">

					<h2></h2>

					<ul class="list-group">
						<li class="list-group-item text-muted">Inbox</li>
						<li class="list-group-item text-right"><a href="#"
							class="pull-left">Here is your a link to the latest summary
								report from the..</a> 2.13.2014</li>
						<li class="list-group-item text-right"><a href="#"
							class="pull-left">Hi Joe, There has been a request on your
								account since that was..</a> 2.11.2014</li>
						<li class="list-group-item text-right"><a href="#"
							class="pull-left">Nullam sapien massaortor. A lobortis vitae,
								condimentum justo...</a> 2.11.2014</li>
						<li class="list-group-item text-right"><a href="#"
							class="pull-left">Thllam sapien massaortor. A lobortis vitae,
								condimentum justo...</a> 2.11.2014</li>
						<li class="list-group-item text-right"><a href="#"
							class="pull-left">Wesm sapien massaortor. A lobortis vitae,
								condimentum justo...</a> 2.11.2014</li>
						<li class="list-group-item text-right"><a href="#"
							class="pull-left">For therepien massaortor. A lobortis vitae,
								condimentum justo...</a> 2.11.2014</li>
						<li class="list-group-item text-right"><a href="#"
							class="pull-left">Also we, havesapien massaortor. A lobortis
								vitae, condimentum justo...</a> 2.11.2014</li>
						<li class="list-group-item text-right"><a href="#"
							class="pull-left">Swedish chef is assaortor. A lobortis
								vitae, condimentum justo...</a> 2.11.2014</li>

					</ul>

				</div>
				<!--/tab-pane-->
				<div class="tab-pane" id="settings">

					<hr>
					<form class="form" action="##" method="post" id="registrationForm">
						<div class="form-group">

							<div class="col-xs-6">
								<label for="first_name">
									<h4>Nombre</h4>
								</label> <input class="form-control" type="text" name="nombre"
									placeholder="Mínimo 3 caracteres y máximo 50" minlength="3"
									maxlength="50" required autofocus tabindex="1" required>
							</div>
						</div>
						<div class="form-group">

							<div class="col-xs-6">
								<label for="password">
									<h4>Contraseña</h4>
								</label> <input class="form-control" type="password" name="pass"
									placeholder="Mín. 8 caracteres, max. 20 de al menos una mayúscula y un carácter numérico"
									minlength="8" maxlength="20"
									pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
									tabindex="2" required>
							</div>
							<div class="col-xs-6">
								<label for="password2">
									<h4>Repite contraseña</h4>
								</label> <input type="password" class="form-control" name="pass2"
									placeholder="vuelva a introducir la contraseña"
									minlength="8" maxlength="20"
									pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
									tabindex="2" required>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<br>
								<button class="btn btn-lg btn-success" type="submit">
									<i class="glyphicon glyphicon-ok-sign"></i> Aceptar
								</button>
								
							</div>
						</div>
					</form>
				</div>

			</div>
			<!--/tab-pane-->
		</div>
		<!--/tab-content-->

	</div>
	<!--/col-9-->
</div>
<!--/row-->



<%@include file="includes/footer.jsp"%>
