

<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>
<br>
<form action="login" method="post" class="loginform">
	<div class="imgcontainer">
		<img src="img/img_avatar2.png" alt="Avatar" class="avatar">
	</div>

	<div class="container">
		<label for="usuario"><b>Usuario</b></label> 
		<input type="text" placeholder="Usuario" name="usuario" class="logininput" > <br> 
		<label for="password"> <b>Contraseña</b></label> 
		<input id="pass" type="password" placeholder="Contraseña" name="password" class="logininput">
		<i id="eye" class="fas fa-eye" onmouseover="show()"></i><br>
		<button type="submit">Entrar</button>
		<label> <input type="checkbox" checked="checked"
			name="remember"> Acordarse
		</label>
	</div>
	<p style="color: red">${msg }</p>
	<div class="container" style="background-color: #f1f1f1">
		<button type="button" class="cancelbtn">Cancel</button>
		<span class="psw">Forgot <a href="#">password?</a></span>
	</div>
</form>

<script>
	function show(){
		console.log('click en show');
		var pass=document.getElementById('pass');
		var eye=document.getElementById('eye');
		
		if (pass.type=="password"){
			pass.type="text";
			eye.classList.replace("fa-eye","fa-eye-slash");
		}else{
			pass.type="password";
			eye.classList.replace("fa-eye-slash","fa-eye");
		}
		console.log(pass);
	}
</script>
