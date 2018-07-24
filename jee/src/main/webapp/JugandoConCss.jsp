<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Gestion Libros</title>
	<style>
		/*
			Nos tomamos la licencia porque es un ejemplo
			pero no esta bien visto tener esilos en linea
		*/
		
		p{color:blue;}
		.rojo{color:red:}
		.verde{color:green  !important;}
		#rosa{color:pink;}
		
		.box{
			background-color:teal;
			width:100px;
			height:100px;
			display:inline-block;
			
		}
		
		.box:hover{
			background-color:red;
			transition-duration:3s;
			border-radius:50%;			
		}
		
		
	</style>
</head>
<body>
	<h1>Jugando con CSS</h1>
	
	<p>VERDE</p>
	<p id="rosa" class="rojo verde">ROJO</p>
	<p>AZUL</p>
	
	<div class="box"></div>
</body>
</html>

