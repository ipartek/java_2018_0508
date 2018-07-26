<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>



<h1>LOGIN</h1>
<fieldset>
	<form class="login" action="login" method="post">
		<input type="text" name="usuario" placeholder="Introduzca su usuario"
			required pattern=^[A-Za-z0-9_]{3,25}$ autofocus /> <input id="pass"
			type="password" name="pass" placeholder="Introduzca su password" />
		<i id="eye" class="far fa-eye" onmouseenter="show()" onmouseleave="show()"></i>
		<br /> <input type="submit" value="Convertir" required />

	</form>
</fieldset>
<p>${msg}</p>

<%@ include file="includes/footer.jsp"%>