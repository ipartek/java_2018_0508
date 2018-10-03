<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/nav.jsp" %>

  <div id="page-wrapper">
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">${(usuario.id == -1)?'Crear Usuario': usuario.nombre }</h1>
          </div>
          <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
      <div class="row">
      		${usuario}
      		<form action="usuarios" method="post">
      		
      			<input type="submit" value="${(usuario.id == -1)?'Crear': 'Modificar' }" class="btn btn-primary btn-block">
      			<c:if test="${usuario.id > 0}">
      				<a href="#" class="btn btn-danger btn-block">Eliminar(Modal)</a>
      			</c:if>	
      		</form>
      		
      		
      </div>      
     
  </div>
  <!-- #page-wrapper -->   

<%@ include file="../includes/footer.jsp" %>

