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

/**
 * Funciones utilizadas para mostrar y ocultar el menú en la vista móvil
 * en flex-layout.html
 */

var menu = document.getElementById('menu-mobile');
var menuMovil = document.getElementById('menu-movil');
var botonCerrar = document.getElementById('boton-cerrar');

function openMenu(){
    menu.style.width = '100%';
    menuMovil.style.display = 'block';
    botonCerrar.style.display = 'block';
}

function closeMenu(){
    menu.style.width = '0%'; 
    menuMovil.style.display = 'none'; 
    botonCerrar.style.display = 'none'; 
}