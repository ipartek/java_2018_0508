//comentario de línea
/**
 * Función inicial que se ejecuta al cargar la página principal, 
 * mediante el elemento 'onload' del <BODY>
 */
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous"></link>
function init(){
    console.log('Iniciado');
    
    setTimeout(function(){
        let loading = document.getElementById('loading');
        loading.innerHTML = "Ready";  
    },2000);
      
}

