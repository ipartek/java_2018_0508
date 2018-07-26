

<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>
<br>
<form action="login" method="post" class="loginform">
	<div class="imgcontainer">
		<img src="img/img_avatar2.png" alt="Avatar" class="avatar">
	</div>

	<div class="container">
		<label for="usuario"><b>Usuario</b></label> <input type="text"
			placeholder="Usuario" name="usuario" class="logininput"> <br> <label
			for="password"><b>Contraseña</b></label> <input type="password"
			placeholder="Contraseña" name="password" class="logininput"> <br>
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

<%@ include file="includes/footer.jsp"%>