var ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var editorial;

window.addEventListener("load", function(event) {

    console.log("Esta tooo pagado!!!");

    //definimos el endpoint
    

    //cojer la lista por id y la vacioamos
    var ulEditoriales = document.getElementById("ulEditoriales");
    var tbodyEditoriales = document.getElementById("tbodyEditoriales");
    var editoriales = [];

    // vaciamos el listado
    ulEditoriales.innerHTML="";
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
                                    <td id="${editorial.id}" value="${editorial.id}" onclick="editorialId(${editorial.id})">${editorial.id} </td>
                                    <td id="${editorial.nombre}" value="${editorial.nombre}" onclick="editorialNombre('${editorial.nombre}')" >${editorial.nombre} <i class="fas fa-trash-alt float-right text-danger ml-3 fa-lg" onclick="showConfirmation('${editorial.id}')"></i><i class="fas fa-pen float-right ml-3 fa-lg" onclick="editoraEditorial('${editorial.id}','${editorial.nombre}')"></i></td>
                                    </tr>
                                `;
                    lis += `<li id="${editorial.id}" class='list-group-item' onclick="editorialLi('${editorial.id}','${editorial.nombre}','${index}')">${editorial.id} : ${editorial.nombre}<i class="fas fa-pen float-right" ></i> <i class="fas fa-trash-alt float-right text-danger" data-toggle="modal" onclick="showConfirmation('${editorial.id}')" ></i></li>`;
                    
                });
                ulEditoriales.classList.add('list-group');
                ulEditoriales.innerHTML = lis;
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

  function editorialLi(id,nombre,index){
      console.log(id ,+" "+ nombre, +" "+ index);
      //document.querySelector('#ulEditoriales li').foreach(el =>{
      //  console.log(el);
      //});
  }

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
    var ul = document.getElementById("ulEditoriales");


    form.style='display:none';
    table.style='display:table';
    ul.style='display:block';
    location.reload();
    
  }

  function crearEditorial(){
    var table = document.getElementById("tableEditoriales");
    var form = document.getElementById("formularioEditorial");
    var ul = document.getElementById("ulEditoriales");
    var idEditorial = document.getElementById("idEditorial");
    table.style='display:none';
    form.style='display:inline';
    ul.style='display:none';
    }

function GuardarEditorial(){

    var nombreEditorial = document.getElementById("nombreEditorial").value;
    var idEditorial = document.getElementById("idEditorial").value;
    if(idEditorial == 'idEditorial'){
        idEditorial = -1;
    }
    
    var data = {"nombre":nombreEditorial};
    //Llamada ajax
    var request = new XMLHttpRequest();

    if (idEditorial == -1){
        request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 201){
                editoriales =JSON.parse(request.responseText) ;
                console.log("201 Perfect");
                listar();
            }
            if(request.status === 409) {
                console.log("409 Conflicto");
                var responseError = JSON.parse(request.responseText);
                var lis = "";
                console.log(responseError);
                
            }
        }
        
    };

    //peticion get
    request.open('POST', ENDPOINT+'editoriales');

    request.setRequestHeader('content-type','application/json');
    //hacemos la llamada ya montada
    request.send(JSON.stringify(data));
           
   
}else{
    editaEditorial(nombreEditorial,idEditorial);
}
}

function editaEditorial(){

    var nombreEditorial = document.getElementById("nombreEditorial").value;
    var idEditorial = document.getElementById("idEditorial").value;

    
    var data = {"nombre":nombreEditorial};
    //Llamada ajax
    var request = new XMLHttpRequest();

    if (idEditorial != -1){
        request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 201){
                editoriales =JSON.parse(request.responseText) ;
                console.log("201 Perfect");
                listar();
            }
            if(request.status === 409) {
                console.log("409 Conflicto");
                var responseError = JSON.parse(request.responseText);
                var lis = "";
                console.log(responseError);
                
            }
        }
        
    }

    //peticion get
    request.open('PUT', ENDPOINT+'editoriales/'+idEditorial);

    request.setRequestHeader('content-type','application/json');
    //hacemos la llamada ya montada
    request.send(JSON.stringify(data));
    listar();
    }
}

function eliminarEditorial(id){

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
                
            }
            if(request.status === 409) {
                console.log("409 Conflicto");
                
            }
        }else{
            
        }
    };
    listar(); 
    //peticion get
    request.open('DELETE', ENDPOINT+'editoriales/'+id);
    //hacemos la llamada ya montada
    request.send();
    
    }

    
          
   


function editoraEditorial(ideditorial,nombre){
    console.log(ideditorial);
    var table = document.getElementById("tableEditoriales");
    var form = document.getElementById("formularioEditorial");
    var ul = document.getElementById("ulEditoriales");
    document.getElementById("nombreEditorial").value=nombre;
    document.getElementById("idEditorial").value=ideditorial;
    table.style='display:none';
    form.style='display:inline';
    ul.style='display:none';
    

    
    
}


  function showConfirmation(id) {
        var r = confirm("¿ Desea eliminar el registro ?!");
        if (r == true) {
            eliminarEditorial(id);
        } else {
            txt = "You pressed Cancel!";
        }
  }


  