/*El autofocus no funciona correctamente en las ventanas modales, debido a ello es necesario usar el evento 
 * onShown para simular la misma función y que funcione correctamente.
 * 
 */
$(document).ready(function() {

	$('#modal-login-form').on('shown.bs.modal', function() {

		var inputUsuario = $('#usuario');
		var inputPassword = $('#password');

		if (inputUsuario.val().length > 0) { // El checkbox recordar Usuario está activado
			
			inputPassword.trigger('focus'); // Dar focus a inputPassword

		} else { // El checkbox recordar Usuario no está activado

			inputUsuario.trigger('focus'); // Dar focus a inputUsuario
		}
		
		// Función JQuery para mantener el foco dentro del formulario modal
		$.blockUI();

	});
    
});
