window.addEventListener("load", function(event){

    console.log("Todos los recursos terminaron de cargar, empezamos a jugar");

    const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
    var ulEditoriales = document.getElementById('ulEditoriales');
    var mensaje = document.getElementById('mensaje');
    var editoriales = [];

    //Vaciar la lista
    ulEditoriales.innerHTML = "";

    //Llamada a AJAX para obtener las editoriales
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {

        if(request.readyState === 4){

            if(request.status === 200){

                console.log('Response 200 ' + request.responseText);
                editoriales = JSON.parse(request.responseText);
                console.log('Editoriales %o', editoriales);

                var lis = "";
                editoriales.forEach(editorial => {
                    console.log(editorial);
                    lis += `<li onclick='detalleEditorial(${editorial})'> ${editorial.id} ${editorial.editorial} </li>`;
                });

                ulEditoriales.innerHTML = lis;
                mensaje.textContent = "";

            }

        }

    };

    request.open('GET', ENDPOINT + 'editoriales');
    request.send();

});

function detalleEditorial(editorial){
    const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {

        if(request.readyState === 4){

            if(request.status === 200){

                console.log('Response 200 ' + request.responseText);
               
                var lis = `<li> ${editorial.id} ${editorial.editorial} </li>`;
            

                ulEditoriales.innerHTML = lis;
                mensaje.textContent = "";

            }

        }

    };

    request.open('GET', ENDPOINT + 'editoriales/' + editorial.id);
    request.send();
}