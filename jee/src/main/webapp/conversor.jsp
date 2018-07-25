<!doctype html>

<%@page
	import="com.ipartek.formacion.gestor.libros.controller.ConversorController"%>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Gestion libros</title>
<meta name="description"
	content="App web Java 3.0 para gestionar Prestamos de Libros">
<meta name="author" content="Ainara Goitia">

<link rel="stylesheet" href="css/styles.css?v=1.1">
</head>

<body>

	<table border=2px>
		<tr>
			<th colspan=2>CONVERSOR</th>
		</tr>
		<tr>
			<td><p id="titulo">CONVERSOR DE METROS A PIES</p></td>
			<td><p id="titulo">CONVERSOR DE PIES A METROS</p></td>
		</tr>
		<tr>
			<td>
				<form action="conversor" method="post">
					Metros: <input name="metros" type="text">
					<p style="color: green">La conversion a pies es:
						${conversormetros }</p>
					<p style="color: red">${msgmetros }</p>
					<p style="color: red">${msg }</p>
					<input type="hidden" name="formulario" value="<%=ConversorController.FORM1%>"> 
					<input id="boton" type="submit" value="Convertir">
				</form>
			</td>
			<td>
				<form action="conversor" method="post">
					Pies: <input name="pies" type="text">
					<p style="color: green">La conversion a metros es:
						${conversorpies }</p>
					<p style="color: red">${msgpies }</p>
					<p style="color: red">${msg }</p>
					<input type="hidden" name="formulario" value="<%=ConversorController.FORM2%>"> 
					<input id="boton" type="submit" value="Convertir">
				</form>
			</td>
		</tr>
		<tr >
			<td colspan=2>
				<form action="http://localhost:8080/gestion-libros/" method="post">
					<input id="boton" type="submit" value="Volver" >
				</form>
			</td>

		</tr>
	</table>


	<br>



</body>
</html>