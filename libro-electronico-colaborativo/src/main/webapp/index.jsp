<%@include file="includes/header.jsp" %>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<ul class="navbar-nav ml-auto">
			<c:if test="${empty usuario}">
				<li class="nav-item"><a href="login.jsp">Iniciar sesion</a></li>
			</c:if>
			<c:if test="${not empty usuario}">
				<li class="nav-item mr-3"><i class="fas fa-user text-white"> ${usuario.nombre}</i> </li>
				<li class="nav-item"><a href="logout">Cerrar sesion</a></li>
			</c:if>
		</ul>
	</nav>
	
	<div class="container mt-3">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-3">
				<c:if test="${not empty usuario}">
					<i class="fas fa-pencil-alt"><a href="privado/escribir.jsp" class="text-dark"> Escribir pagina</a></i>
				</c:if>
			</div>
			<div class="col-lg-3">
				<form class="form-inline mb-3 float-right">
    				<input type="number" class="form-control" id="numeroPagina" placeholder="Ir a pagina">
					<button class="btn btn-outline-info my-2 my-sm-0 ml-2" type="submit">Ir</button>
				</form>
			</div>
			<div class="col-lg-3"></div>
		</div>
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-3">
				<i class="fas fa-arrow-left float-left mb-2"><a href="home?nPagina=${pActual-1}"> Anterior</a></i>
			</div>
			<div class="col-lg-3">
				<i class="fas fa-arrow-right float-right mb-2"><a href="home?nPagina=${pActual+1}" class="float-left mr-1">Siguiente </a></i>
			</div>
			<div class="col-lg-3"></div>
		</div>
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="card">
				  <div class="card-body">
				    <h2 class="text-center">Pagina ${pActual+1}/${pTotal}</h2>
				    <p>${pagina.texto}</p>
				  </div>
				  <div class="card-footer text-right">
					<p>Autor: <span>${pagina.autor}</span></p>
				  </div>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
		<div class="row mb-3">
			<div class="col-lg-3"></div>
			<div class="col-lg-3">
				<i class="fas fa-arrow-left float-left mt-2"><a href="home?nPagina=${pActual-1}"> Anterior</a></i>
			</div>
			<div class="col-lg-3">
				<i class="fas fa-arrow-right float-right mt-2"><a href="home?nPagina=${pActual+1}" class="float-left mr-1">Siguiente</a></i>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>
<%@include file="includes/footer.jsp" %>