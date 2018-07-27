<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">

<title>Resumen del nuevo libro</title>
<meta name="description"
	content="App web Java 3.0 para gestionar préstamos de libros">
<meta name="author" content="raul">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>

	<h1>Detalle del libro</h1>

	<div align="center">
		<div class="datagrid">
			<table>
				<thead>
					<tr>
						<th>Resumen</th>
						<th> sadasd</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<td colspan="2"><div id="paging">
								
							</div>
					</tr>
				</tfoot>
				<tbody>
					<tr>
						<td>Titulo</td>
						<td>${libroNuevo.titulo }</td>
					</tr>
					<tr class="alt">
						<td>Autor</td>
						<td>${libroNuevo.autor }</td>
					</tr>
					<tr>
						<td>Editorial</td>
						<td>${libroNuevo.editorial }</td>
					</tr>
					<tr class="alt">
						<td>Isbn</td>
						<td>${libroNuevo.isbn }</td>
					</tr>
					
				</tbody>
			</table>
		</div>
	</div>



</body>
</html>