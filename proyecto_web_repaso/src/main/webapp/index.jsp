<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">

    <title>Proyecto Web Repaso</title>
  </head>
  
  <body>
	<header class="shadow-sm p-3 mb-5 rounded">
	
		<div class="container">
			<h1 class="text-center">Hello, world!</h1>
		</div>

	</header>
	
	<main class="container">
	
		<c:if test="${empty error }">
			${error = null }
		</c:if>
		
		<c:if test="${not empty error }">
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				<span>${error}</span>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</c:if>
	  
		<h2>Repaso Servlet o Controlador</h2>
		<p>Vamos a enviar datos por GET y POST</p>
		<p>El mapping del controlador es <b>flujo-clasico:</b> JSP -> Servlet -> JSP</p>
		<p>JSP -> Servlet Se envían <b>parámetros</b> || Servlet -> JSP <b>atributos</b></p>
	  	
	  	<hr>
	  	
	  	<p>El servlet va a recibir dos parámetros <b>p1</b> y <b>p2</b> los sumará y lo 
	  	envía como atributo <b>suma</b> a resultado.jsp</p>
	  	
	  	<hr>
	  	
		<div class="row">
			<div class="col-6 text-center">
				<h3>Petición GET</h3>
				<p>En las peticiones GET se envían los parámetros en la URL.</p>
				<pre><code>/flujo-clasico?op1=5&op2=13</code></pre>
				
				<a href="flujo-clasico?op1=5&op2=13" class="btn btn-outline-primary">Enviar</a>
			</div>
			<div class="col-6 text-center">
				<h3>Petición POST</h3>
				<p>En las peticiones POST se envían los parámetros a través de un
				formulario.</p>
				<form action="flujo-clasico" method="post">
					<div class="form-row">
				    	<div class="col">
				      		<input autofocus required type="number" name="op1" step="1" class="form-control" placeholder="Primer valor">
				    	</div>
				    	<div class="col">
				      		<input required type="number" name="op2" step="1" class="form-control" placeholder="Segundo valor">
				    	</div>
					</div>
					<div class="form-row mt-3">
						<div class="col">
							<input type="submit" class="btn btn-block btn-outline-primary" value="Enviar">
						</div>
					</div>
				</form>
			</div>
		</div>
	  	
	</main>
    

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>