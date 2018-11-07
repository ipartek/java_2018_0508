var ENDPOINT = "http://localhost:8080/PrestamosAPI/";
window.addEventListener("load", function(event) {

    console.log("Ventana cargada.");

    cargarEditoriales();

});

function cargarEditoriales() {

    var ulEditoriales = document.getElementById("ulEditoriales");
    var progreso = document.getElementById("progreso");
    var editoriales = [];

    // Vaciar UL
    ulEditoriales.innerHTML = "";

    // Llamada a AJAX (Asíncrona)
	var URL = "editoriales";

    var request = new XMLHttpRequest();
    request.open('GET', ENDPOINT + URL);

    var li = "";

    request.onreadystatechange  = function() {
        if (request.readyState == 4) {

            if (request.status === 200) {   
    
                editoriales = JSON.parse(request.responseText);

                editoriales.forEach(editorial => {
                    li += "<li>" + editorial.nombre + "</li>"
                });

                ulEditoriales.innerHTML = li;
                progreso.innerHTML = "";
            } 
            else {  
                console.log('Petición fallada.  Devuelto estado ' + request.status);
            }
        } 
       
    };
    
    
    request.send();

}

