<%@include file="includes/header.jsp" %>

<%@include file="includes/navbar.jsp" %>

	<div class="container text-center">
	
	<!-- Header -->
		<div class="row">
			<header class="col-12">
				<h1 class="text-success text-monospace display-4">NIDEA</h1>
				<h2 class="text-monospace text-info">Ni Sabemos Lo Que Vendemos, Ni Lo Que Hacemos...</h2>
				<h5>12 Columnas</h5>
			</header>
		</div>
	<!-- /Header -->
	
	<!-- Nav -->
	<nav class="navbar navbar-expand-lg navbar-light bg-navbar mt-2">
	  <a class="navbar-brand" href="#">A Nidea</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	    <div class="navbar-nav">
	      <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
	      <a class="nav-item nav-link" href="#">Productos</a>
	      <a class="nav-item nav-link" href="#">Colecciones</a>
	    </div>
	  </div>
	</nav>
	<div class="sticky-top progress mb-2">
	  <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
	</div>
	<!-- /Nav -->
	
	<!-- Main -->
		<div class="row align-items-center main">
			<div class="col-12 col-md-8 col-xl-6">
				<section>
					<h5 class="d-none d-md-block d-xl-none">8 Columnas</h5>
					<h5 class="d-block d-sm-block d-md-none">12 Columnas</h5>
					<h5 class="d-none d-xl-block">6 Columnas</h5>
					<div class="text-warning">
						<h2>BreakPoints</h2>
						<p>xs -- &lt; 576px</p>
						<p>sm -- &gt;= 576px</p>
						<p>md -- &gt;= 768px</p>
						<p>lg -- &gt;= 992px</p>
						<p>xl -- &gt;= 1200px</p>
					</div>
				</section>
			</div>
			<div class="col-12 col-md-4 col-xl-6 ">
				<aside>
					<h5 class="d-none d-md-block d-xl-none">4 Columnas</h5>
					<h5 class="d-block d-sm-block d-md-none">12 columnas</h5>
					<h5 class="d-none d-xl-block">6 Columnas</h5>
				</aside>
			</div>
		</div>
	<!-- /Main -->
	
	<!-- Destacados -->
		<div class="row m-3 destacados">
			<div class="col-12 col-md-4 col-lg-3 offset-lg-1">
				<h5 class="d-none d-lg-block">3 Columnas</h5>
				<h5 class="d-none d-md-block d-lg-none">4 Columnas</h5>
				<h5 class="d-block d-sm-block d-md-none">12 Columnas</h5>
				<div class="text-warning">
					<h2>Ofertones</h2>
				</div>
				<img src="images/imagen01.svg" alt="kuki monster">
			</div>
			<div class="col-12 col-md-4 col-lg-3 offset-lg-1">
				<h5 class="d-none d-lg-block">3 Columnas</h5>
				<h5 class="d-none d-md-block d-lg-none">4 Columnas</h5>
				<h5 class="d-block d-sm-block d-md-none">12 Columnas</h5>
				<div class="text-warning">
					<h2>Ofertones</h2>
				</div>
				<img src="images/imagen01.svg" alt="kuki monster">
				<button type="button" class="btn btn-danger ult-ofertas">
				  Últimos <span class="badge badge-light">4</span>
				</button>
			</div>
			<div class="col-12 col-md-4 col-lg-3 offset-lg-1">
				<h5 class="d-none d-lg-block">3 Columnas</h5>
				<h5 class="d-none d-md-block d-lg-none">4 Columnas</h5>
				<h5 class="d-block d-sm-block d-md-none">12 Columnas</h5>
				<div class="text-warning">
					<h2>Ofertones</h2>
				</div>
				<img src="images/imagen01.svg" alt="kuki monster">
				<span class="badge badge-info proc-new">Nuevo</span>
			</div>
		</div>
	<!-- /Destacados -->
	
	<!-- Footer -->
		<div class="row">
			<footer class="col-12">
				<h5>12 Columnas</h5>
			</footer>
		</div>
	<!-- /Footer -->
	</div>
<!-- /.container -->
<%@include file="includes/footer.jsp" %>