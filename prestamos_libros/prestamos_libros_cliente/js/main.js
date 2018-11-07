window.addEventListener("load", function(event) {

    console.log("Esta tooo pagado!!!");

    //definimos el endpoint
    var ENDPOINT = "http://localhost:8080/PrestamosAPI/";

    //cojer la lista por id y la vacioamos
    var ulEditoriales = document.getElementById("ulEditoriales");
    var mensaje = document.getElementById("loading");
    var editoriales = [];

    // vaciamos el listado
    ulEditoriales.innerHTML="";

    //Llamada ajax
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 200){
                

                editoriales =JSON.parse(request.responseText) ;

                var lis = "";

                editoriales.forEach(editorial => {
                    console.log(editorial);
                    lis += `<li>${editorial.id} : ${editorial.nombre}</li>`;
                    
                });
                ulEditoriales.innerHTML = lis;

                //console.log('editoriales %o',editoriales)
            }
            //console.log("");
        }else{
            //console.log("")
        }
    };

    //peticion get
    request.open('Get', ENDPOINT+'editoriales');
    //hacemos la llamada ya montada
    request.send();

  });