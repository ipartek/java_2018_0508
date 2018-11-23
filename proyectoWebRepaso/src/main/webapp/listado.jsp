<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <h1 class="text-center">VIDEOJUEGO</h1>
    
    <c:if test="${not empty juego }">
    	<h2>Videojuego creado!!</h2>
    	<ul class="list-group">
		  <li class="list-group-item"><label>id: </label>${juego.id}</li>
		  <li class="list-group-item"><label>titulo: </label>${juego.titulo}</li>
		  <li class="list-group-item"><label>fecha: </label>${juego.fecha_lanzamiento}</li>
		  
		</ul>
    </c:if>
    
    <h2>Listado de juegos</h2>
    
    <c:forEach items="${juegos}" var="j">
     	<ul class="list-group">
		  <li class="list-group-item"><label>id: </label>${j.id}</li>
		  <li class="list-group-item"><label>titulo: </label>${j.titulo}</li>
		  <li class="list-group-item"><label>fecha: </label>${j.fecha_lanzamiento}</li>		  
		</ul>
    </c:forEach>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>