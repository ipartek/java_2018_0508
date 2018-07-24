<!doctype html>

<html lang="es">
	<head>
	<meta charset="utf-8">
		<title>Jugando con CSS</title>		
		
		<style>
			/*	NOS TOMAMOS LA LICENCIA  PORQUE ES UN EJEMPLO
				PERO NO ESTA BIEN VISTO TENER ESTILO EN LINEA
			*/
			p {
				color:blue;
			  }
		
			.rojo{
				color:red;			
			}
			
			.verde{
				color:green !important;
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
				transition-duration:2s;
				border-radius:50%;
			}			
			
			@keyframes mymove {
			    from {top: 0px;}
			    to {top: 200px; background-color: blue;
    		}
}
				
		</style>
		
	</head>
		
	<body>
		<h1>Jugando con CSS</h1>		
		<p>Verde</p>
		<p id="rosa" class="verde rojo">Rojo</p>
		<p>Azul</p>
		
		<div class="box">
		
		
		
		</div>
		
	</body>
</html>