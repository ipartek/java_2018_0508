//comentario de linea
//console.log('Iniciado');

/**
 * Funcion inicial que se ejecuta al cargar 
 * la pagina principal, mediante el evento onload del <body>
 */

function init(){ 

    setTimeout(function(){
        let estado=document.getElementById('loading');
        estado.innerHTML="Ready";
    },2000)
}
