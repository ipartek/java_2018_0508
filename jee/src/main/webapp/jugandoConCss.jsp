<!doctype html>

<html lang="es">
	<head>
	<meta charset="utf-8">
		<title>Jugando con CSS</title>
		<meta name="description" content="App web Java 3.0 para gestionar Prestamos de Libros">
		<meta name="author" content="Alain Muñoz Arrizabalaga">
		
		<link rel="stylesheet" href="css/styles.css?v=1.1">
		
		<style>
			/*
				Nos tomamos la licencia porque es un ejemplo
				Pero no esta bien visto tener ESTILOS EN LINEA
			*/
			
			p{
				color: blue;
			}
			
			.rojo{
				color: red;
			}
			
			.verde{
				color: green !important;
			}
			
			#rosa{
				color: pink !important;
			}
			
			.box{
				background-color: teal;
				width: 100px;
				height: 100px;
				display: inline-block;
			}
			
			.box:hover{
				background-color: lime;
				transition-duration: 2s;
				border-radius: 50%;
			}
			
			@keyframes pulse{
				0%{}
				25%{}
				50%{}
				100%{}
			}
		</style>
	</head>
	
	<body>
		<%@ include file="includes/navbar.jsp" %>
		
		<h1>Jugando con CSS</h1>
		
		<p>VERDE</p>
		<p id="rosa" class="verde rojo">ROJO</p>
		<p>AZUL</p>
		
		<div class="box"></div>
		
	</body>
</html>