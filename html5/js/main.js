//comentario de línea
/**
 * Función inicial que se ejecuta al cargar la página principal, 
 * mediante el elemento 'onload' del <BODY>
 */
function init(){
    console.log('Iniciado');
    
    setTimeout(function(){
        let loading = document.getElementById('loading');
        loading.innerHTML = "Ready";  
    },2000);
    
    


}