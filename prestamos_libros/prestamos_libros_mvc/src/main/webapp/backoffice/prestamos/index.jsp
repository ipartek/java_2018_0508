<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>


<%@ include file="../include/nav.jsp" %>
<div class="container">
  
  	  <%@ include file="../include/alert.jsp" %>
  	  
  	  <%@ include file="../include/modal.jsp" %>
  		
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Préstamos Activos</h1>
          </div> 
      </div> 
     
      <div class="row margin-bottom-5">
      		<div class="col-md-4">
      			<a href="prestamos?id=-1&op=<%= ICRUDController.OP_IR_FORMULARIO %>" class="btn btn-success mb-3">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
      
      		<!--  DATATBLES -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>Libro</th>	 
		                <th>Alumno</th>
		                <!-- <th>Días Restantes</th>    -->
		                <th>Fecha Inicio</th>
		                <th>Fecha Fin</th>  
		                <td>Operaciones</td>           
		            </tr>
		        </thead>
		        
		        <tbody>
		        	<c:forEach items="${ prestamos }" var="p">
			            <tr>
			                <td>${ p.libro.titulo }</td>
			                <td>${ p.alumno.nombre }</td>
			                <%-- <td>${ p.diasRestantes }</td> --%>
			                <td>${ p.fechaInicio }</td>
			                <td>${ p.fechaFin }</td>
			                <td>
			                	<a class="badge badge-primary" onclick="showInputDialogDevolver(<%= ICRUDController.OP_ELIMINAR %>, ${ p.alumno.id }, ${ p.libro.id },  '${ p.fechaInicio }' );">Devolver</a>
			                	<a class="badge badge-danger" href="prestamos?id=${ p.alumno.id }&alumnoOrig=${ p.alumno.id }&libroOrig=${ p.libro.id }&fechaOrig=${ p.fechaInicio }&op=<%= ICRUDController.OP_IR_FORMULARIO %>&alumnos=${ p.alumno.id }&libros=${ p.libro.id }&fechaInicio=${ p.fechaInicio }&fechaFin=${ p.fechaFin }">Editar</a>
			                </td>	                
			            </tr>
		            </c:forEach>
		        </tbody>
		       
		        <tfoot>
		            <tr>
		                <th>Libro</th>	 
		                <th>Alumno</th>
		               <!--  <th>Días Restantes</th>    -->
		                <th>Fecha Inicio</th>
		                <th>Fecha Fin</th>   
		                <td>Operaciones</td>   
		            </tr>
		        </tfoot>
    	</table> 	<!-- table#tablaOrdenable -->		
      </div> <!-- ./ row -->

</div>

<%@ include file="../include/footer.jsp" %>