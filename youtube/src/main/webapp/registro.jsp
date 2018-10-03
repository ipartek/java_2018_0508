<%@ include file="includes/header.jsp" %>	
    
    <!-- Page Content -->
    <div class="container">
    	
      <%@ include file="includes/nav.jsp"  %>
      <%@ include file="includes/alert.jsp"  %>	
      	
      <div class="row justify-content-center">
      
      	<div class="col-6">	
      		<h1>Date de alta como Usuario</h1>
      		
      		<form method="post" action="registro">
      		 	<div class="form-group">
	      			<input type="text" name="nombre" class="form-control" placeholder="Dime Tu nombre,min 3 maximo 50 letras" required autofocus pattern="{3,50}">
	      		</div>
	      		<div class="form-group">
	      			<input type="password" name="password" class="form-control" placeholder="Contraseña, minimo 8" required pattern="{8,20}">
	      		</div>
	      		<div class="form-group">
	      			<input type="password" name="repassword" class="form-control" placeholder="repite de nuevo Contraseña por favor" required pattern="{8,20}">
	      		</div>
	      		<div class="form-group">
	      			<input type="submit" value="Crear Usuario" class="btn btn-primary">
      			</div>
      		</form>
      	</div>
      
      </div><!-- .row -->
      

    </div>
    <!-- /.container -->

 <%@ include file="includes/footer.jsp" %> 