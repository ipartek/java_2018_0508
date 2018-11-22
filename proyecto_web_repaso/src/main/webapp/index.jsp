<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

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
  		<h2>Repaso Servlet o Controlador</h2>
    	<p>Vamos a enviar datos por GET y POST</p>
    	<p>El mapping del controlador es <b>/flujo-clasico</b> JSP -> Servlet -> JSP</p>
    	<p><b>JSP -> SERVLET</b> enviamos <b>párametros</b>.</p>
    	<p><b>SERVLET -> JSP</b> enviamos <b>atributos</b>.</p>
    	
    	<hr>
    	
    	<p>El servlet va a recibir dos parámetros <b>p1</b> y <b>p2</b>, los sumará y lo enviará como atributo <b>suma</b> a resultado.jsp.
    	
    	<div class="container">
		    <div class="row">
		        <div class="col-6">
		            <h2>Petición GET</h2>
		            <p>En las peticiones GET se envían los parámetros en la URL.</p>
		            <pre><code>/flujo-clasico?op1=5&op2=13</code></pre>
		            <a href="flujo-clasico?op1=5&op2=8" class="btn btn-primary">Sumar 5 + 8</a>
		            <h3 class="text-danger">${msgError}</h3>
		    	</div>
		    	<div class="col-6">
		            <h2>Petición POST</h2>
		            <p>En las peticiones POST se envían los parámetros a través de un formulario.</p>
		            
		            <form action="flujo-clasico" method="post">

					<div class="form-group">
						<label for="p1">Parámetro 1</label> 
						<input type="text" class="form-control" id="p1" name="p1" placeholder="Introduzca un número"> 
					</div>
					<div class="form-group">
						<label for="p2">Parámetro 2</label> 
						<input type="text" class="form-control" id="p2" name="p2" placeholder="Introduzca un número"> 
					</div>
					
					<button type="submit" class="btn btn-primary btn-block">Sumar</button>

				</form>
		            
		    	</div>
		  	</div>
		</div>
    	
	</main>
	
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>