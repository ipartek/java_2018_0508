<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <a class="navbar-brand" href="#"><img src="images/Logo_Nikea.png" alt="logo-ikea-mopdificado" /></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="grid.jsp">Grid system</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="components.jsp">Components</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="arkanoid.jsp">Arkanoid</a>
          </li>
          <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">JEE</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="formulario">Formulario</a>
				<a class="dropdown-item" href="fichero.jsp">File</a>
		  </div>
		  </li>
          <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Pantallas</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="login.jsp">Login</a>
				<a class="dropdown-item" href="registro.jsp">Registro</a>
				<a class="dropdown-item" href="formulario">Formulario</a>
				<a class="dropdown-item" href="listado-publico.jsp">Listado público</a>
				<a class="dropdown-item" href="listado-backend.jsp">Listado backend</a>
		  </div>
		  </li>
          <li class="nav-item">
            <a class="nav-link" href="alertas.jsp">Alertas</a>
          </li>
        </ul>
      </div>
    </nav>
    
<%@include file="alert.jsp" %>