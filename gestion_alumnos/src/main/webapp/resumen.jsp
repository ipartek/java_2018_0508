 <%@ include file = "includes/header.jsp" %>
 
 <header>
    <div class="main">
        <h1>
        <a class="badge badge-info boton-resumen-inicio" href="alumnos?op=1">Inicio</a>
        <span>Resumen de la importación</span>
        <a class="badge badge-info boton-resumen-inicio-drcho" href="archivo?op=1">Cargar Datos</a></h1>
    </div>
 
 </header>
 <div class="container">

 <div class="row justify-content-md-center">
    <div class="col-3">
        
        
    </div>
 </div>

      <table width="100%" id="tabla-resumen">
        <thead style="background: grey;">
            <th>Descripcion :</th>
            
            <th>Lineas problematicas</th>
            <th>Cantidad</th>
        </thead>
        <tbody>
	        
	        <tr>
	            <td><span class="alert text-danger">Lineas vacias : </span></td>
	            
	            <td>${ lineasVacias }</td>
	            <td> ${ nLineasVacias }</td>
	            
	        </tr>
	        <tr>
	            <td><span class="alert text-danger">Lineas con menos de 7 campos : </span></td>
	            
	            <td>${ lineasCampoIns }</td>
	            <td> ${ nLineasCamposIns }</td>
	            
	        </tr>     
	        <tr>
	            <td><span class="alert text-danger">Lineas con dni duplicados : </span></td>
	            
	            <td>${ lineasDniDuplicados }</td>
	            <td> ${ dniDuplicados }</td>
	        </tr>    
	        <tr>
	            <td><span class="alert text-danger">Lineas con dni no tiene 9 caracteres : </span></td>
	            
	            <td>${ lineasCampoDniLongitud }</td>
	            <td> ${ nlineasCampoDniLongitud }</td>
	        </tr>
	        <tr>
                <td><span class="alert text-danger">Lineas con el campo nombre vacio : </span></td>
                
                <td>${ lineasCampoNombreVacio }</td>
                <td> ${ nlineasCampoNombreVacio }</td>
            </tr>  
	        <tr>
                <td><span class="alert text-danger">Lineas con apellido1 vacio : </span></td>
                
                <td>${ lineasCampoApellido1Vacio }</td>
                <td> ${ nlineasCampoApellido1Vacio }</td>
            </tr>
            <tr>
                <td><span class="alert text-danger">Lineas con apellido2 vacio : </span></td>
                
                <td>${ lineasCampoApellido2Vacio }</td>
                <td> ${ nlineasCampoApellido2Vacio }</td>
            </tr>
            <tr>
                <td><span class="alert text-danger">Lineas con email vacio : </span></td>
                
                <td>${ lineasCampoEmailVacio }</td>
                <td> ${ nlineasCampoEmailVacio }</td>
            </tr>
            <tr>
                <td><span class="alert text-danger">Lineas descartadas : </span></td>
                
                <td>${ registrosNoGuardados }</td>
                <td> ${ registrosNoGuardados }</td>
            </tr>
	        <tr>
                <td><span class="alert text-success">totales leidos : </span></td>
                <td></td>
                <td>${ lineasTotales }</td> 
            </tr> 
            <tr>
                <td><span class="alert text-success">Total guardados : </span></td>
                <td></td>
                <td style="background: grey; color:white;">${ registrosGuardados }</td>
            </tr>      
        </tbody>
      </table>
</div>
<p class="alert alert-dark" role="alert"">Si no obtiene resultados, asegurese de tener el archivo llamado alumnos.txt en c: (Raiz del sistema   )</p>

      
 
 
  <%@ include file = "includes/footer.jsp" %>