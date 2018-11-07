window.addEventListener("load", function(event) {
    console.log("Todos los recursos se han cargado, comenzar");

    const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
    var ulEditoriales = document.getElementById('ulEditoriales');
    var cardGroup = document.getElementById('cardGroup');
    var mensaje = document.getElementById('mensaje');
    var editoriales = [];

    //Vaciar lista
    //ulEditoriales.innerHTML = "<li>Elemento</li>";

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
                var card = "";

                editoriales.forEach(editorial => {
                    console.log(editorial);
                    lis += "<li>"+editorial.id+": "+editorial.nombre+"</li>"
                    //lis += `<li> ${editorial.id}: ${editorial.nombre}</li>`
                    
                    card += `<div class="col-lg-4 mb-4">
                    <div class="card h-100">
                        <h4 class="card-header">${editorial.nombre}</h4>
                        <div class="card-body">
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                        </div>
                        <div class="card-footer">
                        <a href="#" class="btn btn-primary">Learn More</a>
                        </div>
                    </div>
                    </div>`

                    
                });

                cardGroup.innerHTML = card;
                //ulEditoriales.innerHTML = lis;
            } 
        }else{
            //console.error('No se ha podido realizar la llamada Ajax');
        }
      }

    request.open('GET', ENDPOINT+'editoriales');

    request.send();
});