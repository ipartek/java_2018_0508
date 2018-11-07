window.addEventListener("load", function(event) {

    console.log("Todos los recursos terminaron de cargar, comenzamos a jugar!");

    const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
    var ulEditoriales = document.getElementById('ulEditoriales');
    var mensaje = document.getElementById('mensaje');
    var editoriales = [];

    //varciar lista
    ulEditoriales.innerHTML = "";

    //llamada Ajax para obtener Editoriales
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {

        if( request.readyState === 4 ){

            if ( request.status === 200 ){

                console.log('response 200 '  + request.responseText);
                editoriales = JSON.parse(request.responseText);
                console.log('editoriales %o', editoriales );

                var lis = "";
                editoriales.forEach( editorial => {                    
                    lis += `<li> ${editorial.id} ${editorial.nombre} </li>`;
                });
                ulEditoriales.innerHTML = lis;
                mensaje.textContent = '';
            }

        }
        
    };    

    request.open('GET', ENDPOINT + 'editoriales');
    request.send();


});