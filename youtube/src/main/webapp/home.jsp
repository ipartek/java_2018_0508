<!DOCTYPE html>
<%@page import="com.ipartek.formacion.youtube.pojo.VideoYoutubePOJO"%>
<%@page import="java.util.ArrayList"%>
<html lang="es">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Youtube App</title>
    
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-item.css" rel="stylesheet">
    
    <!-- Font Awsome core CSS -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

  </head>

  <body>
  
  <div class="alert ${claseAlert}" role="alert">
  ${msg}
 </div>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse float-right" id="navbarResponsive">
         <form action="" method="post" >
  			<div class="row pull-right">
    			<div class="col">
     				<input type="text" name="id" class="form-control " placeholder="ID">
    			</div>
    			<div class="col">
      				<input type="text" name="titulo" class="form-control" placeholder="Título">
    			</div>
    			<div class="col">
    				<button type="submit" class="btn btn-info">Add</button>
    			</div>
  			</div>
		</form>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">
          <h1 class="my-4">Lista de Reproducción</h1>
          <div class="list-group">
          
          <%
          
          ArrayList<VideoYoutubePOJO> videos = (ArrayList<VideoYoutubePOJO>) request.getAttribute("videos");
    		
          if (videos.isEmpty()) {
        	  
        	  VideoYoutubePOJO vSeleccionado = new VideoYoutubePOJO();
        	  
          } 
          for( VideoYoutubePOJO video: videos) {
           
          %>
          

          
          <a href="?id=<%= video.getId() %>" class="list-group-item "><%= video.getTitulo() %></a>
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
           <iframe width="100%" height="500px" src="https://www.youtube.com/embed/${vSeleccionado.id}?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            <div class="card-body">
              <h3 class="card-title">${vSeleccionado.titulo}</h3>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->

          <div class="card card-outline-secondary my-4">
            <div class="card-header">
              Comentarios
            </div>
            <div class="card-body">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
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
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script>
    	
    	function reproducir(id) {
    		
    			
    	
    	}
    	
    	
    </script>

  </body>

</html>
