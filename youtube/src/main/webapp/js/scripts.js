function cambiarLogo(){
	var fecha = new Date();
	var hora = fecha.getHours();
	console.log(hora);
	var logo = document.getElementById("logo");
	if(hora>=21 || hora<9){
		logo.src = "images/logo_noche.png"; 
	}	
}

function showModalDetalle(texto){
	$('#modal-detalle').modal('show');
	let comentario = document.getElementById('texto_comentario');
	comentario.innerHTML = texto;
}
/**
 * Funciones de la pagina de registro
 */
function checkNombre() {
	var nombre = $("#nombre").val();
	var input_nombre = $("#nombre");
	var help = $("#nombreHelp");
	console.log(nombre);
	var url = "CheckNombre";
	if (nombre != "") {
		// Llamada es asincrona
		$.ajax(url, {
			"type": "post",
			"success": function(result) {
				console.log("Llego el contenido y no hubo error", result);
				// result.resultado
				if(true === result.resultado){
					help.html('*nombre de usuario no disponible!');
					help.addClass("text-pika-red");
					help.removeClass("text-pika-blue");
					input_nombre.addClass("incorrecto");
					input_nombre.removeClass("correcto");
				}else{
					help.html('*nombre de usuario disponible!');
					help.addClass("text-pika-blue");
					help.removeClass("text-pika-red");
					input_nombre.addClass("correcto");
					input_nombre.removeClass("incorrecto");
				}
			},
			"error": function(result) {
				console.error("Este callback maneja los errores", result);
				help.html('*error inesperado');
				input_nombre.addClass("incorrecto");
				input_nombre.removeClass("correcto");
			},
			"data": {"nombre": nombre}
		});
	}
	
}

function strengthOfPass() {
	var fuerza = $("#fuerza_pass");
	var pass = $("#pass").val();
	console.log(pass);
	if (pass.length < 6) {
		fuerza.addClass("text-pika-red");
		fuerza.removeClass("text-pika-yellow");
		fuerza.removeClass("text-pika-blue");
		fuerza.html("Weak");
	}else if(pass.length < 12){
		fuerza.removeClass("text-pika-red");
		fuerza.addClass("text-pika-yellow");
		fuerza.removeClass("text-pika-blue");
		fuerza.html("Medium");
	}else{
		fuerza.removeClass("text-pika-red");
		fuerza.removeClass("text-pika-yellow");
		fuerza.addClass("text-pika-blue");
		fuerza.html("Strong");
	}
}

function comprobarContrasenyas(){
	var espejo = $("#dual_pass");
	var pass = $("#pass").val();
	var pass2 = $("#pass2").val();
	if(pass===pass2){
		espejo.addClass("text-pika-blue");
		espejo.removeClass("text-pika-red");
		espejo.html("Coinciden :D");
	}else{
		espejo.addClass("text-pika-red");
		espejo.removeClass("text-pika-blue");
		espejo.html("No coinciden las contraseñas...");
	}
}
