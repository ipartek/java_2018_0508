<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Ahorcado</title>
<meta name="description"
	content="App web Java 3.0 para gestionar préstamos de libros">
<meta name="author" content="Luis">

<link rel="stylesheet" href="css/ahorcadostyle.css?v=1.0">

</head>

<body>

	<article>
	<h1> Bienvenido al juego del ahorcado </h1>
	<p> <b> INSTRUCCIONES </b></p>
	<ol>
	<li> Se te permiten 7 <b>fallos</b> para adivinar la palabra. </li>
	<li> Debes introducir <b>letras</b> para tratar de adivinar la palabra escondida.</li>
	<li> Si la letra se encuentra en la palabra, automáticamente se mostrarán <b>TODAS</b> las que haya. </li>
	<li> Los <b>espacios</b> en blanco no se tienen en cuenta, por lo que se revelan desde el principio. </li>
	<li> Si crees que sabes la palabra, puedes usar el segundo área de texto para intentar adivinarla.</li>
	<li> Si tratas de adivinar la palabra y fallas, <b>pierdes.</b> </li>
	<li><b>ATENCIÓN:</b> Si introduces una letra y una respuesta a la vez, se dará prioridad a la solución propuesta.</li>
	</ol>	
	</article>
	<form action="jugar-ahorcado" method="post">
		<input name="letra" class="texto" type="text" placeholder="Escribe aquí una letra."> <br/>
		<input name="intento" class="texto" type="text" placeholder="Escribe aquí una solución."> <br/>	
		<input type="submit"  name="operacion" value="Enviar">
		<input type="submit" name="operacion" value="Ver">
		<input type="submit" name="operacion" value="Reiniciar">
	</form>
	<label class ="text-danger">${msg}</label>
	<h2> La palabra es: ${solucion} </h2>
	<div class="fallo${fallos}"></div>
	<label class="texto"> Aciertos: <b>${charAcertados}</b> (${aciertos} / ${intentos})</label>
	<label class="texto">Fallos: <b>${charFallados}</b> (${fallos} / ${intentos}</label>
	<script src="js/scripts.js"></script>

</body>
</html>