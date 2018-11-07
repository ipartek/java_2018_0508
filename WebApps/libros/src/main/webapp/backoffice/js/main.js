/*	MOSTRAR FORMULARIOS MODALES DE CONFIRMACION*/

var libros = [];
var alumnos = [];
var editoriales = [];

function showInputDialogDevolver(codOp, alumno, libro, fechaInicio) {

	var modalForm = $('#modalModificar');
	;
	var updateForm = document.getElementById("updateForm");

	limpiarFormulario();

	var divGroup = document.createElement("div");
	divGroup.classList.add("form-group");

	var input = document.createElement("input");
	var label = document.createElement("label");

	label.htmlFor = "fechaRetorno";
	label.innerHTML = "Fecha de Devolución";

	input.type = "date";
	input.name = "fechaRetorno";
	input.id = "fechaRetorno";
	input.classList.add("form-control");
	input.attributes.required = "";

	document.getElementById("updateForm").appendChild(divGroup);
	divGroup.appendChild(label);
	divGroup.appendChild(input);

	addInputHidden("op", codOp);
	addInputHidden("alumno", alumno);
	addInputHidden("libro", libro);
	addInputHidden("fechaInicio", fechaInicio);

	addInputSubmit();

	updateForm.action = "prestamos";

	$('#fechaRetorno').val(new Date().toDateInputValue());

	modalForm.modal();

}

// Fecha por defecto
Date.prototype.toDateInputValue = (function() {
	var local = new Date(this);
	local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
	return local.toJSON().slice(0, 10);
});

function ocultarEditoriales() {

	var select = document.getElementById("editorial");
	var boton = document.getElementById("botonNuevadit");
	var botonListado = document.getElementById("botonListado");

	console.log(select);
	select.style.display = "none";
	boton.style.display = "none";
	botonListado.style.display = "inline-block";

	var nuevaEditorial = document.getElementById("nuevaEditorial");
	nuevaEditorial.type = "text";

}

function mostrarEditoriales() {
	var select = document.getElementById("editorial");
	var boton = document.getElementById("botonNuevadit");
	var botonListado = document.getElementById("botonListado");
	console.log(select);
	select.style.display = "inline-block";
	boton.style.display = "inline-block";
	botonListado.style.display = "none";
	select.value = 0;
	var nuevaEditorial = document.getElementById("nuevaEditorial");
	nuevaEditorial.type = "hidden";

}

function mostrarLibros() {
	var libros = document.getElementById("rowLibro");
	var alumnos = document.getElementById("rowAlumno");
	var fechaInicio = document.getElementById("rowInicio");
	var fechaFin = document.getElementById("rowFin");
	var boton = document.getElementById("btnNuevoLibro");
	var botonAlumno = document.getElementById("btnNuevoAlumno");
	var botonListado = document.getElementById("btnListaLibro");
	
	var titulo = document.getElementById("rowTitulo");
	var isbn = document.getElementById("rowIsbn");
	var ejemplares = document.getElementById("rowNumLibros");
	var editorial = document.getElementById("rowEditorial");

	libros.style.display = "inline-block";
	alumnos.style.display = "inline-block";
	fechaInicio.style.display = "inline-block";
	fechaFin.style.display = "inline-block";
	boton.style.display = "inline-block";
	
	titulo.style.display = "none";
	isbn.style.display = "none";
	ejemplares.style.display = "none";
	editorial.style.display = "none";
	
	botonAlumno.style.display = "inline-block";
	botonListado.style.display = "none";

}

function ocultarLibros() {

	var libros = document.getElementById("rowLibro");
	var alumnos = document.getElementById("rowAlumno");
	var fechaInicio = document.getElementById("rowInicio");
	var fechaFin = document.getElementById("rowFin");
	var boton = document.getElementById("btnNuevoLibro");
	var botonAlumno = document.getElementById("btnNuevoAlumno");
	var botonListado = document.getElementById("btnListaLibro");
	
	var titulo = document.getElementById("rowTitulo");
	var isbn = document.getElementById("rowIsbn");
	var ejemplares = document.getElementById("rowNumLibros");
	var editorial = document.getElementById("rowEditorial");

	libros.style.display = "none";
	alumnos.style.display = "none";
	fechaInicio.style.display = "none";
	fechaFin.style.display = "none";
	boton.style.display = "none";
	
	titulo.style.display = "inline-block";
	isbn.style.display = "inline-block";
	ejemplares.style.display = "inline-block";
	editorial.style.display = "inline-block";
	botonListado.style.display = "inline-block";
	botonAlumno.style.display = "none";

}

function mostrarAlumnos() {
	
	var libros = document.getElementById("rowLibro");
	var alumnos = document.getElementById("rowAlumno");
	var fechaInicio = document.getElementById("rowInicio");
	var fechaFin = document.getElementById("rowFin");
	var boton = document.getElementById("btnNuevoAlumno");
	var botonListado = document.getElementById("btnListaAlumno");

	libros.style.display = "inline-block";
	alumnos.style.display = "inline-block";
	fechaInicio.style.display = "inline-block";
	fechaFin.style.display = "inline-block";
	boton.style.display = "inline-block";
	botonListado.style.display = "none";

}

function ocultarAlumnos() {

	var libros = document.getElementById("rowLibro");
	var alumnos = document.getElementById("rowAlumno");
	var fechaInicio = document.getElementById("rowInicio");
	var fechaFin = document.getElementById("rowFin");
	var boton = document.getElementById("btnNuevoAlumno");
	var botonListado = document.getElementById("btnListaAlumno");

	libros.style.display = "none";
	alumnos.style.display = "none";
	fechaInicio.style.display = "none";
	fechaFin.style.display = "none";
	boton.style.display = "none";
	botonListado.style.display = "inline-block";

	// var nuevoLibro = document.getElementById("nuevoTitulo");
	// nuevaEditorial.type = "text";

}



function limpiarFormulario() {
	var updateForm = document.getElementById("updateForm");

	if (updateForm.hasChildNodes()) {
		while (updateForm.childNodes.length >= 1) {
			updateForm.removeChild(updateForm.firstChild);
		}
	}
}

function addInputHidden(name, value) {

	var divGroup = document.createElement("div");
	divGroup.classList.add("form-group");

	var input = document.createElement("input");

	input.type = "hidden";
	input.name = name;
	input.value = value;
	input.classList.add("form-control");

	document.getElementById("updateForm").appendChild(divGroup);
	divGroup.appendChild(input);

}

function addInputSubmit() {
	var inputSubmit = document.createElement("input");
	inputSubmit.type = "submit";
	inputSubmit.value = "Guardar";
	inputSubmit.classList.add("btn", "btn-danger", "btn-block");

	document.getElementById("updateForm").appendChild(inputSubmit);
}

function cargarEditoriales() {
	console.log("Select editoriales");

	// Llamada a AJAX (Asíncrona)
	var URL = "../editoriales";

	$.getJSON(URL, function(data) {
		dropdown.html("");

		var options = "";

		$.each(data, function(key, entry) {
			options += '<option value="' + entry.id + '">' + entry.nombre
					+ "</option>";
		});

		dropdown.html(options);
	});
}

function cargarAlumnos() {
	console.log("Select Alumnos");

	// Llamada a AJAX (Asíncrona)
	var URL = "../alumnos";

	$.getJSON(URL, function(data) {
		$("#alumnos").html("");

		var options = "";

		$.each(data, function(key, entry) {
			options += '<option value="' + entry.id + '">' + entry.nombre
					+ "</option>";
			alumnos.push(entry);
		});

		$("#alumnos").html(options);

		console.log(alumnos.length);
	});
}

function cargarLibros() {
	console.log("Select Libros");

	// Llamada a AJAX (Asíncrona)
	var URL = "../libros";

	$.getJSON(URL, function(data) {
		$("#libros").html("");

		libros = [];

		var options = "";

		$.each(data, function(key, entry) {
			options += '<option value="' + entry.id + '">' + entry.titulo
					+ "</option>";
			libros.push(entry);
		});

		$("#libros").html(options);

		console.log(libros.length);
	});
}

// Elemento activo del menu
$(document).ready(function() {
	$("ul li").click(function() {
		$("ul li").removeClass("active");
		$(this).addClass("active");
	});
});

// Habilitar datatables
$(document).ready(function() {
	$("#tablaOrdenable").DataTable();
});
