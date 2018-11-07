<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>


<%@ include file="../include/nav.jsp" %>
<div class="container">
  
  	  <%@ include file="../include/alert.jsp" %>
  		
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Editoriales</h1>
          </div> 
      </div> 
     
      <div class="row margin-bottom-5">
      		<div class="col-md-4">
      			<a href="editoriales?id=-1&op=<%= ICRUDController.OP_IR_FORMULARIO %>" class="btn btn-success mb-3">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
      
      		<!--  DATATBLES -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>Nombre</th>	                
		            </tr>
		        </thead>
		        
		        <tbody>
		        	<c:forEach items="${ editoriales }" var="editorial">
			            <tr>
			                <td>${ editorial.id }</td>
			                <td><a href="editoriales?id=${ editorial.id }&op=<%= ICRUDController.OP_IR_FORMULARIO %>">${ editorial.nombre }</a></td>	                
			            </tr>
		            </c:forEach>
		        </tbody>
		       
		        <tfoot>
		            <tr>
		                 <th>ID</th>
		                <th>Nombre</th>	  
		            </tr>
		        </tfoot>
    	</table> 	<!-- table#tablaOrdenable -->		
      </div> <!-- ./ row -->

</div>

<%@ include file="../include/footer.jsp" %>