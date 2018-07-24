<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Gestion Libros</title>
	<meta name="description"
		content="App web Javaa 3.0 paragestionar prestamos de libros">
	<meta name="author" content="SitePoint">
	<style>
		p{
			color:blue;
		}
		
		.rojo{
			color:red;
		}
		p#rosa{
			color:black!important;
		}
		
		#rosa{
			color:pink!important;
		}
		.box{
			background-color: teal;
			width: 100px;
			height: 100px;
			display: inline-block;
			animation-duration: 4s;
			animation-name: pulse;
		
		}
		
		/* Standard syntax */
		@keyframes example {
		    from {background-color: teal;}
		    to {background-color: yellow;}
		}
		
			/* Standard syntax */
		@keyframes pulse {
		    0% {
		   		width: 80px;
		    }
		    
			25% {
				width:60px;
			}
			
			50% {
		   		width:50px;
		    }
		    
			80% {
				width:60px;
			}
			
			100% {
				width:100px;
			}
		}
		
		
	
	</style>
	
	
</head>
<body>

	<p>VERDE</p>
	<p id="rosa" class="rojo">ROJO</p>
	<p>AZUL</p>
	
	<div class="box">BOX</div>


	<script src="js/jquery.js"></script>
</body>
</html>