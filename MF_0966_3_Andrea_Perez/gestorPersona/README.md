# Proyecto Gestion de personas


## TODO :
* Importar la base de datos gestor_persona.sql para crear la tabla.	
* Antes de arrancar la App se debe copiar la carpeta datosMigrar que está en la raiz del proyecto y pegarla en la unidad C. Ejemplo: <b>C:/datosMigrar/personas.txt</b>
  Está por defecto un fichero que contiene solo 5 registros de prueba,para cambiar la ruta donde lee la App, basta con ir al <b>GestorController.java</b> y buscar la función migrarDatos();

### Contenido:
* Buscador que hace varias busquedas a la vez en una unica SELECT por (dni, nombre, primer apellido,segundo apellido,email).
* Funcion que Lee de un fichero con registros y se insertan en la base de datos, al finalizar muestra un resumen con las filas leidas, insertadas y nº de errores.
* Formulario para crear nuevo registro y modificar al clicar sobre algun id de una persona en la DataTable.
