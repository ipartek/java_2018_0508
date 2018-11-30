 <%@ include file = "includes/header.jsp" %>
 
 <div class="main main-h1">
  
  <div class="modal" id="modalCargar" name="modalCargar" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
 
  </div>

 <header>
     
    <div class="main main-h1">
	    <div class="row buscador">
	       <div class="col-2">
                <a class="badge badge-success boton-inicio" href="alumnos?id=-1&op=2">Crear Alumno</a>
            </div>
            <div class="col-3">
			     <form action="alumnos"class="form-inline ">
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

             <a class="badge badge-info boton-inicio mb-2" href="resumen.jsp">Migrar datos</a>
             
          </div><!-- cierre row    -->
    </div>
 </header>
  
  <main class="container">
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
                <td><a href="alumnos?op=2&id=${alumno.id }&nombre=${alumno.nombre}&apellido1=${alumno.apellido1}&apellido2=${alumno.apellido2}&dni=${alumno.dni}&email=${alumno.email}"><i class="fas fa-edit"></i></a></td>
                
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
</main>
 
 
  <%@ include file = "includes/footer.jsp" %>