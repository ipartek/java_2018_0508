function confirmar(e) {
	
	if (confirm('ATENCIÓN: Esta operación es irreversible.\n ¿Estás seguro que quieres eliminar ?')) {

		console.log('Eliminado');

	} else {
		
		e.preventDefault(); // Prevenir el evento por defecto de <a href=''>
		
	}
	
}

function showPassword(elementID) {
	
	console.log('Click showPassword ' + elementID);
	
	var input = document.getElementById(elementID, event);

	if (input.type === 'password') {
		
		input.setAttribute("type", "text");
		input.classList.replace("fa-eye-slash", "fa-eye");
		
	} else {
		
		input.setAttribute("type", "password");
		input.classList.replace("fa-eye-slash", "fa-eye");
		
	}
}