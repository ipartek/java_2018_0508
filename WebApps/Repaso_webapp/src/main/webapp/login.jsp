<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- HEADER STARTS HERE -->
<%@ include file="include/header.jsp"%>


<main class="container">
	
	<header class="titulo"><h1 class="text-center">Login + Filtro</h1></header>
	
	<div class="row">
		
		<div class="col-lg-4 mx-auto">
			 <a href="privado/videojuego.jsp" class="btn btn-block ${ !logueado ? 'btn-danger' : 'btn-success' }">Acceder Privado</a>
		</div>
	
	</div>
	
	<div class="row">
		<div class="col-lg-6 mx-auto">
			
			 <form action="login" method="post">
                  
                   <div class="form-group">
                     <label for="usuario">Usuario</label>
                     <input type="text" class="form-control" name="usuario" id="usuario"  placeholder="Introduce el usuario..." value="admin">
                   </div>
                   
                   <div class="form-group">
                     <label for="psw">Password</label>
                     <input type="password" class="form-control" name="password" id="password" placeholder="Password" value="admin">
                   </div>
                   
                   <div class="form-check">
                     <button class="btn btn-info" type="button" name="showpassword" id="showpassword" value="Show Password">Show password</button> 
                     <button type="submit" class="btn btn-primary">Login</button>
                     <a href="logout" class="btn btn-danger">Logout</a>
                   </div>
                   
                 </form>
		
		</div>
	</div>

</main>

<script>
	
document.addEventListener("DOMContentLoaded", function(){


	var btn = document.getElementById("showpassword")
	
	// Show password Button
	document.getElementById("showpassword").addEventListener('click', function(){
		
		var pass = document.getElementById("password");

		if (pass.type == 'password') {
			
			pass.type = 'text';
			btn.innerHTML = "Hide Password";
		
		} else {
			pass.type = 'password';
			btn.innerHTML = "Show Password";
		}


	});





});
	
</script>
