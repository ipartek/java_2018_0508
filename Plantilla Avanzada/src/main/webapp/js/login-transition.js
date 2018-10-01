$(document).ready(function() {
	$(function() {
		$ ( '#login' ). on ( 'click' , function () { 
			$(this).next('#login-content').slideToggle();
			$(this).toggleClass('active');
			
			var inputUsuario = $('#usuario');
			var inputPassword = $('#password');

			if (inputUsuario.val().length > 0) { // El checkbox recordar Usuario está activado
				
				inputPassword.trigger('focus'); // Dar focus a inputPassword

			} else { // El checkbox recordar Usuario no está activado

				inputUsuario.trigger('focus'); // Dar focus a inputUsuario
			}
		});	
	});	
});