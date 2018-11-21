/*	MOSTRAR FORMULARIOS MODALES DE CONFIRMACION*/


function showModalForm(codVista, id,  codOp, titulo,isbn,idEditorial) {

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
		
		var inputSubmit = document.createElement('input');
		inputSubmit.type = "submit";
		inputSubmit.value = "Guardar";
		inputSubmit.classList.add("btn", "btn-danger", "btn-block")

		document.getElementById("updateForm").appendChild(inputSubmit);

		switch (codVista) {

		case 1: // PRÉSTAMO

			addSelect("libros");
			addSelect("alumnos");
			addInput("date", "fecha", "");
			updateForm.action = "prestamos";
			break;

		case 2: // LIBRO
			/*//console.log(titulo);
			addInputValue("text", "titulo", "Máximo de 120 caracteres.", titulo);
			//addInput("text", "titulo", "Máximo de 120 caracteres.");
			addInputValue("text", "isbn", "Máximo de 19 caracteres", isbn);
			addInput("number", "ejemplares", "Introduce el Nº de Libros");
			addSelect("editorial",idEditorial);
			//addSelectSelected("editorial", idEditorial);
*/			
			//addButton("secondModal", "Crear editorial", "mb-2")
			addInput("text", "editorial", "Introduce el nombre de la editorial");
			
			//updateForm.action = "libros";
			var editorial = document.getElementById("editorial");
			break;

		case 3: // ALUMNO

			addInputValue("text", "alumno", "Máximo de 120 caracteres.",titulo);
			updateForm.action = "alumnos";
			break;

		case 4: // EDITORIAL

			addInputValue("text", "editorial", "Máximo de 120 caracteres.",titulo);
			updateForm.action = "editoriales";
			break;

		default:
			break;
		}

		addInputsHidden(codOp, id);
		
		
		

	})

	$('#modalEliminar').on('shown.bs.modal', function() {

		var updateForm = document.getElementById("updateForm");

		limpiarFormulario();

		switch (codVista) {

		case 1: // PRÉSTAMO

			updateForm.action = "prestamos";
			document.getElementById("btnEliminar").href = "prestamos?id="
					+ id + "&op=" + codOp+ "&idAlumno="+idAlumno+ "&idLibro="+idLibro+ "&fecha_inicio="+fechaInicio;
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


function ocultarAlumnos(){

	var select = document.getElementById("alumnos");
	var boton = document.getElementById("btnNuevoAlumno");
	var botonListado = document.getElementById("btnListaAlumno");
	console.log(select);
	select.style.display = "none";
	boton.style.display = "none";
	botonListado.style.display = "inline-block";
	select.value = 0 ;
	var nuevaEditorial = document.getElementById("nuevoAlumno");
	nuevaEditorial.type = "text";

}

function ocultarEditoriales(){

		var select = document.getElementById("editorial");
		var boton = document.getElementById("botonNuevadit");
		var botonListado = document.getElementById("botonListado");
		console.log(select);
		select.style.display = "none";
		boton.style.display = "none";
		botonListado.style.display = "inline-block";
		select.value = 0 ;
		var nuevaEditorial = document.getElementById("nuevaEditorial");
		nuevaEditorial.type = "text";
	
}

function ocultarLibros(){

	var select = document.getElementById("libros");
	var boton = document.getElementById("btnNuevoLibro");
	var botonListado = document.getElementById("btnListaLibro");

	console.log(select);
	select.style.display = "none";
	boton.style.display = "none";

	botonListado.style.display = "inline-block";
	select.value = 0 ;

	var tituloLibroNuevo = document.getElementById("rowTitulo");
	var isbnLibroNuevo = document.getElementById("rowIsbn");
	var editorialLibroNuevo = document.getElementById("rowEditorial");
	var nuevoTitulo = document.getElementById("nuevoTitulo");
	var nuevoIsbn = document.getElementById("nuevoIsbn");
	
	tituloLibroNuevo.style.display= "block";
	isbnLibroNuevo.style.display= "block";
	editorialLibroNuevo.style.display= "block";
	nuevoTitulo.type= "text";
	nuevoIsbn.type= "text";

}

function mostrarLibros(){

	var select = document.getElementById("libros");
	var boton = document.getElementById("btnNuevoLibro");
	var botonListado = document.getElementById("btnListaLibro");

	console.log(select);
	select.style.display = "inline-block";
	boton.style.display = "inline-block";
	botonListado.style.display = "none";
	select.value = 0 ;
	var nuevaEditorial = document.getElementById("nuevaEditorial");
	nuevaEditorial.type = "hidden";
	var tituloLibroNuevo = document.getElementById("rowTitulo");
	var isbnLibroNuevo = document.getElementById("rowIsbn");
	var editorialLibroNuevo = document.getElementById("rowEditorial");
	var nuevoTitulo = document.getElementById("nuevoTitulo");
	var nuevoIsbn = document.getElementById("nuevoIsbn");
	
	tituloLibroNuevo.style.display= "none";
	isbnLibroNuevo.style.display= "none";
	editorialLibroNuevo.style.display= "none";
	nuevoTitulo.type= "hidden";
	nuevoIsbn.type= "hidden";

}

function mostrarEditoriales(){
	var select = document.getElementById("editorial");
	var boton = document.getElementById("botonNuevadit");
	var botonListado = document.getElementById("botonListado");
	console.log(select);
	select.style.display = "inline-block";
	boton.style.display = "inline-block";
	botonListado.style.display = "none";
	select.value = 0 ;
	var nuevaEditorial = document.getElementById("nuevaEditorial");
	nuevaEditorial.type = "hidden";
	
}

function mostrarAlumnos(){
	var select = document.getElementById("alumnos");
	var boton = document.getElementById("btnNuevoAlumno");
	var botonListado = document.getElementById("btnListaAlumno");
	console.log(select);
	select.style.display = "inline-block";
	boton.style.display = "inline-block";
	botonListado.style.display = "none";
	select.value = 0 ;
	var nuevaEditorial = document.getElementById("nuevoAlumno");
	nuevaEditorial.type = "hidden";
	
}

/*function mostrarEditoriales(){
	var select = document.getElementById("editorial");
	var boton = document.getElementById("botonNuevadit");
	var botonListado = document.getElementById("botonListado");
	botonListado.type="hidden";
	boton.type="button";
	console.log(select);
	select.style.visibility="block";
	var nuevaEditorial = document.getElementById("nuevaEditorial");
	nuevaEditorial.type="hidden";
}*/

function limpiarFormulario() {

	var updateForm = document.getElementById("updateForm");

	if (updateForm.hasChildNodes()) {
		while (updateForm.childNodes.length >= 1) {
			updateForm.removeChild(updateForm.firstChild);
		}
	}
}

function addButton(buttonId, value){
	
	var button = document.createElement('button');
	button.innerHTML = value;
	button.classList.add("btn", "btn-primary");
	button.name  = buttonId;
	button.id  = buttonId;
	document.getElementById("updateForm").appendChild(button);
}

function addInputSubmit() {
	
	var inputSubmit = document.createElement('input');
	inputSubmit.type = "submit";
	inputSubmit.value = "Guardar";
	inputSubmit.classList.add("btn", "btn-danger", "btn-block")

	document.getElementById("updateForm").appendChild(inputSubmit);
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

function addInputValue(elementTag, elementId, html, inputValue) {
	console.log(inputValue);
	if (inputValue === undefined){
		inputValue = '';
	}
	var divGroup = document.createElement('div');
	divGroup.classList.add("form-group");

	var input = document.createElement('input');
	var label = document.createElement("label");

	label.htmlFor = elementId;
	label.innerHTML = elementId;

	input.type = elementTag;
	input.name = elementId;
	input.value = inputValue;
	input.id = elementId;
	input.placeholder = html;
	input.classList.add("form-control");
	input.attributes.required = "";

	document.getElementById("updateForm").appendChild(divGroup);
	divGroup.appendChild(label);
	divGroup.appendChild(input);

}

function addInput(elementTag, elementId, html ) {

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
	input.attributes.required = "";

	document.getElementById("updateForm").appendChild(divGroup);
	divGroup.appendChild(label);
	divGroup.appendChild(input);

}

function cargarEditorialesSelected(dropdown) {

	console.log("Select editoriales");

	// Llamada a AJAX (Asíncrona)
	var URL = "../editoriales";

	$.getJSON(URL, function (data) {
		
		console.log(data);
		$("#editorial").html("");
		var options = "";
		$.each(data, function (key, entry) {
		   // dropdown.append($('<option></option>').attr('value', entry.id).text(entry.nombre));
			options += '<option value="'+entry.id+'">'+entry.nombre+'</option>';
		 });
		$("#editorial").html(options);
	});

}

function addSelect(elementId, idEditorial) {

	var divGroup = document.createElement('div');
	divGroup.classList.add("form-group");

	var label = document.createElement("label");

	label.htmlFor = elementId;
	label.innerHTML = elementId;
	
	var dropdown = document.createElement("select");

	dropdown.name = elementId;
	dropdown.id = elementId;
	dropdown.classList.add("form-control")
	
	cargarEditoriales(dropdown,idEditorial);
	
	document.getElementById("updateForm").appendChild(divGroup);
	divGroup.appendChild(dropdown);
}

function cargarEditoriales(dropdown,idEditorial) {

	console.log("Select editoriales");

	// Llamada a AJAX (Asíncrona)
	var URL = "../editoriales";

	$.getJSON(URL, function (data) {
		
		console.log(data);
		$("#editorial").html("");
		var options = "";
		$.each(data, function (key, entry) {
		   // dropdown.append($('<option></option>').attr('value', entry.id).text(entry.nombre));
			
			if (idEditorial == entry.id){
				console.log(idEditorial + " es igual a "+entry.id);
				options += '<option selected value="'+entry.id+'">'+entry.nombre+'</option>';
			}else{
				options += '<option value="'+entry.id+'">'+entry.nombre+'</option>';
			}
			
		 });
		$("#editorial").html(options);
	});

}

function showInputDialogDevolver(codOp, alumno, libro, fechaInicio) {

	var modalForm = $('#modalModificar');

	var updateForm = document.getElementById("updateForm");

	limpiarFormulario();

	updateForm.title="Devolución de Préstamo de Libro";
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
	addInputHidden("alumnos", alumno);
	addInputHidden("libros", libro);
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



$(document).ready(function() {
	$('ul li').click(function() {
		$('ul li').removeClass("active");
		$(this).addClass("active");
	});
});



// Habilitar datatables
$(document).ready(function() {
	//$('#tablaOrdenable').DataTable();
	$('#tablaOrdenable').dataTable( {
        "order": [[ 0, 'desc' ], [ 1, 'desc' ]],
        
		"language": {
	        "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
		}
    } );


});

$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	});