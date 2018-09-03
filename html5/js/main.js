//comentario en linea


/**
 * funcion inicial que se ejecuta al cargar la página principal,
 * mediante el evento  'onload' del BODY
*/
function init(){
    console.log('Iniciado');
    setTimeout(function(){
        var texto =  document.getElementById('loading');
    texto.innerHTML = "Ready";
    }, 2000);
    
}