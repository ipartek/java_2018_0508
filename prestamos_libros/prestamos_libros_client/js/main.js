//Variables globales
const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var ulEditoriales = document.getElementById('ulEditoriales');
var cardGroup = document.getElementById('cardGroup');
var mensaje = document.getElementById('mensaje');
var alerta = document.getElementById('alerta');
var editoriales = [];
var editorial;
var error;

//Document Ready
window.addEventListener("load", function(event) {    
    console.log("Todos los recursos se han cargado, comenzar");
    cargarEditoriales();

    //Vaciar lista
    //ulEditoriales.innerHTML = "<li>Elemento</li>";
});

function cargarEditoriales(){
    
    //Llamada Ajax para obtener editoriales
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {
        console.log('Cambio de estado '+ request.readyState);
        if(request.readyState == 4){
            if(request.status === 200) { 
                console.log('response 200 '+ request.responseText);
                editoriales = JSON.parse(request.responseText);
                console.log('editoriales %o', editoriales);
                
                var lis = "";
                var card = "";

                editoriales.forEach((editorial, index) => {
                    console.log(editorial);
                    //lis += "<li class=list-group-item>"+editorial.id+": "+editorial.nombre+"</li>"
                    lis += `<li onclick="editorialClick(${index}, event)" class="list-group-item">
                    <div class="row justify-content-around">
                        <div class="col">
                            ${editorial.id}: ${editorial.nombre}
                        </div>
                        <div class="col text-right">
                            <i onclick="editarEditorial(${editorial.id}, ${editorial.nombre}, event)" class="fas fa-pencil-alt text-success"></i>
                        </div>
                        <div class="col text-right">
                            <i onclick="eliminarEditorial(${editorial.id},event)" class="fas fa-trash-alt text-danger"></i>
                        </div>
                    </div>
                    </li>`
                    
                    card += `<div class="col-lg-4 mb-4">
                    <div class="card h-100">
                        <h4 class="card-header">${editorial.nombre}</h4>
                        <div class="card-body">
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                        </div>
                        <div class="card-footer">
                            <div class="row justify-content-between">
                                <div class="col">
                                    <a href="#" onclick="editarEditorial(${editorial.id}, ${editorial.nombre}, event)" class="btn btn-primary">Editar</a>
                                </div>
                                <div class="col text-right">
                                    <a onclick="eliminarEditorial(${editorial.id},event)" href="#" class="btn btn-danger">Eliminar</a>
                                </div>
                            </div>
                        
                        
                        </div>
                    </div>
                    </div>`
                });

                cardGroup.innerHTML = card;
                ulEditoriales.innerHTML = lis;
                mensaje.textContent = '';
            } 
        }
    }//onreadystatechange  

    request.open('GET', ENDPOINT+'editoriales');

    request.send();
}

function editorialClick(posicion, event){
    console.log(`editorialClick ${posicion}`);
    var lis = document.querySelectorAll('#ulEditoriales li');
    lis.forEach(el => el.classList.remove('active'));
    lis[posicion].classList.add('active');
}

function crear(){
    var nombre = document.getElementById('iNombre').value;
    console.log(`click crear nombre ${nombre}`);

    //Cambiar formato de datos a json
    var data = {"nombre": nombre};

    //Llamada Ajax para obtener editoriales
    var request = new XMLHttpRequest();    

    request.onreadystatechange = function() {
        console.log('Cambio de estado '+ request.readyState);
        if(request.readyState == 4){
            if(request.status === 201) { 
                console.log('response 201 '+ request.responseText);
                editorial = JSON.parse(request.responseText);
                cargarEditoriales();
            }
            if(request.status === 409){
                error = JSON.parse(request.responseText);
                var contenido = `<div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <p>${error.mensaje}</p>
                                <p>${error.errores}</p>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                                </button>
                            </div>`;
                alerta.innerHTML = contenido;
                console.warn('409 conflicto' + request.responseText);
            }
        }
      }; //onreadystatechange

    request.open('POST', ENDPOINT+'editoriales');

    //Especificar en cabeceras el tipo de contenido (como en el postman)
    request.setRequestHeader('content-type', 'application/json');

    //Enviar data si procede
    request.send(JSON.stringify(data));
}

function eliminarEditorial(idEditorial, event){
    event.stopImmediatePropagation();


    if(confirm(`¿Quieres eliminar este registro?`)){
        //Llamada Ajax para obtener editoriales
        var request = new XMLHttpRequest();    

        request.onreadystatechange = function() {
            console.log('Cambio de estado '+ request.readyState);
            if(request.readyState == 4){
                if(request.status === 200) { 
                    console.log('response 200 '+ request.responseText);
                    cargarEditoriales();
                }
                if(request.status === 409){
                    console.warn('409 conflicto' + request.responseText);
                    error = JSON.parse(request.responseText);
                    var contenido = `<div class="alert alert-danger alert-dismissible fade show" role="alert">
                                    <p>${error.mensaje}</p>
                                    <p>${error.errores}</p>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>`;
                    alerta.innerHTML = contenido;
                }

                if(request.status === 404){
                    console.warn('404 error' + request.responseText);
                    error = JSON.parse(request.responseText);
                    var contenido = `<div class="alert alert-danger alert-dismissible fade show" role="alert">
                                    <p>${error.mensaje}</p>
                                    <p>${error.errores}</p>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>`;
                    alerta.innerHTML = contenido;
                }
            }
        }; //onreadystatechange

        request.open('DELETE', ENDPOINT+'editoriales/'+idEditorial);

        //Enviar data si procede
        request.send();
    }
}

function editarEditorial(id, nombre, event){

}