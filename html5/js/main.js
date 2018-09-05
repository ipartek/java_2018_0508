/**
 * Función inicial que se ejecuta el cargar la página principal mediante el evento onLoad()
 * de la etiqueta body.
 */
function init() {

    
    console.log("Iniciando...");

    setTimeout(function() { // Ralentizamos la función con setTimeout()
        
        var parrafo = document.getElementById("loading");
        parrafo.innerHTML = "Cargado.";

    }, 2000);
}


function showMenu() {
    
   
    document.getElementById("menu-mobile").style.display = "block";

}

function hideMenu() {

    document.getElementById("menu-mobile").style.display = "none";

}