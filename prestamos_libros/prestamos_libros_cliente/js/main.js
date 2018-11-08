var ENDPOINT = "http://localhost:8080/PrestamosAPI/";

window.addEventListener("load", function(event) {

    console.log("Esta tooo pagado!!!");

    //definimos el endpoint
    

    //cojer la lista por id y la vacioamos
    //var ulEditoriales = document.getElementById("ulEditoriales");
    var tbodyEditoriales = document.getElementById("tbodyEditoriales");
    var editoriales = [];

    // vaciamos el listado
    //ulEditoriales.innerHTML="";
    tbodyEditoriales.innerHTML="";

    //Llamada ajax
    var request = new XMLHttpRequest();

    request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 200){
                

                editoriales =JSON.parse(request.responseText) ;

                //var lis = "";
                var bodyTr = "";
                editoriales.forEach(editorial => {
                
                    bodyTr += `
                                    <tr id="${editorial.id}">
                                    <td id="${editorial.id}" value="${editorial.id}" onclick="editorialId(${editorial.id})">${editorial.id} </td>
                                    <td id="${editorial.nombre}" value="${editorial.nombre}" onclick="editorialNombre('${editorial.nombre}')" >${editorial.nombre} </td>
                                    </tr>
                                `;
                    //lis += `<li>${editorial.id} : ${editorial.nombre}</li>`;
                    
                });
                //ulEditoriales.innerHTML = lis;
                tbodyEditoriales.innerHTML = bodyTr;

            }
        }else{
            
        }
    };

    //peticion get
    request.open('Get', ENDPOINT+'editoriales');
    //hacemos la llamada ya montada
    request.send();

    


  });

  function editorialId(id){

    console.log("Click sobre el id: "+id);

  }

  function editorialNombre(nombre){

    console.log("Click sobre el nombre: "+nombre);
    
  }

  function crearModificarEditorial(accion){

    var table = document.getElementById("tableEditoriales");
    var form = document.getElementById("formularioEditorial");
    table.style='display:none';
    form.style='display:inline';
    if (accion > 0){

        
    } else{
        crearEditorial();
    }
    
  }

  function listar(){
    var table = document.getElementById("tableEditoriales");
    var form = document.getElementById("formularioEditorial");
    
    form.style='display:none';
    table.style='display:table';
    location.reload();
    
  }

  function crearEditorial(){
    var table = document.getElementById("tableEditoriales");
    var form = document.getElementById("formularioEditorial");

    table.style='display:none';
    form.style='display:inline';
    };

function GuardarEditorial(){
    
    var request = new XMLHttpRequest();
    var nombreEditorial = document.getElementById("nombreEditorial").value;
    console.log(nombreEditorial);
    console.log("*****************************************************");
    var obj = {nombre : nombreEditorial};
    var myJSON = JSON.stringify(obj);
    
                console.log("Cambio de estado" + request.readyState);

                    
                //peticion get

                request.open('POST', ENDPOINT+'editoriales', true);
                //hacemos la llamada ya montada
                request.send(myJSON);
           
    //listar();
}

    


  