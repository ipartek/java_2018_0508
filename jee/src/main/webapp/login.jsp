	<%@ include file="includes/header.jsp" %>
	
	<div>
		<form action="log" method="POST">
			<table>
				<tr>
					<th>	<label for="usuario">Usuario</label>			</th>
					<th align="left">	<input type="text" name="usuario" autofocus="autofocus" value="" required pattern="^[a-zA-Z0-9]{3,25}$"> 	</th>
				</tr>
				<tr>	
					<th>	<label for="usuario">Contraseña</label>			</th>
					<th>	<input id="pass" type="password" name="pass" value="" required> 
							<i id="eye" class="fas fa-eye" onmouseenter="show()" onmouseleave="show()"></i>	</th>
				</tr>	 
				<tr>
					<th>	<input type="submit" value="Aceptar">			</th>
					<th>										</th>
				</tr>
			</table>
		</form>
	</div>
		
	<script>
		function show() {
			console.log('click en show');
			var pass = document.getElementById('pass');
			var eye = document.getElementById('eye');
			if ( pass.type == "password") {
				pass.type = "text";
				eye.classList.replace("fa-eye","fa-eye-slash");
			} else {
				pass.type = "password";
				eye.classList.replace("fa-eye-slash","fa-eye");
			}
		}
	</script>
		
</body>

</html>