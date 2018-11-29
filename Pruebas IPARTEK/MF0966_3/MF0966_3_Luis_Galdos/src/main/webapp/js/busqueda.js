var inputBusqueda = $('#busqueda');

function search() {
	
	var txt = inputBusqueda.val();
	console.log( txt );
	
	if (txt) {
		buscarTexto(txt);
	}
	
	
}

function buscarTexto(busqueda) {
	
	// Llamada a AJAX (Asíncrona)
	  var URL = "./buscar?busqueda=";
	  var cuerpo =  $("#tableBody"); 

	  jQuery.getJSON(URL + busqueda, function(data) {
	    console.log(busqueda);

	    cuerpo.html("");

	    $.each(data, function(key, entry) {
	    		var tr = `<tr>
		                <td>${ entry.dni }</td>
		                <td>${ entry.nombre }</td>
		                <td>${ entry.apellido1 }</td>
		                <td>${ entry.apellido2 }</td>
		                <td>${ entry.email }</td>
		                <td>${ entry.rol }</td>		
		                <td><a href="inicio?id=${ entry.id }&op=2">Editar</a></td>                
		            </tr>`
	    		cuerpo.append(tr);
	    }); 
	    
	  });
	
	  $('#tablaOrdenable').DataTable();
}