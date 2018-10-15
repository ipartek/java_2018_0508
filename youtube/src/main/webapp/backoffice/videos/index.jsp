<%@page import="com.ipartek.formacion.youtube.controller.back.ICRUDController"%>

<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
  
  	  <%@ include file="../includes/alert.jsp" %>
  		
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Videos</h1>
          </div> 
          	
      </div> 
     
      <div class="row margin-bottom-5">
      		<div class="col-md-4">
      			<a href="videos?id=-1&op=<%= ICRUDController.OP_IR_FORMULARIO %>" class="btn btn-primary">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
      
      		<!--  DATATBLES -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>ID Video</th>
		               	<th>Thumbnail</th>  
		                <th>Código</th>	
		                <th>Título</th>	 
		                <th>Usuario</th>	                 
		            </tr>
		        </thead>
		        
		        <tbody>
		        	<c:forEach items="${ videos }" var="video">
			            <tr>
			                <td>${ video.id }</td>
			                <td><img src="https://img.youtube.com/vi/${ video.cod }/0.jpg" alt="Imagen por defecto del video"></td>
			                <td>${ video.cod }</td>     
			                <td><a href="videos?id=${ video.id }&op=<%= ICRUDController.OP_IR_FORMULARIO %>">${ video.nombre }</a></td>	
			                <td>${ video.usuario.nombre }</td>              
			            </tr>
		            </c:forEach>
		        </tbody>
		       
		        <tfoot>
		            <tr>
		               	<th>ID Video</th>
		               	<th>Thumbnail</th>  
		                <th>Código</th>	
		                <th>Título</th>	 
		                <th>Usuario</th>	  
		            </tr>
		        </tfoot>
    	</table> 	<!-- table#tablaOrdenable -->		
      </div> <!-- ./ row -->
      
  </div> <!-- #page-wrapper -->  
   

<%@ include file="../includes/footer.jsp" %>

