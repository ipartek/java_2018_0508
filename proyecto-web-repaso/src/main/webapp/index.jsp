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
    
    	<h2>Repaso Servlet o Controlador</h2>
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
		    	<a href="flujo-clasico?op1=5&op2=13" class="btn btn-primary btn-block"><code>/flujo-clasico?op1=5&op2=13</code></a>
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
		</div>
		
    </main><!-- /.container -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>