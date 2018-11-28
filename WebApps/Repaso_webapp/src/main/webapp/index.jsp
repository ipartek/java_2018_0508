<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- HEADER STARTS HERE -->
<%@ include file="include/header.jsp"%>
<header class="titulo"><h1>Repaso MVC</h1></header>

<main class="container">

	<p>El Servlet recibirá 2 <b>parámetros</b> y los sumará, devolviéndolos en forma de respuesta como un <b>atributo.</b></p>
	
	<section class="row">
	    <article class="col-sm">
	    
	      <header>Petición GET</header>
	      <p>En el método GET, los parámetros se envían en la URL de la siguiente forma:</p>
	      
	      <p class="text-center"><pre><code>/suma?op=1&op=2</code></pre></p>
	      
	      <a href="suma?op1=2&op2=3" type="button" class="btn btn-primary">Probar</a>
	      
	    </article>
	    
	    <article class="col-sm">
	      
	      <header>Petición POST</header>
	      
	      <p>En el método POST, los parámetros se envían mediante un formulario de manera que quedan 
	 		 ocultos y menos accesibles para el cliente.</p>
	      
	    </article>

	 </section>
	 
	 <section class="row">
	 	
	 	<div class="col-lg-6">
	 		 <a href="videojuego" class="btn btn-block btn-danger">Videojuegos</a>
	 	</div>
	 	
	 	<div class="col-lg-6">
	 		 <a href="login.jsp" class="btn btn-block btn-success">Login</a>
	 	</div>
	 
	 </section>

</main>
