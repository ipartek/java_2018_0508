
//variables globales
const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var ulEditoriales = document.getElementById('ulEditoriales');
var mensaje = document.getElementById('mensaje');
var editoriales = [];
var editorial;

//Document Ready
window.addEventListener("load", function(event) {
    console.log("Todos los recursos terminaron de cargar, comenzamos a jugar!");
    cargarEditoriales();
});



function cargarEditoriales(){
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
                    lis += `<li onclick="editorialClick(${index}, event)" class="list-group-item"> ${editorial.id} ${editorial.nombre} </li>`;
                });
                ulEditoriales.innerHTML = lis;
                mensaje.textContent = '';
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
                console.warning('409 Conflicto ' + request.responseText);
            }    
        }        
    };//onreadystatechange  
    request.open('POST', ENDPOINT + 'editoriales'); 
    request.setRequestHeader('content-type','application/json');   
    request.send(JSON.stringify(data));

}