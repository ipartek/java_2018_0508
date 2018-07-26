<%@ include file="includes/header.jsp"%>

<h1>LOG IN</h1>

<form action="login" method="post">
	<label for="user">Usuario:</label> <input name="user" type="text"
		autofocus placeholder="Introduce tu usuario" required
		pattern="^[A-Za-z0-9_]{3,25}$"> <br />
	<br /> <label for="pswd">Contraseña: </label> <input id="pass"
		name="pswd" type="password" placeholder="Introduce tu contraseña"
		required> 
		<i id="eye" class="fas fa-eye" onclick="show()" onmouseenter="show()" onmouseleave="show()"></i> <br />
	<br /> <input type="submit" value="Enviar">
	<p class="text-danger">${msg}</p>
</form>
<script>
	function show() {
		console.log('click en show');
		var pass = document.getElementById('pass');
		var eye =  document.getElementById('eye');
		console.log(pass);
		if (pass.type == "password") {
			pass.type = "text";
			//eye.className = "fas fa-eye-slash";
			eye.classList.replace("fa-eye","fa-eye-slash");
		} else {
			pass.type = "password";
			//eye.className = "fas fa-eye";
			eye.classList.replace("fa-eye-slash","fa-eye");
		}
	}
</script>

<%@ include file="includes/footer.jsp"%>