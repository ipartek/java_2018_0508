//Variables locales
const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var ulEditoriales = document.getElementById('ulEditoriales');
var mensaje = document.getElementById('mensaje');
var editoriales = [];
var editorial;
var mensaje;

window.addEventListener("load", function (event) {
    console.log("Todos los recursos de carga, comenzamos a jugara!!");
    cargarEditoriales();

});

function cargarEditoriales() {
    // Vaciar lista con el comando innerHTML
    ulEditoriales.innerHTML = "";

    //llamada AJAX para obtener editoriales
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4) {
            if (request.status === 200) {
                console.log('response 200' + request.responseText);
                editoriales = JSON.parse(request.responseText);
                console.log('editoriales %o', editoriales);

                var lis = "";

                editoriales.forEach((editorial, index) => {
                    lis += `<li onclick="editorialClick(${index}, event)" class="list-group-item">
                                ${editorial.id} ${editorial.nombre}
                                <i class="fas fa-pencil-alt float-right"></i>
                                <i class="fas fa-trash float-right text-danger" onclick="eliminar(${index}, event)"></i>
                            </li>`;
                });
                ulEditoriales.innerHTML = lis;
                mensaje.textContent = '';
            }
        }
    };


    request.open('GET', ENDPOINT + 'editoriales');
    request.send();
}

function editorialClick(posicion, event) {
    console.log(`editorialClick ${posicion}`);
    //seleccionar li
    document.querySelectorAll('#ulEditoriales li').forEach(el => el.classList.remove('active'));
    event.target.classList.add('active');
}

function crear() {
    var nombre = document.getElementById('iNombre').value;
    var pmensaje = document.getElementById("pmensaje"); // Cogemos la referencia al nuestro div.
    console.log(`click crear nombre= ${nombre}`);

    var data = {
        "nombre": nombre
    }; //json a enviar

    var request = new XMLHttpRequest(); //lamada ajax

    request.onreadystatechange = function () {
        if (request.readyState == 4) {
            if (request.status === 201) {
                console.log('response 201' + request.responseText);
                editorial = JSON.parse(request.responseText);
                cargarEditoriales();
            }
            if (request.status === 409) {
                console.warn('409 Conflicto' + request.responseText);
                var responseError = JSON.parse(request.responseText);
                var lis = "";
                responseError.errores.forEach(el => {
                    lis += `<li>${el}</li>`
                });
                document.getElementById('ulErrores').innerHTML = lis;

            }
        }
    };
    request.open('POST', ENDPOINT + 'editoriales');
    request.setRequestHeader('content-type', 'application/json');
    request.send(JSON.stringify(data));
}//crear

function eliminar( posicion, event ){

    event.stopPropagation(); //@see https://javascript.info/bubbling-and-capturing
                            //@see inetresante leer sobre event.preventDefault
    editorial = editoriales[posicion];
    console.log('click eliminar editorial %o', editorial );

    if ( confirm(`¿Quieres Eliminar ${editorial.nombre}?`) ){
              
        var request = new XMLHttpRequest();             //llamada Ajax     
        request.onreadystatechange = function() {
            if( request.readyState === 4 ){
                if ( request.status === 200 ){
                    console.log('response 200 '  + request.responseText);                    
                    cargarEditoriales();               
                }
                if ( request.status === 409 ){
                    console.warn('409 Conflicto ' + request.responseText);
                    var responseError = JSON.parse(request.responseText);                   
                    mensaje.style.color = 'red';
                    mensaje.textContent = responseError.mensaje;                   
                }    
            }        
        };//onreadystatechange  
        request.open('DELETE', ENDPOINT + 'editoriales/' + editorial.id);         
        request.send();
    
    }
}  //eliminar 