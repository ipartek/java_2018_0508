window.addEventListener("load", function(event) {
    console.log("Todos los recursos se han cargado, comenzar");

    const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
    var ulEditoriales = document.getElementById('ulEditoriales');
    var mensaje = document.getElementById('mensaje');
    var editoriales = [];

    //Vaciar lista
    ulEditoriales.innerHTML = "<li>Elemento</li>";

    //Llamada Ajax para obtener editoriales
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {
        console.log('Cambio de estado '+ request.readyState);
        if(request.readyState == 4){
            if(request.status === 200) { 
                console.log('response 200 '+ request.responseText);
                editoriales = JSON.parse(request.responseText);
                console.log('editoriales %o', editoriales);
                
                var lis = "";

                editoriales.forEach(editorial => {
                    console.log(editorial);
                    lis += "<li>"+editorial.id+": "+editorial.nombre+"</li>"
                    //lis += `<li> ${editorial.id}: ${editorial.nombre}</li>`
                });

                ulEditoriales.innerHTML = lis;
            } 
        }else{
            //console.error('No se ha podido realizar la llamada Ajax');
        }
      }

    request.open('GET', ENDPOINT+'editoriales');

    request.send();
});