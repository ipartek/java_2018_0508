<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	
	<title>Gestion_libros</title>
	<meta name="description" content="App Web Java 3.0 para gestionar prestamos libros">
	<meta name="author" content="Valeria Valencia">
	<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

<h1>Formulario Libros</h1>

<form action="formulario" method="post">
    <div>
        <label for="id">Id:</label>
        <input type="text" name="id" />
    </div>
    <div>
        <label for="isbn">Isbn:</label>
        <input type="text" name="isbn" />
    </div>
    <div>
 		 <label for="titulo">Titulo:</label>
        <input type="text" name="titulo" />
    </div>
     <div>
 		 <label for="editorial">Editorial:</label>
        <input type="text" name="editorial" />
    </div>
    <div>
		<div><input type="radio" name="tipo" value="prestado"> Prestado</div>
		<div><input type="radio" name="tipo" value="noprestado"> No Prestado</div>
	</div>
    <div>
    <input type="submit" value="Enviar Formulario" />
    </div>
</form>






</body>
</html>