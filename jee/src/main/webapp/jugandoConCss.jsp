<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

	<title>CSS Avanzado</title>
	<meta name="author" content="Luis">

	
	<style>
		
		/*Nos tomamos la licencia para ver más claro el ejemplo, pero no está bien visto tener
		ESTILOS EN LÍNEA.*/
		
		p {
			color: blue;
		}
		
		.rojo {
			color: red;
		}
		
		.verde {
			color: green;
		}
		
		.box {
			
			background-color: teal;
			width: 100px;
			height: 100px;
			display: inline-block;
			
		}
		
		.box:hover {
			background-color: red;
			transition-duration: 1s;
			border-radius: 10%;
	
		}
		
		
		#rosa {
			color:	pink;
		}
	
	
	</style>

</head>

<body>

	<h1>Jugando con CSS Avanzado</h1>
	
	<p class="verde">Verde</p>
	<p class="rojo">Rojo</p>
	<p>Azul</p>
	
	<div class="box">
	
	</div>
	
	
	

</body>
</html>