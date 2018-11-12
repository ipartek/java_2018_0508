// Variables globales
    const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
    var ulEditoriales = document.getElementById('ulEditoriales');
    var editoriales = [];
    var editorial;
    var mensaje = document.getElementById('mensaje');

window.addEventListener("load", function(event){

    console.log("Todos los recursos terminaron de cargar, empezamos a jugar");
    cargarEditoriales();
    
});

function cargarEditoriales(){
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
                editoriales.forEach( (editorial, index) => {
                    console.log(editorial);
                    lis += `<li class='list-group-item' onclick='editorialClick(${index}, event)'> 
                                ${editorial.id} ${editorial.editorial} 
                                <i class='fas fa-trash-alt float-right text-danger' onclick='eliminar(${index}, event)'></i>
                                <i class='fas fa-pencil-alt float-right text-warning mr-3' onclick='modificar(${index}, event)'></i>
                            </li>`;
                });

                ulEditoriales.innerHTML = lis;

            }

        }

    };

    request.open('GET', ENDPOINT + 'editoriales');
    request.send();
}

function editorialClick(posicion, event){
    console.log(`Hemos hecho click en la editorial ${posicion}`);
    /*
    event.target.parentElement.children.array.forEach(element => {
        element.classList.remove('active');
    });
    */

    // querySelectorAll recoge todos los elementos (pones las reglas/etiquetas a lo css).
    document.querySelectorAll('#ulEditoriales li').forEach(
        element => element.classList.remove('active')
    );

    // Target es el elemento al que se le aplica el evento.   
    event.target.classList.add('active');

}

function crear(){
    var nombre = document.getElementById('idNombre').value;
    console.log(`click crear nombre => ${nombre}`);

    var msgError = document.getElementById('ulErrores');

    // JSON a enviar
    var data = {"editorial" : nombre};

    //Llamada a AJAX
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {

        if(request.readyState === 4){

            if(request.status === 201){

                console.log('Response 201 ' + request.responseText);
                editorial = JSON.parse(request.responseText);
                cargarEditoriales();
                msgError.innerHTML = "";

            }
            if(request.status === 409){
                console.warn('409 Conflicto ' + request.responseText);

                var responseError = JSON.parse(request.responseText);

                var lis = "";

                responseError.errores.forEach(error => {
                    lis += `<li>${error}</li>`
                });

                msgError.innerHTML = lis;
                msgError.style.color = '#f00';
            }

        }

    };

    request.open('POST', ENDPOINT + 'editoriales');
    request.setRequestHeader('content-type', 'application/json');
    request.send(JSON.stringify(data));

}

function eliminar(posicion, event){

    event.stopPropagation(); // @see https://developer.mozilla.org/es/docs/Web/API/Event/stopPropagation
                            // @see Leer sobre event.preventDefault(); https://developer.mozilla.org/es/docs/Web/API/Event/preventDefault

    editorial = editoriales[posicion];
    console.log('Editorial a eliminar %o', editorial);
    var confirmar = confirm(`¿Quieres eliminar ${editorial.editorial} ?`);

    if(confirmar){
    //Llamada a AJAX
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {

        if(request.readyState === 4){

            if(request.status === 200){

                console.log('Response 200 ' + request.responseText);
                cargarEditoriales();

            }
            if(request.status === 409){
                console.warn('409 Conflicto ' + request.responseText);

                var responseError = JSON.parse(request.responseText);
                mensaje.textContent = this.responseError.mensaje;
            }

        }

    };

    request.open('DELETE', ENDPOINT + 'editoriales/' + editorial.id);
    request.setRequestHeader('content-type', 'application/json');
    request.send();

    }

}
function modificar(posicion, event){

    event.stopPropagation(); // @see https://developer.mozilla.org/es/docs/Web/API/Event/stopPropagation
                            // @see Leer sobre event.preventDefault(); https://developer.mozilla.org/es/docs/Web/API/Event/preventDefault
    
    editorial = editoriales[posicion];
    console.log('Editorial a modificar %o', editorial);

    var nombre = prompt(`Modificar editorial ${editorial.editorial}`, 'Nuevo nombre de la editorial');

    // JSON a enviar
    var data = {"editorial" : nombre};
    
    if(nombre != null || nombre != ""){
    //Llamada a AJAX
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
    
        if(request.readyState === 4){
    
             if(request.status === 200){
    
                console.log('Response 200 ' + request.responseText);
                cargarEditoriales();
    
            }
            if(request.status === 409){
                console.warn('409 Conflicto ' + request.responseText);
            }
    
        }
    
    };
    
    request.open('PUT', ENDPOINT + 'editoriales/' + editorial.id);
    request.setRequestHeader('content-type', 'application/json');
    request.send(JSON.stringify(data));

    }

}
