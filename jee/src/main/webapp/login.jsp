
	<%@ include file = "includes/header.jsp" %>

	<%@ include file = "includes/navbar.jsp" %>
	
	<div class="media center">
		
		<img src="img/login.png" alt="Imagen de un usuario">
	
		<form action="login" method="POST">
			
			<span><i class="fa fa-user fa-2x"></i></span><input name="usuario" type="text" placeholder="Usuario"><br><br>
			<span><i class="fa fa-asterisk fa-2x"></i></span><input name="password" type="password" placeholder="Contraseña"><br><br>
			<input class="btn btn-gestion-libros" type="submit" value="LOGIN">
			
		</form>
		
		<h3 class="center text-danger">${msg}</h3>
	</div>
	

	<%@ include file = "includes/footer.jsp" %>