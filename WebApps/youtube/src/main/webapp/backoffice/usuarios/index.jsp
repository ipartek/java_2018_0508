<%@page import="com.ipartek.formacion.youtube.controller.back.BackofficeUsuarioController"%>
<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  		
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Usuarios</h1>
          </div>
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row margin-bottom-5">
      		<div class="col-md-4">
      			<a href="usuarios?id=-1&op=${ BackofficeUsuarioController.OP_IR_FORMULARIO }" class="btn btn-success mb-3">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
      		<!--  datatables -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>Nombre</th>
		                <th>Rol</th>		                
		            </tr>
		        </thead> 
		        
		        <tbody>
		        	<c:forEach items="${ usuarios }" var="u">
			            <tr>
			                <td>${ u.id }</td>
			                <td><a href="usuarios?id=${ u.id }&op=${ BackofficeUsuarioController.OP_IR_FORMULARIO }">${ u.nombre }</a></td>
			                <td>${ u.rol.nombre }</td>		                
			            </tr>
		            </c:forEach>
		        </tbody>
		         
		        <tfoot>
		            <tr>
		                <th>ID</th>
		                <th>Nombre</th>
		                <th>Rol</th>		
		            </tr>
		        </tfoot>
    	</table> <!-- table#tablaOrdenable -->	

      </div> <!-- ./ row -->
      
  </div> <!-- #page-wrapper -->  
  
<%@ include file="../includes/footer.jsp" %>

