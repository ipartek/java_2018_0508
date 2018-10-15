<%@page import="com.ipartek.formacion.youtube.controller.back.ICRUDController"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  		
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Roles</h1>
          </div> 
      </div> 
     
      <div class="row margin-bottom-5">
      		<div class="col-md-4">
      			<a href="roles?id=-1&op=<%= ICRUDController.OP_IR_FORMULARIO %>" class="btn btn-success mb-3">Crear Nuevo</a>
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
		        	<c:forEach items="${ roles }" var="rol">
			            <tr>
			                <td>${ rol.id }</td>
			                <td><a href="roles?id=${ rol.id }&op=<%= ICRUDController.OP_IR_FORMULARIO %>">${ rol.nombre }</a></td>	                
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
      
  </div> <!-- #page-wrapper -->  
   

<%@ include file="../includes/footer.jsp" %>

