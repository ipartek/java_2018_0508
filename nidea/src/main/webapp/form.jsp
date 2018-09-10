<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="includes/header.jsp" %> --%>
<%-- <%@ include file="includes/navbar.jsp" %> --%>


<!DOCTYPE html>
<html>
<head>
        <title>Formulario de Contacto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
       <link rel="stylesheet" type="text/css" href="css/form.css">
       <link rel="stylesheet" type="text/css" href="css/styles.css">

       
    </head>
<body>

	<div container="">
		<h1>Formulario web</h1>
		<!--fieldset crea como una caja con borde-->
		<fieldset>
			<legend>Detalles de contacto</legend>
			<form action="alumnoControler">
				
				<label for="nombre">Nombre:</label> 
		        <input type="text" autofocus placeholder="Escribe tu nombre" name="nombre" required="required" pattern="[a-zA-Z\s]{5,}"/>
		        <span class="invalid">*El nombre es requerido</span>

		        <label for="email">Email:</label>
		        <input type="email" name="email" required="required" placeholder="Introduce tu email"/>
		        <span class="invalid" > El email es requerido</span>

		        <!-- <label for="telefono">Telefono:</label>
		        <input type="tel" name="telefono" required="required" placeholder="Introduce tu telefono" pattern="[1-9]{9,}"/>
		        <span class="invalid" > El telefono es requerido</span>

		        <label for="pais">Pais:</label>
		        <input type="tel" name="pais" list="paises" placeholder="Introduce tu pais" "/>
		        <span class="invalid" > El pais es requerido</span>
		        <datalist id="paises">
		        	<option>España</option>
		        	<option>Francia</option>
		        </datalist>

		        <label for="edad">Edad:</label>
		        <input type="number" name="edad" min="18" max="65">

	         	<label for="nacimiento">Fecha de nacimiento:</label>
		        <input type="date" name="nacimiento" min="1900-01-01" max="3000-12-31"/> -->

		        <div>
		        	<input type="submit" value="Enviar" id="enviar"/>
		        </div>
		       

			</form>
		</fieldset>
	</div>

</body>
</html>