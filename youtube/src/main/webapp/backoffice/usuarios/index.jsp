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
      <div class="row">
      		<div class="col-md-8">
      			TODO BUSCADOR con su lupita toda txula
      		</div>
      		<div class="col-md-4">
      			<a href="usuarios?id=-1" class="btn btn-success">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
      		<!--  datatables -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>id</th>
		                <th>nombre</th>
		                <th>password</th>
		                <th>rol</th>		                
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${usuarios}" var="u">
			            <tr>
			                <td>${u.id}</td>
			                <td><a href="usuarios?id=${u.id}">${u.nombre}</a></td>
			                <td>${u.password}</td>
			                <td>${ (u.rol==1)?'normal':'adminstrador' }</td>		                
			            </tr>
		            </c:forEach>
		        </tbody>
		        <tfoot>
		            <tr>
		                <th>id</th>
		                <th>nombre</th>
		                <th>password</th>
		                <th>rol</th>	
		            </tr>
		        </tfoot>
    	</table>
      	<!-- table#tablaOrdenable -->	
      		
      </div>
      
  </div>
  <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

