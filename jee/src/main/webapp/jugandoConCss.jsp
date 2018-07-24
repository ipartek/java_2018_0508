<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

	<style>
		<!--Nos tomamos la licencia por que es un ejemplo , pero esta bien visto tener estilos en linea-->
		p {
			color:blue;
		}
		.rojo{
			color:red;
		}
		.verde{
			color:green;
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
		.box:hover {
			background-color: red;

			transition-duration: 2s;
			border-radius: 50%;	
		}
		
	</style>
<title>Jugando con css</title>

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>Jugando con CSS</h1>
	<p class="verde">verde</p>
	<p id="rosa"class="rojo" >rojo</p>
	<p >azul</p>

	<div class="box"></div>
</body>
</html>