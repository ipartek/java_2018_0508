<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  		
      <div class="row">
          <div class="col-lg-8">
              <h1 class="page-header">Aprobar Comentarios <span class="badge">${fn:length(comentarios)}</span></h1>
          </div>          
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      
      
      <div class="row mb-3">
      
      	<form action="comentarios/aprobar" method="post">
      
      		<!--  datatables -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>id</th>
		                <th>usuario</th>
		                <th>fecha</th>
		                <th>texto</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${comentarios}" var="c">
			            <tr>
			                <td>${c.id} <input type="checkbox" name="ids" value="${c.id}"> </td>
			                <td>${c.usuario.nombre}</td>
			                <td>${c.fecha}</td>
			                <td>${c.texto}</td>
			            </tr>
		            </c:forEach>
		        </tbody>
		       
	    	</table>
	      	<!-- table#tablaOrdenable -->	
	      	<input type="submit" value="Aprobar Comentarios"  class="btn btn-info btn-block">
      	</form>
      	
      		
      </div>
      
      
      
  </div>
  <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>