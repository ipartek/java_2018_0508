var ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var ulEditoriales = document.getElementById("ulEditoriales");
var editoriales = [];
var editorial;

window.addEventListener("load", function(event) {

    console.log("Ventana cargada.");

    cargarEditoriales();

});

function cargarEditoriales() {

    // Vaciar UL
    ulEditoriales.innerHTML = "";

    // Llamada a AJAX (Asíncrona)
    var URL = "editoriales";
    editoriales = [];

    var request = new XMLHttpRequest();
    request.open('GET', ENDPOINT + URL);

    var li = "";

    request.onreadystatechange  = function() {
        if (request.readyState == 4) {

            if (request.status === 200) {   
    
                editoriales = JSON.parse(request.responseText); // Parsear a JSON
                
                for (var i = 0, len = editoriales.length; i < len; i++) {
                      li += `<li id= ${editoriales[i].id} class='list-group-item'> ${editoriales[i].nombre} <a class='btn btn-xs btn-danger float-right ml-2' onclick='eliminarEditorial( ${i}, event );'> Eliminar </a> <a class='btn btn-xs btn-success float-right ml-2' onclick='showTabModificar( ${i} );'> Modificar </a> </li>`
                }

                ulEditoriales.innerHTML = li;

                addClickListenerLIActive(event);
            } 
        } 
       
    };   
    request.send();
}

function removeActiveClassFromEditoriales() {

	var children = ulEditoriales.children;
    
    for (var i = 0; i < children.length; i++) {  
        var child = children[i];
        child.classList.remove("active");
    }
}

function addClickListenerLIActive(e) {

    ulEditoriales.addEventListener("click", function(e) {
        
        removeActiveClassFromEditoriales();

        if(e.target && e.target.nodeName == "LI") {
            e.target.classList.add("active");
        }

    });
}

function crearEditorial() {

    var inputNombre = document.getElementById("editorialNombre");

    // Llamada a AJAX (Asíncrona)
	var URL = "editoriales";

    var request = new XMLHttpRequest(); // Crear request
    
    request.open('POST', ENDPOINT + URL);   // Abrir llamada de tipo POST

    request.setRequestHeader("Content-type", "application/json"); // Dar formato JSON

    var nombre = inputNombre.value; // Recoger valor del input
    
    var data = {nombre};    // Añadimos llaves

    var formattedJsonData = JSON.stringify(data);   // Formatear JSON

    request.onreadystatechange  = function() {

        if (request.readyState == 4) {

            if (request.status === 201) {   
    
                console.log("Editorial creada.");
            } 
            else {  
                
                var responseError = JSON.parse(request.responseText);
                var liError;

                responseError.forEach(error => {
                    liError += "<li class='text-danger'>" + error + "</li>";
                });

                document.getElementById("editorialError").innerHTML = liError;
            }
        } 
    };   

    request.send(formattedJsonData);

}

function showTabModificar(i) {

    var inputNombre = document.getElementById("editorialNombre");
    inputNombre.value = editoriales[i].nombre;
    $('#nav-crear-tab').tab('show');

    btnGo = document.getElementById("btnGo");
    btnGo.innerHTML = "Guardar";
    btnGo.addEventListener("click", function() {
        modificarEditorial(i);
    });
}

function modificarEditorial(i) {


    // Llamada a AJAX (Asíncrona)
	var URL = "editoriales";

    var request = new XMLHttpRequest(); // Crear request
    
    request.open('PUT', ENDPOINT + URL);   // Abrir llamada de tipo POST

    request.setRequestHeader("Content-type", "application/json"); // Dar formato JSON

    var nombre = inputNombre.value; // Recoger valor del input
    
    var data = {nombre};    // Añadimos llaves

    var formattedJsonData = JSON.stringify(data);   // Formatear JSON

    request.onreadystatechange  = function() {

        if (request.readyState == 4) {

            if (request.status === 201) {   
    
                console.log("Editorial creada.");
            } 
            else {  
                
                var responseError = JSON.parse(request.responseText);
                var liError;

                responseError.forEach(error => {
                    liError += "<li class='text-danger'>" + error + "</li>";
                });

                document.getElementById("editorialError").innerHTML = liError;
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
        
                    console.log("Editorial eliminada.");
                } 
                else {  
                    
                    console.warn("Conflicto: " + request.responseText);
                }
            }  
        };   

    request.send();
    cargarEditoriales();

   }

   

}


