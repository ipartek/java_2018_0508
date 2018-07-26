<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

	<title>Registrar un libro</title>
	<meta name="author" content="Luis">

</head>

<body>

	<h1>Registro de Libro</h1>
	
	<form name="registro-libro" method="post" action="registrar-libro">

		<div class="form-group">
			<input type="text" placeholder="Título" required class="form-control" name="titulo"> 
		</div>
		<div class="form-group">
    		<input type="text" placeholder="Autor" required class="form-control" name="autor">
		</div>
		<div class="form-group">
			<input type="text" placeholder="Editorial" required class="form-control" name="editorial"> 
		</div>
		<div class="form-group">
    		<input type="text" placeholder="ISBN" required class="form-control" name="isbn">
		</div>
		<div class="form-group">
			<input type="number" placeholder="Nº de páginas" required class="form-control" name="numPaginas"> 
		</div>
		<div class="form-group">
    		<input type="checkbox" class="form-control" name="esPrestado"> Prestado
		</div>
			<input type="submit" value="Login">
		</form>
	<p> ${msg}</p>
	
	
	
	

</body>
</html>