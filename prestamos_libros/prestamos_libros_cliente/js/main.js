var ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var editorial;
var errores = document.getElementById('ulErrores');

window.addEventListener("load", function(event) {

    console.log("Esta tooo pagado!!!");
    cargarEditoriales();
    //definimos el endpoint
});
    
function cargarEditoriales(texto){
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
                                    <td id="${editorial.id}" value="${editorial.id}" >${editorial.id} </td>
                                    <td id="${editorial.nombre}" value="${editorial.nombre}" >${editorial.nombre} <i class="fas fa-trash-alt float-right text-danger ml-3 fa-lg" onclick="showConfirmation('${editorial.id}')"></i><i class="fas fa-pen float-right ml-3 fa-lg" onclick="CrearEditarEditorial('${editorial.id}','${editorial.nombre}')"></i></td>
                                    </tr>
                                `;
                    lis += `<li id="${editorial.id}" class='list-group-item' onclick="editorialLi('${editorial.id}','${editorial.nombre}','${index}')">${editorial.id} : ${editorial.nombre}, indice : '${index}'<i class="fas fa-pen float-right" ></i> <i class="fas fa-trash-alt float-right text-danger" data-toggle="modal" onclick="showConfirmation('${editorial.id}')" ></i></li>`;
                    
                });
                ulEditoriales.classList.add('list-group');
                ulEditoriales.innerHTML = lis;
                tbodyEditoriales.innerHTML = bodyTr;

            }
        }
    }

    //peticion get
    request.open('Get', ENDPOINT+'editoriales');
    //hacemos la llamada ya montada
    request.send();
  }


    

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

  function listarEditoriales(){
    var tableEditoriales = document.getElementById("tableEditoriales");
    var tableAlumno = document.getElementById("tableAlumnos");
    var form = document.getElementById("formularioEditorial");
    var ul = document.getElementById("ulEditoriales");


    form.style='display:none';
    tableEditoriales.style='display:table';
    tableAlumno.style='display:none';
    ul.style='display:block';
    location.reload();
    
  }

  function listarAlumnos(){
    var tableEditoriales = document.getElementById("tableEditoriales");
    var tableAlumno = document.getElementById("tableAlumnos");
    var form = document.getElementById("formularioEditorial");
    var ul = document.getElementById("ulEditoriales");


    form.style='display:none';
    tableEditoriales.style='display:none';
    tableAlumno.style='display:table';
    ul.style='display:none';
    cargarAlumnos();
    
  }

  function cargarAlumnos(){
      //cojer la lista por id y la vacioamos
    var tbodyAlumnos = document.getElementById("tbodyAlumnos");
    var alumnos = [];

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
                                    <td id="${alumno.nombre}" value="${alumno.nombre}" >${alumno.nombre} <i class="fas fa-trash-alt float-right text-danger ml-3 fa-lg" onclick="showConfirmation('${alumno.id}')"></i><i class="fas fa-pen float-right ml-3 fa-lg" onclick="CrearEditarEditorial('${alumno.id}','${alumno.nombre}')"></i></td>
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

  

function CrearEditarEditorial(ideditorial,nombre){

    var tableEditorial = document.getElementById("tableEditoriales");
    var tableAlumno = document.getElementById("tableAlumnos");
    var form = document.getElementById("formularioEditorial");
    var ul = document.getElementById("ulEditoriales");

    document.getElementById("nombreEditorial").value=nombre;
    document.getElementById("idEditorial").value=ideditorial;
    tableEditorial.style='display:none';
    tableAlumno.style='display:none';
    form.style='display:block';
    ul.style='display:none';
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
                listarEditoriales()
                
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
    request.open('DELETE', ENDPOINT+'editoriales/'+id);
    //hacemos la llamada ya montada
    request.send();
    
    }

  function showConfirmation(id) {
        var r = confirm("¿ Desea eliminar el registro ?!");
        if (r == true) {
            eliminarEditorial(id);
        } else {
            txt = "You pressed Cancel!";
        }
  }

  function editorialGrupo(){
      var divSubbotones = document.getElementById('editorialGrupo');
      if (divSubbotones.style.display == 'none' || divSubbotones.style.display == ''){
        divSubbotones.style.display = 'block';
      }else{
        divSubbotones.style.display = 'none';
      }
      
  }
  function alumnoGrupo(){
    var divSubbotones = document.getElementById('alumnoGrupo');
    if (divSubbotones.style.display == 'none' || divSubbotones.style.display == ''){
      divSubbotones.style.display = 'block';
    }else{
      divSubbotones.style.display = 'none';
    }
    
}
function libroGrupo(){
    var divSubbotones = document.getElementById('libroGrupo');
    if (divSubbotones.style.display == 'none' || divSubbotones.style.display == ''){
      divSubbotones.style.display = 'block';
    }else{
      divSubbotones.style.display = 'none';
    }
    
}
function prestamoGrupo(){
    var divSubbotones = document.getElementById('prestamoGrupo');
    if (divSubbotones.style.display == 'none' || divSubbotones.style.display == ''){
      divSubbotones.style.display = 'block';
    }else{
      divSubbotones.style.display = 'none';
    }
    
}
