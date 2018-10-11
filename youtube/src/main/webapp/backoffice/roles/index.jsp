<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  		
      <div class="row">
          <div class="col-lg-8">
              <h1 class="page-header">Roles <span class="badge">${fn:length(roles)}</span></h1>
          </div>          
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row">      		
      		<div class="col-md-4">
      			<a href="roles?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO%>" class="btn btn-success">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
      		<!--  datatables -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>id</th>
		                <th>nombre</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${roles}" var="r">
			            <tr>
			                <td>${r.id}</td>
			                <td><a href="roles?id=${r.id}&op=<%=CrudControllable.OP_IR_FORMULARIO%>">${r.nombre}</a></td>
			            </tr>
		            </c:forEach>
		        </tbody>
		        <tfoot>
		            <tr>
		                <th>id</th>
		                <th>nombre</th>
		            </tr>
		        </tfoot>
    	</table>
      	<!-- table#tablaOrdenable -->	
      		
      </div>
      
  </div>
  <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

