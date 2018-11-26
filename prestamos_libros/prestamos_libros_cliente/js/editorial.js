function cargarEditoriales(texto){
    //cojer la lista por id y la vacioamos

    var tbodyEditoriales = document.getElementById("tbodyEditoriales");
    var editoriales = [];

    // vaciamos el listado

    tbodyEditoriales.innerHTML="";

    //Llamada ajax
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 200){
                

                editoriales =JSON.parse(request.responseText) ;

                var lis = "";
                var bodyTr = "";
                editoriales.forEach( (editorial ,index) =>  {
                    
                    bodyTr += `
                                    <tr id="${editorial.id}" >
                                    <td id="${editorial.id}" value="${editorial.id}" >${editorial.id} </td>
                                    <td id="${editorial.nombre}" value="${editorial.nombre}" >${editorial.nombre} <i class="fas fa-trash-alt float-right text-danger ml-3 fa-lg" data-toggle="modal" onclick="showModalForm(4, ${ editorial.id },3)" ></i><i class="fas fa-pen float-right ml-3 fa-lg" onclick="CrearEditarEditorial('${editorial.id}','${editorial.nombre}')"></i></td>
                                    </tr>
                                `;
                    
                });

                tbodyEditoriales.innerHTML = bodyTr;

            }
        }
    }

    //peticion get
    request.open('Get', ENDPOINT+'editoriales');
    //hacemos la llamada ya montada
    request.send();
  }

  function GuardarEditorial(){

    var nombreEditorial = document.getElementById("nombreEditorial").value;
    var idEditorial = document.getElementById("idEditorial").value;
    var accion ;
    var urlDinamica;

    var data = {"nombre":nombreEditorial};
    //Llamada ajax
    var request = new XMLHttpRequest();
   
    request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 201){
                editoriales =JSON.parse(request.responseText) ;
                console.log("201 Perfect");
                listarEditoriales();
            }
            if(request.status === 409) {
                console.log("409 Conflicto");
                var responseError = JSON.parse(request.responseText);
                var lis = "";
                errores.innerHTML = "";
                errores.innerHTML = "<li>" + responseError.mensaje + "</li>";
                responseError.errores.forEach( el => {
                    lis += `<li>${el}</li>`; 
                });
                errores.innerHTML += lis;
                
            }
        }      
    }

    if(idEditorial == -1){
        accion = 'POST';
        urlDinamica = ENDPOINT+'editoriales';
    }else{
        accion = 'PUT';
        urlDinamica = ENDPOINT+'editoriales/'+idEditorial;
    }
    
    //peticion get
    request.open(accion, urlDinamica);

    request.setRequestHeader('content-type','application/json');
    //hacemos la llamada ya montada
    request.send(JSON.stringify(data));          
}

function eliminarEditorial(id){
    $("#modalEliminar").modal('hide');
    //Llamada ajax
    var request = new XMLHttpRequest();
    console.log("Pasamos por eliminar");
    request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 200){
                editoriales =JSON.parse(request.responseText) ;
                console.log("201 Perfect");
                console.log(editoriales);
                listarEditoriales();
                
            }
            if(request.status === 409) {
                console.log("409 Conflicto");
                var responseError = JSON.parse(request.responseText);
                var lis = "";
                errores.innerHTML = "";
                errores.innerHTML = "<li>" + responseError.mensaje + "</li>";
                responseError.errores.forEach( el => {
                    lis += `<li>${el}</li>`; 
                });
                errores.innerHTML += lis;
                
            }
        }
    };
     
    //peticion get
    request.open('DELETE', ENDPOINT+'editoriales/'+id);
    //hacemos la llamada ya montada
    request.send();
    //listarEditoriales();
    }

    function showConfirmation(id) {
        var r = confirm("¿ Desea eliminar el registro ?!");
        if (r == true) {
            eliminarEditorial(id);
        } else {
            txt = "You pressed Cancel!";
        }
  }