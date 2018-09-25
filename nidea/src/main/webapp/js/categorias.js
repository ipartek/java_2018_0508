// Función para Cargar Categorías al campo <select>
function cargar_categorias() {
 var array = ["Cantabria", "Asturias", "Galicia", "Andalucia", "Extremadura"];

 // Ordena el Array Alfabeticamente, es muy facil ;)):
 array.sort();

 addOptions("provincia", array);
}

// Rutina para agregar opciones a un <select>
function addOptions(domElement, array) {
 var select = document.getElementsByName(domElement)[0];

 for (value in array) {
  var option = document.createElement("option");
  option.text = array[value];
  select.add(option);
 }
}