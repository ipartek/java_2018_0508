var ENDPOINT = "http://localhost:8080/PrestamosAPI/";

var ulEditoriales = document.getElementById("ulEditoriales");
var editoriales = [];
var editorial;      // Editorial seleccionada

var ulErrores = document.getElementById("editorialError");
var mensaje = document.getElementById("mensaje"); // Mostrar mensajes

window.addEventListener("load", function(event) {

    console.log("Ventana cargada.");

    cargarEditoriales();

});

function cargarEditoriales(txtMensaje) {

    mensaje.innerHTML = "";

    // Vaciar UL
    ulEditoriales.innerHTML = "";

    // Llamada a AJAX (Asíncrona)
    var URL = "editoriales";
    editoriales = [];

    var request = new XMLHttpRequest();

    var li = "";

    request.onreadystatechange  = function() {
        if (request.readyState == 4) {

            if (request.status === 200) {   
                
                editoriales = JSON.parse(request.responseText); // Parsear a JSON el array recibido
                
                for (var i = 0, len = editoriales.length; i < len; i++) {
                      li += `<li id= ${editoriales[i].id} class='list-group-item'> 
                      ${editoriales[i].nombre} 
                      <a class='btn btn-xs btn-danger float-right ml-3' onclick='eliminarEditorial( ${i}, event );'> Eliminar </a> 
                      <a class='btn btn-xs btn-success float-right' onclick='modificarEditorial(${i}, event);'> Modificar </a> 
                      </li>`
                }

                ulEditoriales.innerHTML = li;

                addClickListenerLIActive(event);
            } 
        } 

        if (txtMensaje != null) {
            mensaje.innerHTML = txtMensaje;
        }
        else {
            mensaje.textContent = "";
        }
        
       
    };   

    request.open('GET', ENDPOINT + URL);
    request.send();
}

function addClickListenerLIActive(e) {

    ulEditoriales.addEventListener("click", function(e) {
        
        removeActiveClassFromEditoriales();

        if(e.target && e.target.nodeName == "LI") {
            e.target.classList.add("active");
        }

    });
}

function removeActiveClassFromEditoriales() {

	var children = ulEditoriales.children;
    
    for (var i = 0; i < children.length; i++) {  
        var child = children[i];
        child.classList.remove("active");
    }
}

function crearEditorial() {

    var inputNombre = document.getElementById("editorialNombre");

    // Llamada a AJAX (Asíncrona)
	var URL = "editoriales";

    var request = new XMLHttpRequest(); // Crear request
    
    request.open('POST', ENDPOINT + URL);   // Abrir llamada de tipo POST

    request.setRequestHeader("Content-type", "application/json"); // Dar formato JSON

    var nombre = inputNombre.value; // Recoger valor del input
    
    var formattedJsonData = JSON.stringify(nombre);   // Formatear JSON

    request.onreadystatechange  = function() {

        if (request.readyState == 4) {

            if (request.status === 201) {   

                cargarEditoriales("Editorial creada.");
            } 
            else {  
                
                var responseError = JSON.parse(request.responseText);
                var liError;

                liError = "<li>" + responseError.mensaje + "</li>";
                responseError.errores.forEach(error => {
                    liError += "<li class='text-danger'>" + error + "</li>";
                });

                ulErrores.innerHTML += liError;
            }
        } 
    };   

    request.send(formattedJsonData);

}

function showTabModificar(i, event) {

    var inputNombre = document.getElementById("editorialNombre");
    inputNombre.value = editoriales[i].nombre;
    $('#nav-crear-tab').tab('show');

    btnGo = document.getElementById("btnGo");
    btnGo.innerHTML = "Guardar";
    btnGo.addEventListener("click", function() {
        modificarEditorial(i);
    });
}

function modificarEditorial(i, event) {

    event.stopPropagation();
    editorial = editoriales[i];
    console.log('modificar editorial %o', editorial);

    var nuevoNombre;
   
    while (nuevoNombre == null) {
        nuevoNombre = prompt("Por favor, Introduce un nuevo nombre (De 2 - 150 caracteres).");
    }

    console.log (nuevoNombre);

    // Llamada a AJAX (Asíncrona)
	var URL = "editoriales/" + editorial.id;

    var request = new XMLHttpRequest(); // Crear request
    
    request.open('PUT', ENDPOINT + URL);   // Abrir llamada de tipo POST

    request.setRequestHeader("Content-type", "application/json"); // Dar formato JSON

    var formattedJsonData = JSON.stringify(nuevoNombre);   // Formatear JSON

    request.onreadystatechange  = function() {

        if (request.readyState == 4) {

            if (request.status === 200) {   
    
                cargarEditoriales("Editorial modificada.");
            } 
            else {  
                
                var responseError = JSON.parse(request.responseText);
                var liError;

                responseError.forEach(error => {
                    liError += "<li class='text-danger'>" + error + "</li>";
                });

                ulErrores.innerHTML = liError;
            }
        } 
    };   

    request.send(formattedJsonData);

}

function eliminarEditorial(pos, event) {

    event.stopPropagation();
    editorial = editoriales[pos];
    
    // Llamada a AJAX (Asíncrona)
    var URL = "editoriales";

   if (confirm(`¿Deseas eliminar ${editorial.nombre}?`)) {

        var request = new XMLHttpRequest(); // Crear request
        
        request.open('DELETE', ENDPOINT + URL + "/" + editorial.id);   // Abrir llamada de tipo DELETE

        request.onreadystatechange  = function() {

            if (request.readyState == 4) {

                if (request.status === 204) {   
        
                    cargarEditoriales("Editorial eliminada.");
                } 
                else {  
                    
                    mensaje.innerHTML = "La editorial no puede ser liminada porque tiene registros asociados.";
                }
            }  
        };   

    request.send();
    cargarEditoriales();

   }

   

}


