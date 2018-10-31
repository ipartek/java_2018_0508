/*	MOSTRAR FORMULARIOS MODALES DE CONFIRMACION*/
function showModalForm(codVista, id, codOp) {

	var modalForm;
	var btnGo;
	btnGo = $('#btnEliminar');

	if (codOp == 3) {

		modalForm = $('#modalEliminar');

	} else {

		modalForm = $('#modalModificar');
	}

	modalForm.modal();

	$('#modalModificar').on('shown.bs.modal', function() {

		var updateForm = document.getElementById("updateForm");
		limpiarFormulario();

		switch (codVista) {

		case 1: // PRÉSTAMO

			addSelect("libros");
			addSelect("alumnos");
			addInput("date", "fecha", "");
			updateForm.action = "prestamos";
			break;

		case 2: // LIBRO

			addInput("text", "titulo", "Máximo de 120 caracteres.");
			addInput("text", "isbn", "Máximo de 19 caracteres");
			addInput("number", "Nº de Libros", "");
			cargarEditoriales();
			// addSelect("editorial");
			updateForm.action = "libros";
			break;

		case 3: // ALUMNO

			addInput("text", "alumno", "Máximo de 120 caracteres.");
			updateForm.action = "alumnos";
			break;

		case 4: // EDITORIAL

			addInput("text", "editorial", "Máximo de 120 caracteres.");
			updateForm.action = "editoriales";
			break;

		default:
			break;
		}

		addInputsHidden(codOp, id);
		var inputSubmit = document.createElement('input');
		inputSubmit.type = "submit";
		inputSubmit.value = "Guardar";
		inputSubmit.classList.add("btn", "btn-danger", "btn-block")

		document.getElementById("updateForm").appendChild(inputSubmit);

	})

	$('#modalEliminar')
			.on(
					'shown.bs.modal',
					function() {

						var updateForm = document.getElementById("updateForm");

						limpiarFormulario();

						switch (codVista) {

						case 1: // PRÉSTAMO

							updateForm.action = "prestamos";
							document.getElementById("btnEliminar").href = "prestamos?id="
									+ id + "&op=" + codOp;
							break;

						case 2: // LIBRO

							updateForm.action = "libros";
							document.getElementById("btnEliminar").href = "libros?id="
									+ id + "&op=" + codOp;
							break;

						case 3: // ALUMNO

							updateForm.action = "alumnos";
							document.getElementById("btnEliminar").href = "alumnos?id="
									+ id + "&op=" + codOp;
							break;

						case 4: // EDITORIAL

							updateForm.action = "editoriales";
							document.getElementById("btnEliminar").href = "editoriales?id="
									+ id + "&op=" + codOp;
							break;

						default:
							break;
						}

						addInputsHidden(codOp, id);
					})

}

function limpiarFormulario() {

	var updateForm = document.getElementById("updateForm");

	if (updateForm.hasChildNodes()) {
		while (updateForm.childNodes.length >= 1) {
			updateForm.removeChild(updateForm.firstChild);
		}
	}
}

function addInputsHidden(codOp, id) {

	var inputOp = document.createElement('input');
	inputOp.type = "hidden";
	inputOp.name = "op";
	inputOp.value = codOp;

	var inputId = document.createElement('input');
	inputId.type = "hidden";
	inputId.name = "id";
	inputId.value = id;

	document.getElementById("updateForm").appendChild(inputOp);
	document.getElementById("updateForm").appendChild(inputId);
}

function addInput(elementTag, elementId, html) {

	var divGroup = document.createElement('div');
	divGroup.classList.add("form-group");

	var input = document.createElement('input');
	var label = document.createElement("label");

	label.htmlFor = elementId;
	label.innerHTML = elementId;

	input.type = elementTag;
	input.name = elementId;
	input.id = elementId;
	input.placeholder = html;
	input.classList.add("form-control");

	document.getElementById("updateForm").appendChild(divGroup);
	divGroup.appendChild(label);
	divGroup.appendChild(input);

}

function addSelect(elementId, options) {

	var divGroup = document.createElement('div');
	divGroup.classList.add("form-group");

	var select = document.createElement("select");

	select.name = elementId;
	select.id = elementId;

	for (var i = 0; i < options.length; i += 1) {

		var option = document.createElement("option");

		option.text = options[i];
		select.add(option);
	}

	document.getElementById("updateForm").appendChild(divGroup);
	divGroup.appendChild(select);
}

function cargarEditoriales() {

	console.log("Select editoriales");

	// Llamada a AJAX (Asíncrona)
	var URL = "editoriales";

	$.ajax(URL, {
		"type" : "post", // Usualmente post o get

		"success" : function(data, textStatus, xhr) {

			for (var i = 0, len = data.length; i < len; i++) {
				console.log(data[i]);
			}

			console.log("Llego el contenido y no hubo error");
		},

		"error" : function(data) {

			console.error("Este callback maneja los errores", data);
		},
		"async" : true,
	})

}

$(document).ready(function() {
	$('ul li').click(function() {
		$('ul li').removeClass("active");
		$(this).addClass("active");
	});
});

// Habilitar datatables
$(document).ready(function() {
	$('#tablaOrdenable').DataTable();
});