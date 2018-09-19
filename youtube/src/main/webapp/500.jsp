<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="es">

  <head>

	<!-- Comenza todas las URLs desde el href indicado -->
	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Youtube Video Play List</title>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">

  </head>

  <body>
  
  	<div class="container">
  
	  	<header class="cabecera-error">
	  	
	  		<img src="images/youtube_logo.png" alt="logo partek" />
	  	
	  	</header>
		
		<div class="error">
		
			<h1>Error 500</h1>
			<h2>Error en el servidor</h2>
			<p>Lo sentimos, en estos momentos no podemos procesar su petición</p>
			<a href="inicio" class="btn btn-danger">Volver a la página anterior</a><br/><br/>
			<a href="mailto:example@email.com" class="btn btn-danger">Contacte con el administrador</a> 
		
		</div>
	
	</div>

  </body>

</html>
