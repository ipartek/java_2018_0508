<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">

  <head>

	<!-- Comenza todas las URLs desde el href indicado -->
	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Error 4xx</title>
    <!-- Fontawasome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<link rel="stylesheet" href="css/404.css" >
	

  </head>

 <body>
 <div class="container">
 	<h1 class="destello"><i class="fas fa-exclamation-triangle"></i>Error 404<i class="fas fa-exclamation-triangle"></i></h1>
 	<h2>La solicitud contiene una sintaxis incorrecta o no puede procesarse.</h2>
 	<h3>HTTP 404 Not Found o HTTP 404 No encontrado es un código de estado HTTP que indica que el host no ha sido capaz de comunicarse con el servidor. Este error no debe ser confundido con "servidor web no encontrado" o errores similares en los que se indica que no se ha podido realizar la conexión con el servidor.</h3>
 	<img src="data:image/jpeg;base64,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"/>
 	<p><a href="contacto.jsp">Haznos saber el error</a></p>
 	<p><a href="index.jsp">Volver</a></p>
 </div>
 CAUSA <%=exception.getCause()%><br>
MENSAJE <%=exception.getMessage()%><br>
TOSTRING <%=exception.toString()%><br>
 <textarea cols="20" rows="10">
	<%
		//pinta por pantalla la traza de la excepcion
		exception.printStackTrace(new java.io.PrintWriter(out));
	%>
</textarea> 
 

</body>

</html>