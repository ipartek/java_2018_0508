<%@ include file="../includes/header.jsp"%>
<div id="app">
	<div class="main-wrapper">
		<div class="navbar-bg"></div>


		<%@ include file="../includes/nav.jsp"%>
		<div class="main-content">
			<section class="section">
				<h1 class="section-header">
					<div>Editar Historico</div>
				</h1>
				<div class="container mt-5">
					<div class="row">
						<div
							class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-8 offset-lg-2 col-xl-8 offset-xl-2">


							<div class="card card-primary">
								<div class="card-header">
									<h4>Editar Historico</h4>
								</div>

								<div class="card-body">
									<form action="prestamo" method="POST">
										<input type="hidden" name="op" value="9" />
										<input type="hidden" name="idlibroAntiguo" value="${prestamo.libro.id}" />
										<input type="hidden" name="idUsuarioAntiguo" value="${prestamo.usuario.id}" />
										<input type="hidden" name="fechaInicioAntiguo" value="<fmt:formatDate pattern = "MM/dd/yyyy" value = "${prestamo.fech_inicio }" />" />
										<div class="row">
											<div class="form-group col-6">
												<label>TITULO LIBRO - <a href="libro?op=4">Nuevo Libro</a></label> 
												<select name="libro" class="form-control" required>
													<option value="${prestamo.libro.id}">${prestamo.libro.id} - ${prestamo.libro.titulo}</option>
													<c:forEach items="${libros}" var="l">
														<option value="${l.id}">${l.id} - ${l.titulo}</option>
													</c:forEach>
												</select>
											</div>
											<div class="form-group col-6">
												<label>USUARIO - <a href="usuario?op=4">Nuevo Usuario</a></label> 
												<select name="usuario" class="form-control" required>
													<option value="${prestamo.usuario.id}">${prestamo.usuario.id} - ${prestamo.usuario.nombreApellidos}</option>
													<c:forEach items="${usuarios}" var="u">
														<option value="${u.id}">${u.id} - ${u.nombreApellidos}</option>
													</c:forEach>
												</select>
											</div>
											<!-- Fecha Prestamo -->



										</div>

										<div class="row">
											<div class="form-group col">
												<label for="last_name">FECHA PRESTAMO</label> 
												 <input name="fechaInicio" id="datepicker" width="276" value="<fmt:formatDate pattern = "MM/dd/yyyy" value = "${prestamo.fech_inicio}" />" required/>
											</div>
											<div class="form-group col">
												<label for="last_name">FECHA DEVOLUCION</label> 
												 <input name="datedevolucion" id="datedevolucion" width="276" value="<fmt:formatDate pattern = "MM/dd/yyyy" value = "${prestamo.fecha_devuelto}" />" required/>
											</div>
										</div>

										<div class="form-group">
											<button type="submit" class="btn btn-primary btn-block">Editar Historico</button>
										</div>
									</form>
								</div>
							</div>
							<div class="simple-footer">Copyright &copy; Ipartek 2018</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<%@ include file="../includes/footer.jsp"%>