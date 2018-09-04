//Comentarios una linea
/* 
comentarios multilinea
 */
/**
 * Funciobn inicial que se ejecuta al cargar pagina principal mediante el evento 'onload' deñ <body>
 */
function init(){
    console.log("Starting");
    setTimeout(funtion(){
        let loading = document.getElementById(loading);
        loading.innerHTML = "Ready";
    },2000);

    
}
