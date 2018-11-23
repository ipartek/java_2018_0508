<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">

    <title>Repaso MVC</title>
  </head>
  
  <body>
  
  
  	<header>
  		<div class="container">
  			<h1>Repaso MVC</h1>
  		</div>
  	</header>
  
  	<main class="container">
  	
  	<div class="card">
	  	<h5 class="card-header bg-primary  text-white">Repaso Servlet o Controlador</h5>
	  	<div class="card-body">
	  		
	    	<p>Vamos a enviar datos por GET y POST</p>
	    	<p>El mapping del controlador es <b>/flujo-clasico</b> JSP -> Servelt -> JSP</p>
	    	<p><b>JSP -> SERVLET</b> enviamos <b>parametros</b></p>
	    	<p><b>SERVLET -> JSP</b> enviamos <b>atributos</b></p>
	    	
	    	<hr>
	    	<p>El servlet va a recibir dos parametros <b>p1</b> y <b>p2</b> los sumara y lo envia como atributo <b>suma</b> a resultado.jsp<p>
	    	
	    	<div class="container">
			  <div class="row">
			    <div class="col-6">
			      <h2>Peticion GET</h2>
			      <p>Las peticiones GET se envian los parametros en la URL.</p>
			      <pre><code>/flujo-clasico?op1=5&op2=13</code></pre>
			      
			      <a class="btn btn-success" href="flujo-clasico?op1=5&op2=13">Peticion correcta</a>
			      <a class="btn btn-warning" href="flujo-clasico?op2=13">Peticion Sin un Parametro</a>
			      <a class="btn btn-danger" href="flujo-clasico?op1=letras&op2=13">Peticion con Parametro NO Integer</a>
			      
			    </div>
			    <div class="col-6">
			      <h2>Peticion POST</h2>
			      <p>Las peticiones POST se envian los parametros a traves de un formulario.</p>
			      <form action="/flujo-clasico" method="post">
			      
			      	<label for="op1">Primer Numero</label>
			      	<input type="text" name="op1">
			      	<br>
			      	<label for="op2">Segundo Numero</label>
			      	<input type="text" name="op2">
			      	<br>
			      	<input type="submit" value="sumar" class="btn btn-primary">
			      </form>
			    </div>		   
			  </div>
			</div> 
			<!-- <div class="container"> --> 
			
		</div><!-- <div class="card-body"> -->
	</div><!-- <div class="card"> -->
	
	
	<div class="card mt-3 ">
	  	<h5 class="card-header bg-primary text-white">Crear Videojuego</h5>
	  	<div class="card-body">
		
		  	<form action="videojuego" method="post">
		  	
		  		<div class="form-group">
				    <label for="titulo">Titulo</label>
				    <input type="text" class="form-control" name="titulo" placeholder="minimo 2 letras max 150">				    
				</div>
				
				<div class="form-group">
				    <label for="fechaLanzamiento">Fecha Lanzamiento</label>
				    <input type="date" class="form-control" name="fechaLanzamiento">				    
				</div>
		  	
		  		<input type="submit" value="crear" class="btn btn-primary">
		  	</form>	
	    	
		</div><!-- <div class="card-body"> -->
	</div><!-- <div class="card"> -->
		
    	
    </main>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
  </body>
</html>