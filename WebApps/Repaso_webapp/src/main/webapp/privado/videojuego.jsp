<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- HEADER STARTS HERE -->
<%@ include file="../include/header.jsp" %>


<div class="container">

	<%@ include file="../include/alert.jsp" %>
	
	<div class="row bg-primary">
		<div class="col"><h1 class="text-center">BBDD Videojuegos</h1></div>
	</div>
	
	<div class="row">
	  <div class="col">
	  	
	  	<form action="videojuego" method="post">
	  	
	  		<div class="form-group">
			    <label for="titulo">Titulo</label>
			    <input type="text" class="form-control" id="titulo" name="titulo" placeholder="De 2 a 150 caracteres." min="2" max="150" required>
			</div>
			
			<div class="form-group">
			    <label for="fLanzamiento">Fecha de Lanzamiento</label>
			    <input type="date" class="form-control" id="fLanzamiento" name="fLanzamiento" required>
			</div>
			
			<input type="submit" value="Crear" class="btn btn-block btn-primary"/>
	  		
	  	</form>
	  </div>
	 
		<div class="col">
		
			<div class="form-group">
			  <label for="detalle">Detalle:</label>
			  <textarea class="form-control" rows="5" id="detalle">
			  
			  	Creado: ${ creado }.
			  	Titulo: ${  juego.titulo }
				Fecha de Lanzamiento: ${  juego.fechaLanzamiento }
			  
			  </textarea>
			</div>
	
		</div>
	 </div>	<!-- /.row -->
	 
	 <div class="row">
	 
	 	<ul class="list-group">
			<c:forEach items="${ coleccion }" var="j">
	 	
		  		<li class="list-group-item">${ j.titulo }</li>
		  
		  	</c:forEach>
		</ul>
		
	 
	 
	 </div>	<!-- ./row -->

</div> <!-- ./container -->

