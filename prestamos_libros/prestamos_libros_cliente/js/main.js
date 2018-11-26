var ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var editorial;
var errores = document.getElementById('ulErrores');

window.addEventListener("load", function(event) {

    console.log("Esta tooo pagado!!!");
    cargarEditoriales();
    //definimos el endpoint
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

  function listarEditoriales(){
    var tableEditoriales = document.getElementById("tableEditoriales");
    var tableAlumno = document.getElementById("tableAlumnos");
    var form = document.getElementById("formularioEditorial");



    form.style='display:none';
    tableEditoriales.style='display:table';
    tableAlumno.style='display:none';

    //location.reload();
    cargarEditoriales();
    
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

function CrearEditarAlumno(idAlumno,nombre){

    var tableEditorial = document.getElementById("tableEditoriales");
    var tableAlumno = document.getElementById("tableAlumnos");
    var form = document.getElementById("formularioAlumno");
    var ul = document.getElementById("ulEditoriales");

    document.getElementById("nombreAlumno").value=nombre;
    document.getElementById("idAlumno").value=idAlumno;
    tableEditorial.style='display:none';
    tableAlumno.style='display:none';
    form.style='display:block';
    ul.style='display:none';
}







/* menu laterial */
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
