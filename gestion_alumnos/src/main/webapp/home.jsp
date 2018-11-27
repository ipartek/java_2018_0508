 <%@ include file = "includes/header.jsp" %>
 
 <header>
    <div class="main">
        <h1>Gestion de alumnos</h1>
    </div>
 
 </header>
 <div class="row justify-content-md-center">
    <div class="col-6">
	 <form action="alumnos"class="form-inline">
	  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
		 <input type="hidden" name="op" value="4">
		  <div class="form-group mb-2">
		    <label for="buscador" class="sr-only">Buscador</label>
		    <input type="text"  id="buscador" name="buscador" value="">
		  </div>
		  
		 
	</form>
	</div>
 </div>

  

 <div class="main">
 <a class="btn btn-success" href="alumnos?id=-1&op=2">Crear Alumno</a>
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