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
	
		<p>El resultado de sumar los dos parámetros es: </p>
		
		<h2>Expression Language</h2>
		<p>${suma}</p>
		
		<h2>Scriplet</h2>
		<p><%=request.getAttribute("suma")%></p>
	  	
	</main>
    

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>