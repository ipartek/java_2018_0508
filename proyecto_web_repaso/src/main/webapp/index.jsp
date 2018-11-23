<!DOCTYPE html>
<html lang="es">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>REpaso mvc</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<div class="container">
			<h1>Repaso mvc</h1>
		</div>
	</header>

	<main class="container">

	<h2>Repaso servlet o controlador</h2>
	<p class="text-danger">${info }</p>
	
	<div class="row justify-content-md-center">
		<div class="col-8">
			<div class="card">
				<div class="card-header bg-secondary">Filtro de seguridad</div>
				<div class="card-body">
					<h5 class="card-title">${usuario != null ? 'Logueado':'Deslogueado' }</h5>
					<p class="card-text">Filtros y sesiones.</p>
						
					<form class="form-inline" action="videojuego" method="post">
						
							<label for="usuario">Nombre usuario</label> <input type="text"
								class="form-control" name="usuario"
								placeholder="Minimo 2 lestras maximo 150">
						
						
							<label for="password">Contraeña</label> <input
								type="password" class="form-control" name="password"
								placeholder="password">
						
						<button type="submit" class="${usuario != null ? 'btn btn-success':'btn btn-danger' }">Loguearse</button>
						
					</form>
					<a href="logout?usuario=0&password=0">Desloguearse</a>	
									
				</div>
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-8">
			<div class="card">
				<div class="card-header bg-secondary">Creacion de videojuegos</div>
				<div class="card-body">
					<h5 class="card-title">Videojuegos</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
						
					<form action="videojuego" method="post">
						<div class="form-group">
							<label for="titulo">Titulo Juego</label> <input type="text"
								class="form-control" name="titulo"
								placeholder="Minimo 2 lestras maximo 150">
						</div>
						<div class="form-group">
							<label for="fechaLanzamiento">Fecha de lanzamiento</label> <input
								type="date" class="form-control" name="fechaLanzamiento"
								placeholder="Fecha de lanzamiento">
						</div>
						<button type="submit" class="btn btn-primary">Crear VideoJuego</button>
					</form>
					
				</div>
			</div>
		</div>
	</div>

	<div class="card">
		<div class="card-header">Featured</div>
		<div class="card-body">
			<p>Vamos a enviar datos por get y post</p>
			<p>
				El mapping del controlador es <b>/flujo-clasico</b> JSP -SERVLET
			</p>
			<p>
				<b>JSP -> Servlet</b> enviams parametros
			</p>
			<p>
				<b>Servlet -> jsp</b>Enviamos atributos
			</p>
			<hr>
			<p>
				El servlet recibe 2 parametros <b>p1</b> <b>p2</b> los sumara y lo
				envia como atributo suma a resultado.jsp
			</p>
			<div class="container">
				<div class="row">
					<div class="col-6">
						<h2>Peticion get</h2>
						Las peticiones get se envian parametros atraves de la url
						<pre>
							<code>/flujo-clasico?op1=1&op2=2</code>
						</pre>
						<p>Suma 3 + 5</p>
						<a href="flujo-clasico?op1=3&op2=5" class="btn btn-primary">Enviar</a>
					</div>
					<div class="col-6">
						<h2>Peticion post</h2>

						Las peticiones post se envian parametros atraves de un formulario
						<hr>
						<form action="flujo-clasico" method="post">

							<div class="form-group">
								<label for="exampleInputPassword1">Parametro 1</label> <input
									type="text" class="form-control" name="op1"
									placeholder="Parametro1">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Parametro 2</label> <input
									type="text" class="form-control" name="op2"
									placeholder="Parametro2">
							</div>

							<button type="submit" class="btn btn-primary">Calcular</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


	</main>


	<!-- Bootstrap core JavaScript -->
	<script
		src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
	<script
		src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Scripts para plugin datatable -->

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

	<script>
		</body>
		</html>
	