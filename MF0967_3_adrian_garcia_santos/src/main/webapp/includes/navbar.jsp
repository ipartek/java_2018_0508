<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4 menu">
		<a class="navbar-brand" href="home"><img src="images/logo.png" class="logo" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto justify-content-between">
				<li class="nav-item active"><a class="nav-link inicio" href="home">Inicio</a></li>
				<li>
					<form>
					
					</form>
				</li>
				<li class="nav-item"><a href="${(empty sessionScope.usuario)? 'login.jsp' : 'logout'}" class="btn btn-success login">${(empty sessionScope.usuario)? 'Iniciar sesión' : 'Cerrar sesión'}</a></li>
			</ul>
		</div>
	</nav>