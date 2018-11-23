<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!-- Custom css -->
<link rel="stylesheet" href="css/styles.css">

<base href="<%=request.getContextPath()%>/">

<title>Repaso - MVC</title>
</head>
<body>


	<header>
		<div class="container">
			<h1>Repaso - MVC</h1>
		</div>
	</header>

	<main role="main" class="container">




	<div class="card mt-4">
		<h5 class="card-header bg-primary text-white">Repaso Servlet o Controlador</h5>
		<div class="card-body">

			<p>Vamos a enviar datos por GET y POST</p>
			<p>El mapping del controlador es <b>/flujo-clasico</b> JSP -> Servlet -> JSP</p>
			<p><b>JSP -> SERVLET</b> enviamos <b>párametros</b>.</p>
			<p><b>SERVLET -> JSP</b> enviamos <b>atributos</b>.</p>

			<hr>

			<p>El servlet va a recibir dos parámetros <b>p1</b> y <b>p2</b>, los sumará y lo enviará como atributo <b>suma</b> a resultado.jsp.</p>
			<div class="container">
				<div class="row">
					<div class="col-6">
						<h2>Petición GET</h2>
						<p>En las peticiones GET se envían los parámetros en la URL.</p>
						<pre><code>/flujo-clasico?op1=5&op2=13</code></pre>
						<a href="flujo-clasico?op1=5&op2=13" class="btn btn-primary">Sumar 5 + 13</a>
					</div>
					<div class="col-6">
						<h2>Petición POST</h2>
						<p>En las peticiones POST se envían los parámetros a través de un formulario.</p>

						<form action="flujo-clasico" method="post" id="formSuma">

							<div class="form-group">
								<label for="op1">Parámetro 1</label> 
								<input type="text" class="form-control" id="op1" name="op1" placeholder="Introduzca un número" required>
							</div>
							<div class="form-group">
								<label for="op2">Parámetro 2</label> 
								<input type="text" class="form-control" id="op2" name="op2" placeholder="Introduzca un número" required>
							</div>

							<button type="submit" class="btn btn-primary btn-block">Sumar</button>

						</form>

					</div>
				</div><!-- /.row -->
			</div><!-- /.container -->
		</div><!-- /.card-body -->
	</div><!-- /.card -->


	<div class="card mt-4">
		<h5 class="card-header bg-primary text-white">Crear un Videojuego</h5>
		<div class="card-body">
		
			<p class="text-danger">${msgError}</p>
			<form action="videojuego" method="post">
				
				<div class="form-group">
					<label for="titulo">Título</label>
					<input type="text" id="titulo" name="titulo" class="form-control" placeholder="Mínimo 2 ymáximo 150" />
				</div>
				
				<div class="form-group">
					<label for="fechaLanzamiento">Fecha de lanzamiento</label>
					<input type="date" id="fechaLanzamiento" name="fechaLanzamiento" class="form-control" />
				</div>
				
				<button type="submit" class="btn btn-primary btn-block">Crear</button>
			</form>
			
		</div>
	</div>

	</main>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>