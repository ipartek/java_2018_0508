 <%@ include file = "includes/header.jsp" %>
 
 <header>
    <div class="main">
        <h1>Resultado de la busqueda</h1>
    </div>
 
 </header>
      <a href="alumnos?op=1">Inicio</a>
  <form action="alumnos"class="form-inline">
 <input type="hidden" name="op" value="4">
  <div class="form-group mb-2">
    <label for="buscador" class="sr-only">Buscador</label>
    <input type="text" class="form-control-plaintext" id="buscador" name="buscador" value="">
  </div>
  
  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
</form>
        <a href="alumnos?op=1">Inicio</a>
 <div class="main">
 <a href="alumnos?id=-1&op=2">Crear Alumno</a>
<table id="myTable" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
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
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
                <th>Opciones</th>
            </tr>
        </tfoot>
    </table> 


</div>
 
 
  <%@ include file = "includes/footer.jsp" %>