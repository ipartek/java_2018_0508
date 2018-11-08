const ENDPOINT = "http://localhost:8080/PrestamosAPI/";
var ulEditoriales = document.getElementById("ulEditoriales");
var mensaje = document.getElementById("mensaje");
var editoriales = [];
var editorial;

window.addEventListener("load", function(event) {
  console.log("Todos los recursos terminaron de cargar, comenzamos a jugar!"); 
  //varciar lista
  ulEditoriales.innerHTML = "";

  //llamada Ajax para obtener Editoriales
  var request = new XMLHttpRequest();

  request.onreadystatechange = function() {
    if (request.readyState === 4) {
      if (request.status === 200) {
        console.log("response 200 " + request.responseText);
        editoriales = JSON.parse(request.responseText);
        console.log("editoriales %o", editoriales);

        var lis = "";
        editoriales.forEach((editorial, index) => {
          lis += `<li onclick="editorialClick(${index}, event)" class="list-group-item"> ${

            editorial.id
          } ${editorial.nombre} </li>`;
        });
        ulEditoriales.innerHTML = lis;
        mensaje.textContent = "";
      }
    }
  };

  request.open("GET", ENDPOINT + "editoriales");
  request.send();
});
function editorialClick(posicion, event) {
  console.log(`editorialClick ${posicion}`);
  //event.target.parentElement.children.forEach().remove('active');
  document
    .querySelectorAll("#ulEditoriales li")
    .forEach(el => el.classList.remove("active"));
  event.target.classList.add("active");
}


function crear() {
  var nombre = document.getElementById("iNombre").value;
  console.log(`click crear nombre= ${nombre}`);

var data = {"nombre": nombre}; //jason enviar

  var request = new XMLHttpRequest(); //llamada Ajax

  request.onreadystatechange = function() {
    if (request.readyState === 4) {
      if (request.status === 201) {
        console.log("response 201 " + request.responseText);
        editoriales = JSON.parse(request.responseText);
      }
      if (request.status === 409) {
        console.warn("409 Conflicto" + request.responseText);
      }
    }
  };

  request.open('POST', ENDPOINT + 'editoriales'); 
  request.setRequestHeader('content-type','application/json')
  request.send(JSON.stringify(data));//formato JSON 
}
