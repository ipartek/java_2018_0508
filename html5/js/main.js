/**
 * Funcion inicial que se ejecuta al iniciar
 * la pagina principal, mediante el evento 'onload' del body
 */
function init() {
    console.log('Iniciado');

    setTimeout(function () {
        let parrafo = document.getElementById('loading');
        parrafo.innerHTML = "Ready";
    }, 2000);
}