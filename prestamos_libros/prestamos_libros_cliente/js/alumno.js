var ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var alumno;

function GuardarAlumno(){

    var nombreAlumno = document.getElementById("nombreAlumno").value;
    var idAlumno = document.getElementById("idAlumno").value;
    var accion ;
    var urlDinamica;

    var data = {"nombre":nombreAlumno};
    //Llamada ajax
    var request = new XMLHttpRequest();
   
    request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 201){
                editoriales =JSON.parse(request.responseText) ;
                console.log("201 Perfect");
                listarAlumnos();
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

    if(idAlumno == -1){
        accion = 'POST';
        urlDinamica = ENDPOINT+'alumnos';
    }else{
        accion = 'PUT';
        urlDinamica = ENDPOINT+'alumnos/'+idAlumno;
    }
    
    //peticion get
    request.open(accion, urlDinamica);

    request.setRequestHeader('content-type','application/json');
    //hacemos la llamada ya montada
    request.send(JSON.stringify(data));          
}

function cargarAlumnos(){
    //cojer la lista por id y la vacioamos
  var tbodyAlumnos = document.getElementById("tbodyAlumnos");
  var alumno = [];

  // vaciamos el listado
  tbodyAlumnos.innerHTML="";

  //Llamada ajax
  var request = new XMLHttpRequest();

  request.onreadystatechange = function() {
      console.log("Cambio de estado" + request.readyState);
      if(request.readyState == 4){
          if(request.status == 200){
              

              alumnos =JSON.parse(request.responseText) ;

              var lis = "";
              var bodyTr = "";
              alumnos.forEach( (alumno ,index) =>  {
                  
                  bodyTr += `
                                  <tr id="${alumno.id}" >
                                  <td id="${alumno.id}" value="${alumno.id}" >${alumno.id} </td>
                                  <td id="${alumno.nombre}" value="${alumno.nombre}" >${alumno.nombre} <i class="fas fa-trash-alt float-right text-danger ml-3 fa-lg" onclick="showConfirmationAlumno('${alumno.id}')"></i><i class="fas fa-pen float-right ml-3 fa-lg" onclick="CrearEditarAlumno('${alumno.id}','${alumno.nombre}')"></i></td>
                                  </tr>
                              `;
                  // lis += `<li id="${editorial.id}" class='list-group-item' onclick="editorialLi('${editorial.id}','${editorial.nombre}','${index}')">${editorial.id} : ${editorial.nombre}, indice : '${index}'<i class="fas fa-pen float-right" ></i> <i class="fas fa-trash-alt float-right text-danger" data-toggle="modal" onclick="showConfirmation('${editorial.id}')" ></i></li>`;
                  
              });
              tbodyAlumnos.innerHTML = bodyTr;

          }
      }
  }

  //peticion get
  request.open('Get', ENDPOINT+'alumnos');
  //hacemos la llamada ya montada
  request.send();
}


function listarAlumnos(){
    var tableEditoriales = document.getElementById("tableEditoriales");
    var tableAlumno = document.getElementById("tableAlumnos");
    var formEditorial = document.getElementById("formularioEditorial");
    var formAlumno = document.getElementById("formularioAlumno");



    formEditorial.style='display:none';
    formAlumno.style='display:none';
    tableEditoriales.style='display:none';
    tableAlumno.style='display:table';

    cargarAlumnos();
    
    
  }

  function eliminarAlumno(id){

    //Llamada ajax
    var request = new XMLHttpRequest();
    console.log("Pasamos por eliminar");
    request.onreadystatechange = function() {
        console.log("Cambio de estado" + request.readyState);
        if(request.readyState == 4){
            if(request.status == 200){
                editoriales =JSON.parse(request.responseText) ;
                console.log("201 Perfect");
                console.log(alumnos);
                listarAlumnos();
                
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
        }else{
            
        }
    };
     
    //peticion get
    request.open('DELETE', ENDPOINT+'alumnos/'+id);
    //hacemos la llamada ya montada
    request.send();
    listarAlumnos();
    }

    function showConfirmationAlumno(id) {
        var r = confirm("¿ Desea eliminar el registro ?!");
        if (r == true) {
            eliminarAlumno(id);
        } else {
            txt = "You pressed Cancel!";
        }
  }