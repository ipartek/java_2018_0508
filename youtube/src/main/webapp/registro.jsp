<%@ include file="includes/header.jsp" %>	
    
    <!-- Page Content -->
    <div class="container">
    	
      <%@ include file="includes/nav.jsp"  %>
      <%@ include file="includes/alert.jsp"  %>	
      	
      <div class="row">
      
      		<h1>Date de alta como Usuario</h1>
      		
      		<form method="post" action="registro">
      		
      			<input type="text" name="nombre" placeholder="Dime Tu nombre,min 3 maximo 50 letras" required autofocus pattern="{3,50}">
      			<br>
      			<input type="password" name="password" placeholder="minimo 8" required pattern="{8,20}">
      			<br>
      			<input type="password" name="repassword" placeholder="repite de nuevo contraseña por favor" required pattern="{8,20}">
      			<br>
      		
      			<input type="submit" value="Crear Usuario">
      		</form>
      
      </div>
      

    </div>
    <!-- /.container -->

 <%@ include file="includes/footer.jsp" %> 