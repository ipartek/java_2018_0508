 <%@ include file = "includes/header.jsp" %>
 
 <header>
     
    <div class="main main-h1">
        <div class="row buscador">
           <div class="col-2">
                <a class="badge badge-success boton-inicio" href="alumnos?op=1">Inicio</a>
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
                  <button type="submit" class="badge badge-info boton-inicio mb-2">Cargar datos</button>
                     <input type="hidden" name="op" value="1">
                      <div class="form-group mb-2">
                        <!-- <label for="filename" class="sr-only">Buscador</label>
                        <input type="file" size=30 value="" name="filename"/> -->
                      </div>
                   </form>
    
             </div>
          </div><!-- cierre row    -->
    </div>
 </header>
 <main class="container">
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
            <c:forEach items="${ alumnosBuscados }" var="alumno">
	            <tr>
	                <td>${ alumno.id }</td>
	                <td>${ alumno.nombre }</td>
	                <td>${ alumno.apellido1 }</td>
	                <td>${ alumno.apellido2 }</td>
	                <td>${ alumno.dni }</td>
	                <td>${ alumno.email }</td>                
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
</main>


 
  <%@ include file = "includes/footer.jsp" %>