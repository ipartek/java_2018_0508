<!-- pies o metros 
comprobar usuario escriba algo inadecuado vacio,algo k no es numero,
 -->
<html lang="es">
<head>
<meta charset="utf-8">
<title>Ahorcado</title>
<meta name="description" content="Juegos del Ahorcado">
<meta name="author" content="Rakel Pastor Villarroel">

<link rel="stylesheet" href="css/styles.css?v=1.0">
</head>
<body>
	<h1>JUEGO DEL CONVERSOR</h1>


	<div class="form1">
		<h3>- Pies a Metros -</h3>

		<form action="conversor" method="post">
			<input name="formulario" type="hidden" value="1"><br> <label>Pies : </label>
			<input name="pies" type="text" placeholder="${ParamIntroPies}"><br>
			<br> <label>Metros : ${resultado1} </label></br>
			<br> <input type="submit" value="convertir"/>
		</form>
	</div>
	
	<div class="form2">
	<h3>- Metros a Pies -</h3>
		<form action="conversor" method="post" >
			<input name="formulario" type="hidden" value="2"><br> <label>Metros : </label>
			<input name="metros" type="text" placeholder="${ParamIntroMetros}"><br>
			<br> <label>Pies : ${resultado2}</label><br>
			<br> <input type="submit" value="convertir"/>

			<p class="text-danger">${msg}</p>
		</form>
	</div>
	<script src="js/scripts.js"></script>
</body>
</html>
