<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Gestion Libros</title>

	<style>
		/*
			nos tomamos la licencia porque es un ejemplo
			pero no esta bien visto tener ESTILOS EN LINEA
		*/
		
		p {
			color: blue;
		}
		
		.rojo{
			color:red;
		}
		
		.verde{
			color:green;
		}
		
		.box{
			background-color: teal;
			width: 100px;
			height: 100px;
			display: inline-block;
		}
		
		.box:hover {
			background-color: red;
			transition-duration: 2s;
			border-radius: 50%;
		}
	
	</style>

</head>

<body>

	<h1>Jugando con CSS</h1>

	<p>VERDE</p>
	<p class="rojo">ROJO</p>
	<p class="verde">AZUL</p>
	
	<div class="box"> </div>
	
	
</body>

</html>