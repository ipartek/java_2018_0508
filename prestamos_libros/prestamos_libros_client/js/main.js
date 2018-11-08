//Variables globales
const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var ulEditoriales = document.getElementById('ulEditoriales');
var cardGroup = document.getElementById('cardGroup');
var mensaje = document.getElementById('mensaje');
var editoriales = [];
var editorial;

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
                    lis += `<li onclick="editorialClick(${index}, event)" class="list-group-item"> ${editorial.id}: ${editorial.nombre}</li>`
                    
                    card += `<div class="col-lg-4 mb-4">
                    <div class="card h-100">
                        <h4 class="card-header">${editorial.nombre}</h4>
                        <div class="card-body">
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                        </div>
                        <div class="card-footer">
                        <a href="#" class="btn btn-primary">Learn More</a>
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
    document.querySelectorAll('#ulEditoriales li').forEach(el => el.classList.remove('active'));
    event.target.classList.add('active');
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
                console.warning('409 conflicto' + request.responseText);
            }
        }
      }; //onreadystatechange

    request.open('POST', ENDPOINT+'editoriales');

    //Especificar en cabeceras el tipo de contenido (como en el postman)
    request.setRequestHeader('content-type', 'application/json');

    //Enviar data si procede
    request.send(JSON.stringify(data));
}