<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>


 <main role="main" class="container">
      
        <h1>Listado de productos</h1>                
        
      <div class="row">
  		<div class="col-3">
		     	      	<div class="card h-100 m-1">
		     	      		<img class="card-img-top " src="https://lamenteesmaravillosa.com/wp-content/uploads/2016/11/Sheldons_brain.jpg"  alt="imagen del producto">
		     	  			<div class="card-body">					    
				    
							    <div class="col" text-left>
							    	<h5 class="card-title text-dark text-uppercase text-justify">Nombre</h5>					  		
							    </div>
							    <div class="col text-right">
					    			<h6 class="badge badge-pill badge-success">Precio &#8364;</h6>
				  				</div>
							  	
							  	<div class="col text-center">
								   <h5 class="card-title font-weight-light text-justify text-secondary">Ref Producto</h5>
							  	</div>
							  	<p class="card-text font-italic text-muted text-justify">Descripcion</p>
							  	
						  </div>
		     	  			<div class="card-footer">
		     	  				<a href="grid.jsp" class="btn btn-outline-primary btn-lg btn-block">Ver ejemplo</a>
		     	  			</div>
		     		 </div>
	     		 </div>
	      		
	      		<!-- Listado de 10 cards -->
	      		<%
	      		for(int i=0;i<8;i++){
	      		%>	 
	      			
	      		<% }%>
	      		
		 
	 </div><!-- fin row -->
	 
	 
	 
</main>
<%@ include file="includes/footer.jsp" %>
