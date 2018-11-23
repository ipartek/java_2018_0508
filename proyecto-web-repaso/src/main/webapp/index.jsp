<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="css/styles.css">

    <title>Repaso</title>
  </head>
  <body>
    
    <header>
    	<div class="container">
  			<h1>Repaso MVC</h1>
  		</div>
  	</header>

	<main class="container">
		<div class="card mt-3 mb-3">
	  		<h5 class="card-header bg-primary">Repaso Servlet o Controlador</h5>
	  		<div class="card-body">
				<p>Vamos a enviar datos por GET y POST</p>
				<p>El mapping del controlador es <b>/flujo-clasico</b>: JSP -> Servlet -> JSP</p>
				<p><b>JSP -> Servlet</b>: enviamos <b>parametros</b></p>
				<p><b>Servlet -> JSP</b>: enviamos <b>atributos</b></p>
				
				<hr>
				<p>El servlet va a recibir dos parametros <b>p1</b> y <b>p2</b> los sumara y lo enviara como atributo <b>suma</b> a resultado.jsp</p>
				
				<div class="container">
				  <div class="row">
				    <div class="col-6">
				    	<h3>Peticion GET</h3>
				    	<p>En las peticiones GET los parametros se envian en la URL</p>
				    	<p><code>/flujo-clasico?op1=5&op2=13</code></p>
			      
			      		<a class="btn btn-success mb-2" href="flujo-clasico?op1=5&op2=13">Peticion correcta</a><br>
			      		<a class="btn btn-warning mb-2" href="flujo-clasico?op2=13">Peticion Sin un Parametro</a><br>
			      		<a class="btn btn-danger" href="flujo-clasico?op1=letras&op2=13">Peticion con Parametro NO Integer</a>
				    </div>
				    <div class="col-6">
				    	<h3>Peticion POST</h3>
				    	<p>En las peticiones POST los paramentos se envian a traves de un formulario</p>
				    	<form action="flujo-clasico" method="post">
				    		<div class="form-group">
						    	<label for="op1">Primer numero</label>
						    	<input type="text" class="form-control" id="op1" name="op1" placeholder="5" required>
						  	</div>
						  	<div class="form-group">
						    	<label for="op2">Segundo numero</label>
						    	<input type="text" class="form-control" id="op2" name="op2" placeholder="13" required>
						  	</div>
						  	<button type="submit" class="btn btn-primary btn-block">Submit</button>
				    	</form>
				    </div>
				  </div>
				</div> <!-- /.container -->
			</div> <!-- /.card-body -->
		</div> <!-- /.card-header -->
		
		<div class="card mb-3" id="section_database">
	  		<h5 class="card-header bg-primary">Crear o Listar Videojuego</h5>
	  		<div class="card-body">
	  			<c:if test="${not empty info}">
	  				<span class="bg-danger text-white p-2">${info}</span>
	  			</c:if>
		    	<div class="container mt-3">
		    		<form action="videojuego" method="post">
		    			<div class="form-group">
							<label for="titulo">Titulo</label>
						   	<input type="text" class="form-control" id="titulo" name="titulo" placeholder="Minimo 2 y Maximo 150 caracteres" required>
						</div>
						<div class="form-group">
							<label for="fechaLanzamiento">Fecha de Lanzamiento</label>
						   	<input type="date" class="form-control" id="fechaLanzamiento" name="fechaLanzamiento" required>
						</div>
		    			<input type="submit" value="Crear" class="btn btn-primary btn-block mb-3">
		    		</form>
		    		<a href="videojuego" class="btn btn-outline-success btn-block">Listar</a>
				</div> <!-- /.container -->
			</div> <!-- /.card-body -->
		</div> <!-- /.card-header -->
		
		<div class="card mb-3" id="section_seguridad">
	  		<h5 class="card-header bg-primary">Filtro de Seguridad</h5>
	  		<div class="card-body">
	  			<c:if test="${not empty fallo}">
	  				<span class="bg-danger text-white p-2">${fallo}</span>
	  			</c:if>
	  			<c:if test="${not empty sessionScope.logear}">
	  				<span class="bg-danger text-white p-2">${sessionScope.logear}</span>
	  				${sessionScope.logear = ""}
	  			</c:if>
		    	<div class="container mt-3">
		    		<form action="login" method="post">
		    			<div class="form-group">
							<label for="usuario">Usuario</label>
						   	<input value="admin" type="text" class="form-control" id="usuario" name="usuario" placeholder="Nombre del usuario" required>
						</div>
						<div class="form-group">
							<label for="password">Contraseña</label>
						   	<input value="admin" type="password" class="form-control" id="password" name="password" placeholder="Contraseña del usuario" required>
						</div>
		    			<input type="submit" value="Acceder" class="btn btn-success btn-block mb-3">
		    		</form>
		    		<a href="backoffice/backoffice.jsp" class="btn btn-danger btn-block">Acceder Privado</a>
				</div> <!-- /.container -->
			</div> <!-- /.card-body -->
		</div> <!-- /.card-header -->
		
    </main><!-- /.container -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>