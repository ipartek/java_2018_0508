<!doctype html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<title>Gestion libros</title>	
		
			<style>
				/* 
				    Nos tomamos la licenci porque es un ejemplo
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
					transition-duration: 2s;
					border-radius: 50%;
				}
				
				
			@-webkit-keyframes sploosh {
  0% {
    box-shadow: 0 0 0 0px rgba(71, 225, 141, .7);
    background: rgba(71, 225, 141, .7);
  }
  80% {
    background: rgba(66, 166, 223, 0);
  }
  100% {
    box-shadow: 0 0 0 120px rgba(66, 166, 223, 0);
  }
}

@-webkit-keyframes pulse {
  0% {
    -webkit-transform: scale(1);
  }
  3.3% {
    -webkit-transform: scale(1.1);
  }
  16.5% {
    -webkit-transform: scale(1);
  }
  33% {
    -webkit-transform: scale(1.1);
  }
  100% {
    -webkit-transform: scale(1);
  }
}

.relative {
  position: relative;
  margin: 50vh auto;
  width: 60px;
}

.span {
  position: absolute;
  top: 0;
  left: 0;
  border: 0;
 
  width: 60px;
  height: 60px;
  border-radius: 50%;
  
  -webkit-animation: sploosh 2s cubic-bezier(0.165, 0.84, 0.44, 1);
  -webkit-animation-iteration-count: infinite;
}

.span:nth-child(2) {
  -webkit-animation-delay: .33s;
  -webkit-animation-duration: 2.2s;
}


button {
  border: 0;
  margin: 50vh auto;
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: block;
  background-color: rgba(71, 225, 141, 1);
  
  -webkit-animation: pulse 2s ease-out;
  -webkit-animation-iteration-count: infinite;
}
		
			</style>
		
	</head>
	
	<body>
		<h1>Jugando con CSS</h1>
		
		<div class="relative">
		  <button></button>
		  <div class="span"></div>
		  <div class="span"></div>
		</div>
		
		
		<p>VERDE</p>
		<p id="rosa" class="verde rojo">ROJO</p>
		<p>AZUL</p>
		
		
		<div class="box"></div>
		
		
		
		

	</body>
</html>