<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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

<link rel="stylesheet" href="css/styles.css">

<base href="<%=request.getContextPath()%>/">

<title>Index repaso</title>
</head>
<body>

	<header class="headerIndex">
		<div class="container">
			<h1>Repaso MVC</h1>
		</div>
	</header>

	<main class="container">
	
	<div class="card">
  <div class="card-header bg-secondary">
    Featured
  </div>
  <div class="card-body">
    <h5 class="card-title">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  
	<h2>Repaso Servlet o Controlador</h2>

	<p>Vamos a enviar datos por GET y POST</p>
	<p>
		El mapping del controlador es <b>flujo-clasico</b> JSP -> Servlet ->
		JSP
	</p>
	<p>
		JSP -> Servlet enviamos <b>parametros</b>
	</p>
	<p>
		Servlet -> JSP enviamos <b>atributos</b>
	</p>
	<hr>
	<p>
		El servlet recibirá 2 parametros <b>p1</b> y <b>p2</b>, los sumará, y
		lo envia como atributo <b>suma</b> a resusltado.jsp
	</p>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>Petición GET</h2>
				<p>En las peticiones GET los parametros se envian en la URL.</p>
				<pre><code>/flujo-clasico?op1=5&op2=13</code></pre>
				<a href="flujo-clasico?op1=5&op2=13" class="btn btn-primary btn-lg"
					tabindex="-1" role="button" aria-disabled="true">Realizar suma</a>
			</div>
			<div class="col-6">
				<h2>Petición POST</h2>
				<p>En las peticiones POST los parametros se envian a través de
					un formulario.</p>

				<form method="POST" action="flujo-clasico">
					<div class="form-group">
						<label for="parametro1">Parametro 1</label> <input type="text"
							name="op1" class="form-control" id="parametro1"
							placeholder="Introduce un numero">

					</div>
					<div class="form-group">
						<label for="parametro2">Parametro 2</label> <input type="text"
							name="op2" class="form-control" id="parametro2"
							placeholder="Introduce otro numero">
							 <small class="form-text text-danger">${msg}</small>
					</div>
						
					<button type="submit" class="btn btn-primary">Sumar</button>
				</form>
			</div>
		</div>
	</div>
	
	</div><!-- div card body -->
</div><!-- div card header -->


<div class="card">
	  <div class="card-header mt-3 bg-primary">
	    Videojuego
	  </div>
	  <div class="card-body">
	    <h5 class="card-title">Crear videojuego</h5>
	    
	    <p class="text-danger">${msg}</p>
	    <form action="videojuego" method="POST">
		    <div class="form-group">
			     <label for="titulo">Titulo</label>
			     <input type="text" class="form-control" name="titulo" placeholder="Introduce minimo 2 letras máximo 150">
			     
			     <label class="mt-3"for="fechaLanzamiento">Fecha de lanzamiento</label>
			     <input type="date" class="form-control" name="fechaLanzamiento">
			    
			    <input type="submit" class="btn btn-primary" value="Crear videojuego">
		    </div>
	    </form>
	  </div>
</div>
<div class="card mt-3">
	 <div class="card-header mt-3 bg-primary">
	    LOGIN Y FILTRO
	  </div>
	  <div class="card-body">
	  <c:if test="${not empty sessionScope.login  }">
	  <a href="videojuego" type="button" class="btn btn-success btn-lg"
					tabindex="-1" role="button" aria-disabled="true">Acceder privado</a>
					<h3 class="text-success">${msgLogin}</h3>
	  </c:if>
	  
	  <c:if test="${empty sessionScope.login }">
	  <a href="videojuego"type="button" class="btn btn-danger btn-lg"
					tabindex="-1" role="button" aria-disabled="true">Acceder privado</a>
					<h3 class="text-danger">${msgLogin}</h3>
	  </c:if>
	    <h5 class="card-title">Login</h5>
	    
		<form action="login" method="POST">
			  <div class="form-group">
				    <label for="nombre">Nombre</label>
				    <input type="text" class="form-control" id="nombre" name="nombre" aria-describedby="emailHelp" placeholder="Introduce tu nombre">
			  </div>
			  <div class="form-group">
				    <label for="password">Contraseña</label>
				    <input type="password" class="form-control" id="password" name="password"placeholder="Introduce tu password">
			  </div>
		  	  <button type="submit" class="btn btn-primary">Logearse</button>
		</form>

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