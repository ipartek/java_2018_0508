<!DOCTYPE html>
<%@page import="com.adriana.prado.pojo.Usuario"%>
<%@page import="com.adriana.prado.pojo.Alert"%>
<%@page import="com.adriana.prado.controller.HomeController"%>
<%@page import="com.adriana.prado.pojo.Video"%>
<%@page import="java.util.ArrayList"%>
<html lang="es">

<head>

<!-- Comienza todas las URLs desde el href indicado -->
<base href="<%=request.getContextPath()%>/">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="videos youtube">
<meta name="author" content="Adriana">

<link rel="stylesheet" href="css/500.css">

<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<body>
<div class="container">
  <div class="row">
    <div class="span12">
      <div class="hero-unit center">
          <h1>Error interno del servidor <small><font face="Tahoma" color="red">Error 500</font></small></h1>
          <br />
          <p>El servidor ha detectado un error inesperado que le impide acceder a esta página. Usa el botón <b>Volver</b> de tu navegador para regresar a la página anterior.</p>
          <p>Si el error persiste, <a href="mailto:example@example.com"> contacte con nuestros técnicos de soporte</a>.</p>
          <p><b>O puedes volver a la página principal pulsando el siguiente botón:</b></p>
          
          <a href="#" class="btn btn-large btn-info"><i class="icon-home icon-white"></i> Volver a la página principal</a>
        </div>
    </div>
  </div>
</div>
</body>

</html>