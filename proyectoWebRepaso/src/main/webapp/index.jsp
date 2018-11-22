<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/styles.css">

    <title>Hello, world!</title>
  </head>
  <body>
  	<header>
  		<div class=container>
  			<h1>Repaso MVC</h1>
  		</div>
  		
  	</header>
  
  	<main class="container">
  		<!-- Tratamiento de las alertas -->
		<c:if test="${not empty alert}">
			<div class="alert ${alert.tipo} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${alert.texto}</strong>
			</div>
		</c:if>
  	
  	
  	<h2>Repaso Servlet o Controlador</h2>
  		<p>Vamos a enviar datos por GET y POST</p>
  		<p>El mapping del controlador es <b>/flujo-clasico</b> JSP->Servlet ->JSP</p>
  		<p><b>SJP -> SERVLET </b> enviamos<b> parametros</b></p>
  		<p><b>SERVLETS -> JP </b> enviamos <b>atributos</b></p>
  		
  		<hr>
  		<p>El servlet va a recibir 2 parametros<b> p1 </b> y <b>p2</b> los sumará y enviará como atributo <b>resultado</b>a resultado.jsp</p>
  		<div class="container">
			  <div class="row">
				    <div class="col-sm ">
					     <h3>PETICION GET</h3> 
					    <p> Las peticiones GET se envian los paramtros en la URL</p>
					    <pre><code>/flujo-clasico?p1=4&p2=3</code></pre>
				    </div>
				    <div class="col-sm ">
					     <h3>PETICION POST</h3> 
					     <p>Las peticiones POST se envian los parametros a traves de los formularios</p>
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