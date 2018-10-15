
$('#loginForm').on('shown.bs.dropdown', function () {
	
	console.log("Desplegado");
  
	var inputUsuario = $('#usuario');
	var inputPassword = $('#password');

	if (inputUsuario.val().length > 0) { // El checkbox recordar Usuario está activado
		
		inputPassword.focus(); // Dar focus a inputPassword
		console.log("Focus a password");

	} else { // El checkbox recordar Usuario no está activado

		inputUsuario.focus(); // Dar focus a inputUsuario
		console.log("Focus a usuario");
	}
});