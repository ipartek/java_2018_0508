<!doctype html>

<%@page
	import="com.ipartek.formacion.gestor.libros.controller.ConversorController"%>

<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
<br>
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
	</table>

<%@ include file="includes/footer.jsp" %>