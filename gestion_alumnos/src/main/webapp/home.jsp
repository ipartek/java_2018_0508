 <%@ include file = "includes/header.jsp" %>
 
 <header>
     
    <div class="main main-h1">
    <div class="row ">
    <div class="col-2">
         <a class="btn btn-success" href="alumnos?id=-1&op=2">Crear Alumno</a>
    </div>
    <div class="col-3">
     <form action="alumnos"class="form-inline">
      <button type="submit" class="btn btn-primary mb-2">Buscar</button>
         <input type="hidden" name="op" value="4">
          <div class="form-group mb-2">
            <label for="buscador" class="sr-only">Buscador</label>
            <input type="text"  id="buscador" name="buscador" value="">
          </div>
          
         
    </form>
    </div>
    <div class="col-4">
        <h1>Gestion de alumnos</h1>
    </div>
    <div class="col-1">
            <!-- cargar datos del archivo -->
    
     <form action="archivo"class="form-inline">
      <button type="submit" class="btn btn-primary mb-2">Cargar datos</button>
         <input type="hidden" name="op" value="1">
          <div class="form-group mb-2">
            <!-- <label for="filename" class="sr-only">Buscador</label>
            <input type="file" size=30 value="" name="filename"/> -->
          </div>
    </form>
    
    </div>
    </div>
 
 </header>
 <div class="container">
	<!-- <!-- Subir archivos al servidor -->
	<!-- <div class="col-3">
	     <form action="archivo"class="form-inline" enctype="multipart/form-data">
	      <button type="submit" class="btn btn-primary mb-2">Subir fichero</button>
	         <input type="hidden" name="op" value="1">
	          <div class="form-group mb-2">
	            <label for="filename" class="sr-only">Buscador</label>
	            <input type="file" size=30 value="" name="filename"/>
	          </div>
        </form>
    </div> -->
	

     <div class="row resumen" style="display:${isVisible}">

		 <div class="col-4"><p class="alert text-success">Registros totales guardados : ${ registrosGuardados }</p><p class="alert text-danger">Registros totales no guardados :${ registrosNoGuardados }</p></div>
		 <div class="col-2"><p class="alert text-danger">Registros con dni incorrectos : ${ registrosDniMal }</p></div>
		 <div class="col-2"><p class="alert text-danger">Registros con campos insuficientes : ${ registrosCamposIns }</p></div>
		 <div class="col-2"><p class="alert text-danger">Registros con lineas vacias : ${ lineasVacias }</p></div>
		  <div class="col-2"><p class="alert text-danger">totales leidos : ${ lineasTotales }</p></div>
           
	  </div>
	  <div class="col-2"><p class="alert ${ alerta.tipo }">${ alerta.texto }</p></div>
 </div>
 <hr>
 </div> 

 <div class="main">
<table id="myTable" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido1</th>
                <th>Apellido2</th>
                <th>Dni</th>
                <th>Email</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${ alumnos }" var="alumno">
            <tr>
                <td>${ alumno.id }</td>
                <td>${ alumno.nombre }</td>
                <td>${ alumno.apellido1 }</td>
                <td>${ alumno.apellido2 }</td>
                <td>${ alumno.dni }</td>
                <td>${ alumno.email }</td>
                <td><a href="alumnos?op=2&id=${alumno.id }&nombre=${alumno.nombre}&apellido1=${alumno.apellido1}&apellido2=${alumno.apellido2}&dni=${alumno.dni}&email=${alumno.email}">Editar</a></td>
                
            </tr>
         </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido1</th>
                <th>Apellido2</th>
                <th>Dni</th>
                <th>Email</th>
                <th>Opciones</th>
            </tr>
        </tfoot>
    </table> 


</div>
 
 
  <%@ include file = "includes/footer.jsp" %>