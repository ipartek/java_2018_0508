<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
  	
	<c:if test="${not empty juego}">
		<h2>Videojuego Creado</h2>
		<p>ID: ${juego.id}</p>
		<p>Titulo: ${juego.titulo}</p>
		<p>Fecha de Lanzamiento: ${juego.fechaLanzamiento}</p>
	</c:if>
	
	<c:if test="${empty juegos}">
	<p>${msj}</p>
	</c:if>
	
	<div class="container">
	<h2 class="mb-3">Listado de Videojuegos</h2>
		<div class="row">
			<c:forEach items="${juegos}" var="j">
			<div class="col-4">
				<div class="card mb-3" style="width: 18rem;">
				  <div class="card-header">
				  	<h4 class="card-title">${j.id} - ${j.titulo}</h4>
				  </div>
				  <div class="card-body">
					<p class="card-text">Lanzamiento: ${j.fechaLanzamiento}</p>
				  </div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>

<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
