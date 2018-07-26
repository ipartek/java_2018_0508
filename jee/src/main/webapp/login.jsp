

<%@ include file="includes/header.jsp"%>

<h1>LOGIN</h1>

<form action="login" method="get">
	<table>
		<tr>
			<td>User:</td>
			<td><input type="text" name="user" value="${usuario}"/ autofocus required></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input id="pass" type="password" name="password" value="${contrasenya}"/></td>
			<td><i id="eye" class="fas fa-eye" onmouseenter="show()"></i></td>
		</tr>
	</table>
	<input type="submit" value="Enviar" />
</form>

<p>${mensaje}</p>

<script>

function show(){
	
	console.log('Click en show');
	var pass= document.getElementById("pass");
	var eye= document.getElementById("eye");
	
	console.log(pass);
	
	if(pass.type== "password"){
		pass.type="text";
		eye.classList.replace("fa-eye","fa-eye-slash");
		
	}
	else{
		pass.type="password";
		eye.classList.replace("fa-eye-slash","fa-eye");
		
		
	}
	
}

</script>

<%@ include file="includes/footer.jsp"%>