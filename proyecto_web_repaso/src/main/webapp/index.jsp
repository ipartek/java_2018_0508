<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="includes/header.jsp"%>

	<header class="shadow-sm p-3 mb-5 rounded">
	
		<div class="container">
			<h1 class="text-center">Hello, world!</h1>
		</div>

	</header>
	
	<main class="container">
	
		<%@include file="includes/alert.jsp"%>
		
		<div class="card">
			<div class="card-header bg-primary text-white">
				<span>Repaso Servlet o Controlador</span>
			</div>
			<div class="card-body">
				<h2>Repaso Servlet o Controlador</h2>
				<p>Vamos a enviar datos por GET y POST</p>
				<p>El mapping del controlador es <b>flujo-clasico:</b> JSP -> Servlet -> JSP</p>
				<p>JSP -> Servlet Se envían <b>parámetros</b> || Servlet -> JSP <b>atributos</b></p>
			  	
			  	<hr>
			  	
			  	<p>El servlet va a recibir dos parámetros <b>p1</b> y <b>p2</b> los sumará y lo 
			  	envía como atributo <b>suma</b> a resultado.jsp</p>
			  	
			  	<hr>
	  	
				<div class="row">
					<div class="col-6 text-center">
						<h3>Petición GET</h3>
						<p>En las peticiones GET se envían los parámetros en la URL.</p>
						<pre><code>/flujo-clasico?op1=5&op2=13</code></pre>
						
						<div>
							<a href="flujo-clasico?op1=5&op2=13" class="btn btn-block btn-outline-success">Petición Correcta</a>
							<a href="flujo-clasico?op2=13" class="btn btn-block btn-outline-danger">Petición sin un parámetro</a>
							<a href="flujo-clasico?op1=a&op2=13" class="btn btn-block btn-outline-warning mb-4">Petición con una letra</a>
						</div>
						
					</div>
					<div class="col-6 text-center">
						<h3>Petición POST</h3>
						<p>En las peticiones POST se envían los parámetros a través de un
						formulario.</p>
						<form action="flujo-clasico" method="post">
							<div class="form-row">
						    	<div class="col">
						      		<input autofocus required type="number" name="op1" step="1" class="form-control" placeholder="Primer valor">
						    	</div>
						    	<div class="col">
						      		<input required type="number" name="op2" step="1" class="form-control" placeholder="Segundo valor">
						    	</div>
							</div>
							<div class="form-row mt-3">
								<div class="col">
									<input type="submit" class="btn btn-block btn-outline-primary" value="Enviar">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<hr>
		
		<div class="card mb-4 ">
			<div class="card-header bg-primary text-white">
				<span>Crear videojuego</span>
			</div>
			<div class="card-body">
			
				<%@include file="includes/alert.jsp"%>
				
				<form action="videojuego" method="post">
					<div class="form-group row">
					    <label for="titulo" class="col-sm-2 col-form-label">Título</label>
					    <div class="col-sm-10">
					    	<input required type="text" class="form-control" name="titulo" placeholder="Mínimo 2 y máximo 150 caracteres" maxlength="150" minlength="2">
				    	</div>
					</div>
					<div class="form-group row">
				    	<label for="fecha_lanzamiento" class="col-sm-2 col-form-label">Fecha Lanzamiento</label>
				    	<div class="col-sm-10">
				      		<input required type="date" class="form-control" name="fecha_lanzamiento">
				    	</div>
					</div>
					<input type="submit" class="btn btn-outline-primary" value="Crear">
				</form>
			</div>
		</div>
	  	
	</main>
	
	<%@include file="includes/footer.jsp"%>