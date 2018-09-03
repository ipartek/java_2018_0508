
/**
 * Funcion inicial que se ejecuta al cargar la pagina principal, mediante el evento "onload" del body
 */
function init(){
    console.log("Iniciado");
    setTimeout(() => {
        $("#loading").html("Ready");
        //let loading = document.getElementById("loading");
        //loading.innerHTML = "Ready";
    }, 2000);
   

}