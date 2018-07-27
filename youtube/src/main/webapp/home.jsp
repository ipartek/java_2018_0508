<%@page import="com.ipartek.formacion.youtube.controller.VideoYoutubeController"%>
<%@page import="com.ipartek.formacion.pojo.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Youtube app</title>

<!-- Bootstrap core CSS -->

<link
	href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css"
	rel="stylesheet">

</head>

<body>
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Youtube</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="" id="navbarResponsive" align="right">

				<form class="form-inline">

					<div class="form-group mx-sm-3 mb-2">
						<label for="inputPassword2" class="sr-only">id</label>
						 <input
							type="password" class="form-control" id="inputPassword2"
							placeholder="ID"> <label for="inputPassword2"
							class="sr-only">nombre</label>
							 <input type="password"
							class="form-control" id="inputPassword2" placeholder="NOMBRE">

					</div>
					<button type="submit" class="btn btn-primary mb-2">Anadir</button>
				</form>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">Lista de reproduccion</h1>
				<div class="list-group active">
					
				
				<% 
				ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
		          if (videos.isEmpty()) {
		        	  
		        	  Video vSeleccionado = new Video();
		        	  
		          } 
		          for( Video video: videos) {
		           
		          %>
		          

		          
		          <a href="?id=<%= video.getId() %>" class="list-group-item "><%= video.getNombreCancion() %></a>
		          <div id="iconos" class="text-center">
		          	<i class="text-center fab fa-youtube"></i>
		          	<i class="text-center  fas fa-trash-alt"></i>
		          </div>
		          
		              
		          <% 
		         	 }
		          %>
	            
            
		</div>
         
            
</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="card mt-4">
					<iframe width="560" height="315"
						src="https://www.youtube.com/embed/${video.id }" frameborder="0"
						allow="autoplay; encrypted-media" allowfullscreen></iframe>
					<div class="card-body">
						<h3 class="card-title">Ricky hombre libre(titulo)</h3>
						<!--  <h4>$24.99</h4> -->
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
							facere, soluta. Totam id dolores, sint aperiam sequi pariatur
							praesentium animi perspiciatis molestias iure, ducimus!</p>
						<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
							&#9734;</span> 4.0 stars
					</div>
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header">Product Reviews</div>
					<div class="card-body">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<a href="#" class="btn btn-success">Leave a Review</a>
					</div>
				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2017</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
