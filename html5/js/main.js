// Comentario de linea
// console.log('Debe aparecer');

/**
 * funcion inicial que se ejecuta al cargar
 * la pagina principal, mediante el evento 'onload' del <body> 
 */
function init(){
    console.log('Iniciado');

    setTimeout(function(){
        let loading = document.getElementById("loading");
        loading.innerHTML = "Ready";
    }, 2000);
    
}