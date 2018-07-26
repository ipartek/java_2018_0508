
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>
<br>
<form action="listado" method="post">
	<table>
		<tr>
			<td><label for="isbn"><b>ISBN</b></label> </td>
			<td><label for="titulo"> <b>Título</b></label> </td>
			<td><label for="editorial"> <b>Editorial</b></label> </td>
			<td><label for="prestado"> <b>Prestado</b></label> </td>
		</tr>
		<tr>
			<td><p style="color: black">${isbn }</p></td>
			<td><p style="color: black">${titulo }</p> </label> </td>
			<td><p style="color: black">${editorial }</p> </label> </td>
			<td><p style="color: black">${prestado }</p> </label> </td>
		</tr>
	</table>
	<p style="color: red">${msg }</p>
</form>
