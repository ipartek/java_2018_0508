<!doctype html>

<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Gestion_libros</title>
	
	<style>
		/* Nos tomamos la licenci por que es un ejemplo 
		pero no esta bien visto tener estilos en linea
		*/
		p{
			color: blue;
		}
		
		.rojo{
			color : red;
		}
		
		.verde{
			color : green;
		}
		#rosa{
			color:pink;
		}
		.box{
			background-color: teal;
			width: 100px;
			height: 100px;
			display: inline-block;
		}
		.box:hover{
			background-color: red;
			transition-duration : 2s;
			border-radius:50%;
		}
		@keyframes pulse {
		    from {top: 0px;}
		    to {top: 200px;}
		}	
	</style>

</head>
<body>

	<h1> Jugando con Css </h1>
	
	<p>Verde</p>
	<p id ="rosa" class="verde rojo">Rojo</p>
	<p>Azul</p>
	
	<div class="box"></div>
	
	

</body>
</html>