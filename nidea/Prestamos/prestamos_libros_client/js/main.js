//variables globales
const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var ulEditoriales = document.getElementById('ulEditoriales');
var mensaje = document.getElementById('mensaje');
var errores = document.getElementById('ulErrores');
var editoriales = [];
var editorial;  //Editorial Seleccionada

//Document Ready
window.addEventListener("load", function(event) {
    console.log("Todos los recursos terminaron de cargar, comenzamos a jugar!");
    cargarEditoriales();
});



function cargarEditoriales( textoMensaje ){
    console.log('cargarEditoriales');
   
    ulEditoriales.innerHTML = "";                   //varciar lista    
    var request = new XMLHttpRequest();             //llamada Ajax 
    request.onreadystatechange = function() {
        if( request.readyState === 4 ){
            if ( request.status === 200 ){
                console.log('response 200 '  + request.responseText);
                editoriales = JSON.parse(request.responseText);
                console.log('editoriales %o', editoriales );

                var lis = "";
                editoriales.forEach( (editorial, index) => {                    
                    lis += `<li onclick="editorialClick(${index}, event)" class="list-group-item">
                                 ${editorial.id} ${editorial.nombre}                                  
                                 <i class="fas fa-trash-alt float-right text-danger" onclick="eliminar(${index}, event)"></i>                                 
                                 <i class="fas fa-pencil-alt float-right mr-3" onclick="editar(${index}, event)"></i>
                            </li>`;
                });
                ulEditoriales.innerHTML = lis;
                if ( textoMensaje ){
                    mensaje.innerHTML = textoMensaje;
                }else{
                    mensaje.textContent = '';
                }    
            }
        }        
    };//onreadystatechange  
    request.open('GET', ENDPOINT + 'editoriales');
    request.send();

}//cargarEditoriales


function editorialClick(posicion, event){
    console.log(`editorialClick ${posicion}`);   
    document.querySelectorAll('#ulEditoriales li').forEach( el => el.classList.remove('active'));      
    event.target.classList.add('active');
}

function crear(){

    var nombre = document.getElementById('iNombre').value;
    console.log(`click crear nombre= ${nombre}`);

    var data = {"nombre": nombre};                  //json a enviar
    var request = new XMLHttpRequest();             //llamada Ajax     
    request.onreadystatechange = function() {
        if( request.readyState === 4 ){
            if ( request.status === 201 ){
                console.log('response 201 '  + request.responseText);
                editorial = JSON.parse(request.responseText); 
                cargarEditoriales();               
            }
            if ( request.status === 409 ){
                console.warn('409 Conflicto ' + request.responseText);
                var responseError = JSON.parse(request.responseText);
                var lis = "";
                errores.innerHTML = "";
                errores.innerHTML = "<li>" + responseError.mensaje + "</li>";
                responseError.errores.forEach( el => {
                    lis += `<li>${el}</li>`; 
                });
                errores.innerHTML += lis;
            }    
        }        
    };//onreadystatechange  
    request.open('POST', ENDPOINT + 'editoriales'); 
    request.setRequestHeader('content-type','application/json');   
    request.send(JSON.stringify(data));

}//crear

function editar( posicion, event){

    event.stopPropagation();    
    editorial = editoriales[posicion];
    console.log('click editar editorial %o', editorial );

    var nuevoNombre = prompt("Dinos el nuevo nombre", editorial.nombre);
    console.debug('nuevoNombre= ' + nuevoNombre);
    if ( nuevoNombre != null ){

        var data = {"nombre": nuevoNombre};                  //json a enviar
        var request = new XMLHttpRequest();             //llamada Ajax     
        request.onreadystatechange = function() {
            if( request.readyState === 4 ){
                if ( request.status === 200 ){
                    console.log('response 200 '  + request.responseText);
                    editorial = JSON.parse(request.responseText); 
                    cargarEditoriales('Editorial cambiada !!!');  
                    //TODO como es asincrono cargarEditoriales() nos limpia el mensaje de abajo
                    // debemos usar PROMISES
                    // mensaje.textContent = 'Editorial cambiada !!!';             
                }
                if ( request.status === 409 ){
                    console.warn('409 Conflicto ' + request.responseText);
                    var responseError = JSON.parse(request.responseText);
                    var errores = "";
                    responseError.errores.forEach( el => {
                        errores += `${el}<br>`; 
                    });
                    mensaje.innerHTML = errores;
                }    
            }        
        };//onreadystatechange  
        request.open('PUT', ENDPOINT + 'editoriales/' + editorial.id); 
        request.setRequestHeader('content-type','application/json');   
        request.send(JSON.stringify(data));

    }// end ajax

}

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