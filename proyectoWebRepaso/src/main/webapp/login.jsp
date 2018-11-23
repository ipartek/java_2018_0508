<%@ include file="includes/head.jsp" %>
  	<c:if test="${acceso==false }">
  		<spam class="alert alert-warning alert-dismissible fade show">No puedes acceder a la zona privada </spam>
  		<a class="btn btn-danger" href="#" name="accederIndex" >Ir a privado</a>
  	</c:if>
  	<c:if test="${acceso}">
  	<spam class="alert alert-warning alert-dismissible fade show">Vamos!!Dale al boton verde!! </spam>
  		<a class="btn btn-success" href="privado/privadoLogin.jsp" name="accederIndex" >Ir a privado</a>
  	</c:if>
  	
  	
  	<form action="login" method="post">
	  <div class="form-group">
	    <label for="user">Usuario:</label>
	    <input type="text" class="form-control" name="user" placeholder="min 2 max 8 caracteres">	    
	  </div>
	  <div class="form-group">
	    <label for="pass">Contraseña:</label>
	    <input type="pass" class="form-control" name="pass" placeholder="nim 2 max 8 caracteres">
	  </div>	  
	  <input type="submit" class="btn btn-primary" value="Acceder privado" name="acceder">
	</form>
  
  
  </body>
</html>