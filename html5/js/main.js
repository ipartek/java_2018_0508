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

window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
