<%@page import="com.ipartek.formacion.youtube.Video"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Youtube Video Play List</title>
    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

    <!-- Bootstrap core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://blackrockdigital.github.io/startbootstrap-shop-item/css/shop-item.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Youtube PlayList</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <form class="form-inline mt-2 mt-md-0" action="" method="post">
	            <input class="form-control mr-sm-2" name="id" type="text" placeholder="ID 11 caracteres" title="11 caracteres" required pattern=".{11,11}">
	            <input class="form-control mr-sm-2" name="titulo" type="text" placeholder="Nombre minimo 2 caracteres" required pattern=".{2,125}">
	            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
	          </form>
            </li>            
          </ul>
          
          
          
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">        	
          <h1 class="my-4">Lista Reproduccion</h1>
          <div class="list-group">
          	<%
          		ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
          		Video videoInicio = new Video();
          		if(!videos.isEmpty()){
          			videoInicio = videos.get(0); 
    			}
          		for( Video v : videos ){
          	%>
                   
          	  <a href="#" onclick="reproducir('<%=v.getId()%>', '<%=v.getNombre()%>')" class="list-group-item"><%=v.getNombre()%></a>
          	  <a href="?id=<%=v.getId()%>" style="color: red;"class="fas fa-trash-alt"></a>
            
            <%
          		} //end for
            %>
            
            
          </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="card mt-4">
          
            <iframe id="iframe" width="823" height="415" src="https://www.youtube.com/embed/<%=videoInicio.getId()%>" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            
            <div class="card-body">
              <h3 id="tituloCancion" class="card-title"><%=videoInicio.getNombre()%></h3>              
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
    	function reproducir(id, nombre){
    		console.info('reproducir video ' + id);
    		var iframe = document.getElementById('iframe');
    		var titulo = document.getElementById('tituloCancion');
    		iframe.src = "https://www.youtube.com/embed/" + id;
    		tituloCancion.innerHTML = nombre;
    	}
    </script>

  </body>

</html>
