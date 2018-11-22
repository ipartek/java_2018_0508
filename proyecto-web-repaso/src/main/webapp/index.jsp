<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

 	<!-- Estilo Css -->
    <link rel="stylesheet" href="css/styles.css?v=1.0">
    
    <title>Reppaso MVC</title>
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
	<p>El mapping del controlador es <b>/flujo-clasico</b>JSP -> Servlet -> JSP </p>
	<p><b>JSP -> SERVLET</b> enviamos <b>parametros</b></p>
	<p><b>SERVLET -> JSP</b> enviamos <b>atributos</b></p>
	
	<hr>
	<p>
		El servlet va a recibir dos para metros <b>p1</b> <b>p2</b> los sumara
		y lo enviara como atributo <b>suma</b> resultado JSP
	</p>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>PETICION GET</h2>
				<p>Las peticiones GET se envian los parametros en la URL</p>
				
				<button type="button" class="btn btn-primary">SUMA</button>
				<pre>
      <code>
      /flujo-clasico?numero1=5&"numero2"=13
      </code>
      </pre>
			</div>
			<div class="col-6">
				<h2>PETICION POST</h2>
				<p>Las peticiones POST se envian los parametros a traves de un
					formulario</p>

				<form action="resultado.jsp" method="POST">
					<table>
						<tr>
							<td>Ingrese numero 1 :</td>
							<td><input type="text" name="numero1"></td>
						</tr>
						<tr>
							<td>Ingrese numero 2 :</td>
							<td><input type="text" name="numero2"></td>
						</tr>
						<tr>
							<td><input type="submit" name="enviar" value="Sumar">
							</td>
						</tr>
					</table>
				</form>

		<pre>
      <code>
      /flujo-clasico?op1=5&op2=13
      </code>
      </pre>
			</div>
			
			
		</div>
	</div>
	</main>




	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>