//COMENTARIO LINEA
/*COMENTARIO DE BLOQUE*/

/**
 * Funcion inicial que se ejecuta al cargar la pagina principal
 * mediante el evento 'onload' del <body>
 */
function init() {
    console.log('iniciado');

    setTimeout (function(){
        let loading= document.getElementById('loading');
        loading.innerHTML="Ready";
    },2000)
   
}