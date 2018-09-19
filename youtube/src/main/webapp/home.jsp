<%@page import="com.ipartek.formacion.youtube.pojo.Comentario"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Alert"%>
<%@page import="com.ipartek.formacion.youtube.controller.HomeController"%>
<%@page import="com.ipartek.formacion.youtube.pojo.Video"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>


<%@ include file="includes/navbar.jsp" %>
	
<!-- Contenido -->
<main class="container" role="main">

		<%
	    	//Gestion de alertas para el usuario
	    	Alert alert = (Alert)session.getAttribute("alert");
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
			session.setAttribute("alert", null);
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
	
				<div class="card card-outline-secondary m-2">
					<div class="card-header bg-primary">
						<div class="row align-items-center">
							<div class="col-6">
								<h2>Comentarios</h2>
							</div>
							<div class="col-6 text-right">
								<a href="#form-comentario" class="btn btn-outline-dark">Escribe un comentario</a>
							</div>
						</div>
						
					</div>
					<div class="card-body m-2">
					<%
					session = request.getSession();
					ArrayList<Comentario> listaComentarios = (ArrayList<Comentario>) session.getAttribute("comentario");
					if(listaComentarios != null){
					%>
					<ul class="group-list">
					<%
					for( Comentario c : listaComentarios ){
						%>
						<li class="list-group-item">
							<p class="card-text"><%=c.getTexto()%></p>
							<small class="text-muted">Escrito por  <%=c.getAutor()%></small>
						</li>
						<%
						}
					%>
					</ul>
					<%
					}else{
						%>
						<h4 class="text-danger">Aun no hay ningun comentario...</h4>
					<%
					}
					if(u != null){
					%>
					<form id="form-comentario" action="comentario" method="post">
							<div class="form-group">
							    <label for="comentario-usuario">Escribe tu comentario:</label>
							    <textarea name="comentario-usuario" class="form-control" id="comentario-usuario" rows="3"></textarea>
							  </div>
							  <input type="submit" class="btn btn-outline-success mb-2" value="Enviar comentario">
						</form>
					<%
					}
					%>						
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