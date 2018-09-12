<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>


 <main role="main" class="container">

        	<h1 class="text-center">Listado de Productos</h1>
  
   
      
      <div class="row justify-content-center">
      
      
      <% for(int i = 0; i < 7; i++){ %>
      
      
      <!-- Producto 1 -->
  		<div class="col-sm-3 mb-5">
	      <div class="card h-100">
	  			<img class="card-img-top" src="https://www.elmueble.com/medio/2018/05/24/00469084_7b784b56_700x700.jpg" alt="imagen del sistema grid">
	  			
	  			<div class="card-body">
		    		<div class="row">
								  		<div class="col">
								  			<h5 class="card-title text-primary text-uppercase font-weight-bold">Producto</h5>
								  			<h6 class="card-title text-info">Codigo</h6>
								  		</div>
								  		<div class="col text-right"><h5 class="card-title text-info font-weight-light font-italic">Precio  &euro; </h5></div>
								  	</div>
	  			</div>
	  		
		 </div>
		</div>
		
		<% } %>

	 </div><!-- fin row -->
	 
</main>

<%@ include file="includes/footer.jsp" %>