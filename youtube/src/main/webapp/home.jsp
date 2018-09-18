<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Alert"%>
<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Video"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>

	<!-- Cabecera -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container">
				<a class="navbar-brand" href="#">Youtube PlayList</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive"
				 aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto  align-items-center">
						<%
	              	//Gestion de usuario logueado
	              	
	              	session = request.getSession();
	              	Usuario u = (Usuario)session.getAttribute("usuario");
	              	if(u == null){
	              		%>
						<li class="nav-item active">
							<!-- Formulario de login -->
							<form action="login" method="post" class="form-inline mt-2 mt-md-0">
								<input name="usuario" class="form-control mr-sm-2" type="text" placeholder="Nombre de usuario" required pattern=".{3,30}">
								<input name="pass" class="form-control mr-sm-2" type="password" placeholder="Contraseña" required pattern=".{2,50}">
								<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Entrar</button>
							</form>
						</li>
						<%
	              	}
	              	else{
	              		
	              		%>
						<li class="nav-item">
							<div class="text-light text-right m-1">
								Bienvenido <i class="fas fa-user-circle"></i>
								<%=u.getNombre() %>
								<a href="logout">Cerrar Sesion</a>
							</div>
						</li>
						<li class="nav-item active">
							<!-- Formulario para dar de alta un nuevo video -->
							<form action="inicio" method="post" class="form-inline">
								<input name="id" class="form-control m-1" type="text" placeholder="ID 11 caracerteres" title="11 caracteres"
								 required pattern=".{11,11}">
								<input name="nombre" class="form-control m-1" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
								<button class="btn btn-outline-info m-1" type="submit">Añadir</button>
							</form>
						</li>
						<%              		
	              	}
	              %>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	
	<!-- Contenido -->
	<main class="container" role="main">
	
		<%
	    	//Gestion de alertas para el usuario
	    	Alert alert = (Alert)request.getAttribute("alert");
	    	if(alert == null){
	    		alert=(Alert)session.getAttribute("alert");
	    		session.setAttribute("alert",null);
	    	}
	    	if (alert != null){
	    		%>
		<div class="container">
			<div class="alert alert-<%=alert.getTipo() %> alert-dismissible fade show" role="alert">
				<strong>
					<%=alert.getTexto() %></strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
		<%
	    	}
	    %>
		<h1 class="text-center text-success">Youtube Java Edition</h1>
		<div class="row pt-4">
			<div class="col-lg-4">
				<section>
					<h1 class="text-primary">Lista Reproduccion</h1>
					<ul class="list-group">
						<%
		          		ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
		          		if ( videos == null ){
		          			videos = new ArrayList<Video>();
		          		}
		          		
		          		Video videoInicio = (Video)request.getAttribute("videoInicio");
		          		if ( videoInicio == null){
		          			videoInicio = new Video();
		          		}
		    			
		          		for( Video v : videos ){
		          	%>
						<li class="list-group-item d-flex justify-content-between align-items-center">
							<a href="inicio?id=<%=v.getId()%>">
								<%=v.getNombre()%></a>
							<a href="inicio?id=<%=v.getId()%>&op=<%=HomeController.OP_ELIMINAR%>"><i class="fas fa-trash-alt text-danger"></i></a>
						</li>
						<%
		          		} //end for
		            %>
					</ul>
				</section>
				<section>
					<h2>Lista del Usuario</h2>
					<%
	          		if(u != null){
	          			%>
						<ul class="list-group">
						<%
	          				ArrayList<Video> listaVideos = (ArrayList<Video>)session.getAttribute("videosUsuario");
							if(listaVideos != null){
		          				for( Video v : listaVideos ){
		          			    %>
									<li class="list-group-item d-flex justify-content-between align-items-center">
										<a href="inicio?id=<%=v.getId()%>"><%=v.getNombre()%></a>
									</li>
								<%
		          			    	}
							}
	          				%>
						</ul>
					<%
	          		}else{
	          			%>
						<a href="#">Accede con tu usuario</a>
						<%
	          			}
	          		%>
				</section>
			</div>
			<div class="col-lg-8">
	
				<div class="card">
					<div class="container">
						<iframe id="iframe" src="https://www.youtube.com/embed/<%=videoInicio.getId()%>?autoplay=0"
					 frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
					</div>
					<div class="card-body">
						<h3 class="card-title">
							<%=videoInicio.getNombre()%>
						</h3>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic
							aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis
							molestias iure, ducimus!</p>
						<span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
						4.0 stars
					</div>
				</div>
				<!-- /.card -->
	
				<div class="card card-outline-secondary">
					<div class="card-header">
						Comentarios
					</div>
					<div class="card-body">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique
							necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia,
							necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique
							necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia,
							necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique
							necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia,
							necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
	
					</div>
				</div>
				<!-- /.card -->
	
			</div>
	
		</div>
		<!-- /row -->
	</main>
	<!-- /.container -->
	
	<!-- Footer -->
	<footer class="bg-dark p-3">
		<p class="text-center text-white">Copyright &copy; Adrian Perozzo</p>
	</footer>

<%@ include file="includes/footer.jsp" %>