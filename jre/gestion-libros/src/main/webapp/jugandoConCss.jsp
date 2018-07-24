<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	<style>
		p{
			color: blue;
		
		}
		
		.rojo{
		
			color: red;
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
		
		.box:hover{
			background-color: red;
			width: 100px;
			height: 100px;
			display: inline-block;
			transition-duration: 2s;
			border-radius: 50%;
			
		}
		
		@keyframes pulse{
			0%{
			 top: 0px;
			}
		
			50%{
				top: 200px;
			}
			
			100%{
			   top:400px;
			}
		}
		
	
	</style>
	
	</head>
<body>
	<h1>Jugando con CSS</h1>
	

	<p >VERDE</p>
	<p class=" verde rojo" id="rosa">ROJO</p>
	<p>AZUL</p>


	<div class="box">
	
	
	
	
	
	</div>


</body>
</html>