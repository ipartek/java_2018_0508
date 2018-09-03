function init() {
    console.log('iniciado');

    setTimeout (function(){
        let loading= document.getElementById('loading');
        loading.innerHTML="Ready";
    },2000)
   
}