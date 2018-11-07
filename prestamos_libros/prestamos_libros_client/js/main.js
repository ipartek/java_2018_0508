window.addEventListener("load", function(event){
    console.log ("Todos los recursos de carga, comenzamos a jugara!!");

    const ENDPOINT="http://localhost:8080/PrestamosAPI/";
    var ulEditoriales = document.getElementById('ulEditoriales');
    var mensaje = document.getElementById('mensaje');
    var editoriales =[];

    // Vaciar lista con el comando innerHTML
    ulEditoriales.innerHTML="";

    //llamada AJAX para obtener editoriales
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if(request.readyState==4){
            if(request.status === 200){
                console.log('response 200' + request.responseText);
                editoriales = JSON.parse( request.responseText);
                console.log('editoriales %o', editoriales);

                var lis="";

                editoriales.forEach(editorial => {
                    lis += `<li>${editorial.id} ${editorial.nombre}</li>`;
                });
                ulEditoriales.innerHTML= lis;
                mensaje.textContent='';
            }
        }
    };


    request.open('GET', ENDPOINT + 'editoriales');
    request.send();

});