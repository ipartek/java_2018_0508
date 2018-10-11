<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  		
      <div class="row">
          <div class="col-lg-8">
              <h1 class="page-header">Videos<span class="badge">${fn:length(videos)}</span></h1>
          </div>          
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row">      		
      		<div class="col-md-4">
      			<a href="videos?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO%>" class="btn btn-success">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
      		<!--  datatables -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>id</th>
		                <th>imagen</th>
		                <th>nombre</th>
		                <th>usuario</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${videos}" var="v">
		        		<tr>			            
			                <td>${v.id}</td>
			                <td>
			                	<a href="videos?op=<%=CrudControllable.OP_IR_FORMULARIO%>&id=${v.id}">
			                		<img src="http://img.youtube.com/vi/${v.codigo}/0.jpg" alt="imagen por defecto del video" class="thumbnail"/>
			                	</a>
			                </td>
			                <td>${v.nombre}</td>
			                <td><a href="usuarios?op=<%=CrudControllable.OP_IR_FORMULARIO%>&id=${v.usuario.id}">${v.usuario.nombre}</a></td>
			            </tr>
		            </c:forEach>
		        </tbody>
		        <tfoot>
		            <tr>
		                <th>id</th>
		                <th>imagen</th>
		                <th>nombre</th>
		                <th>usuario</th>
		            </tr>
		        </tfoot>
    	</table>
      	<!-- table#tablaOrdenable -->	
      		
      </div>
      
  </div>
  <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

