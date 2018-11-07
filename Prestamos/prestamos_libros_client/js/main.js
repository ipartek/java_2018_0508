window.addEventListener("load", function(event) {
  console.log("Todos los recursos terminaron de cargar, comenzamos a jugar");

  const ENDPOIN = "http://192.168.0.44:8080/PrestamosAPI/";
  var ulEditoriales = document.getElementById("editoriales");
  var mensaje = document.getElementById("mensaje");
  var editoriales = [];

  ulEditoriales.innerHTML = "<li>Elemento</li>";

  //llamada Ajax para obtener editoriales
  var request = new XMLHttpRequest();

  request.onreadystatechange = function() {
    if (request.readyState === 4) {
      if (request.status === 200) {
        console.log("response 200" + request.responseText);
        editoriales = JSON.parse(request.responseText);
        console.log("editoriales %o", editoriales);

        var lis="";
        editoriales.forEach(editorial => {
            //console.log(editorial);
            //lis += "<li>Elemento</li>";
            list += `<li> ${editorial.id} ${editorial.nombre}</li>`
        });

        ulEditoriales.innerHTML = lis;
        mensaje.textContent = '';
      }
    }
  };

  request.open("GET", ENDPOINT + "editoriales");
  request.send();
});
