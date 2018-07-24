<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Jugando con CSS</title>	
	
	<style>
		/* 
			Nos tomamos la licencia porque es un ejemplo
			pero no está bien visto tener estilos en linea.
		 */
		 
		 p{
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
		 	background-color:teal;
		 	height:100px;
		 	width:100px;
		 	display:inline-block;	
		 	 animation: pulse 5s infinite;	 
		 }
		 
		 .box:hover{
		 	background-color:red;
		 	border-radius:50%;
		 	transition-duration:2s;
		 }
		 
		 @keyframes pulse{
		 	0%{
		 		background-color:teal;
		 		border-radius:0px;
		 	}
		 	
		 	50%{
		 		background-color:red;
		 		border-radius:50%;
		 	}
		 	
		 	100%{
		 		background-color:teal;
		 		border-radius:0px;
		 	}
		 }
	
	</style>
	
</head>
	
<body>

	<h1>Jugando con CSS</h1>
	
	<p>VERDE</p>
	<p id="rosa" class="verde rojo">ROJO</p>
	<p>AZUL</p>
	
	<div class="box">
		
		
		
	</div>
		
</body>
</html>