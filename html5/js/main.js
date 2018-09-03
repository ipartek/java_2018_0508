//Comentario de linea

/**
 * Función inicial que se ejecuta al cargar la página principal,
 *  mediante el evento 'onload' del <body>
 */

function init(){
    console.log('Iniciado');
    setTimeout(function(){
        let loading = document.getElementById('loading');
        loading.innerHTML = "Ready";
    }, 2000);
}