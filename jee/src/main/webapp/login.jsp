
	<%@ include file = "includes/header.jsp" %>

	<%@ include file = "includes/navbar.jsp" %>
	
	<div class="media center">
		
		<img src="img/login.png" alt="Imagen de un usuario">
	
		<form action="login" method="POST">
			
			<span><i class="fa fa-user fa-2x"></i></span>
			<input name="usuario" type="text" placeholder="Usuario" autofocus required pattern="^[A-Za-z0-9_]{1,25}$"><br><br>
			<span><i id="pass_css" class="fa fa-eye fa-2x" onmouseenter="show()" onmouseleave="show()"></i></span>
			<input id="pass" name="password" type="password" placeholder="Contraseña" required><br><br>
			<input class="btn btn-gestion-libros" type="submit" value="LOGIN">
			
		</form>
		
		<h3 class="center text-danger">${msg}</h3>
	</div>
	
	<script>
		function show() {
			console.log('click en show');
			var pass = document.getElementById('pass');
			if (pass.type === "password") {
				pass.type = "text";
				
				pass_css.classList.replace("fa-eye","fa-eye-slash");
				
			}else{
				pass.type = "password";
				
				pass_css.classList.replace("fa-eye-slash","fa-eye");
			}
			console.log(pass);
		}
	</script>

	<%@ include file = "includes/footer.jsp" %>