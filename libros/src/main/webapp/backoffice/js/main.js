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
