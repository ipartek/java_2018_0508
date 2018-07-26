<!doctype html>

<html lang="es">
	<head>
		<meta charset="utf-8">
		
		<title>jugandoConCSS</title>
		
		<style>
			/*Nos tomamos la licencia porque es un ejemplo.
			Pero no esta bien visto tener ESTILOS EN LINEA.*/
			
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
				background-color: teal;
				width: 300px;
				height: 300px;
				display: inline-block;
			}
			
			.box:hover{
				background-color: red;	
				transition: 1000ms linear;
				border-radius:50%;
			}
			
		</style>
			
	</head>
	
	<body>
	
		<%@ include file = "includes/navbar.jsp" %>
	
		<h1>Jugando con CSS</h1>

		<p>Verde</p>
		<p id="rosa" class="verde rojo">Rojo</p>
		<p>Azul</p>
		
		<div class="box">
		</div>
	
	<%@ include file = "includes/footer.jsp" %>