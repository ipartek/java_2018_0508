<!doctype html>

<html lang="es">
<head>
<meta charset="utf-8">
<title>Gestion libros</title>

	<style>
		/*
			Nos tomamos la licencia porque es un ejemplo
			pero no esta bien visto tener estilos en linea
		*/
		p {
			color: blue;
		}
	
		.rojo {
			color: red;
		}
	
		.verde {
			color: green !important;
		}
	
		#rosa {
			color: pink;
		}
	
		.box {
			background-color: teal;
			width: 100px;
			height: 100px;
			display: inline-block;
		}
		.box:hover{
			background-color: red;
			transition-duration: 2s;
			border-radius: 50%;
		}
		@keyframes pulse{
				0%{
				top:0px;
				
				}
				50{top:200px;
				
				}
				
				100{top:50px;
		
			}
		}
</style>

</head>

<body>
	<h1>Jugando con Css</h1>

	<p>VERDE</p>
	<p id="rosa" class="verde rojo">ROJO</p>
	<p>AZUL</p>

	<div class="box"></div>

</body>
</html>