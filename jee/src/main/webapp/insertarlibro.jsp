<%@ include file="includes/header.jsp"%>

<h1>INSERTAR UN NUEVO LIBRO</h1>

<form action="insertarlibro" method="post">
	<label for="titulo">Título:</label> 
	<input name="titulo" type="text" autofocus placeholder="Introduce el título" value="${titulo}" required> 
	<br />
	<br /> 
	<label for="isbn">ISBN: </label> 
	<input id="isbn" name="isbn" type="text" placeholder="Introduce el ISBN" value="${isbn}" required pattern="^[A-Za-z0-9_]{5,25}$">
	<br /> 
	<br /> 
	<label for="editorial">Editorial: </label> 
	<input id="editorial" name="editorial" type="text" placeholder="Introduce la editorial" value="${editorial}" required> 
	<br />
	<br /> 
	<label for="prestado">El libro está: </label>
	<input id="noPrestado" name="prestado" type="radio" value="false" checked="checked"> No Prestado
	<input id="prestado" name="prestado" type="radio" value="true" > Prestado
	<br />
	<br /> 
	<input type="submit" value="Enviar">
	<p class="text-danger">${msg}</p>
</form>

<%@ include file ="includes/footer.jsp" %>