<%@ include file="../includes/header.jsp"  %>
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>

     <%@ include file="../includes/nav.jsp"  %>

      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>Usuarios</div>
          </h1>
          <div class="section-body">
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-header">
                    
                    <%@ include file="../includes/alert.jsp"  %>
                    
                    <h4>Listado de Usuarios</h4>
                  </div>
                  <div class="card-body">
                      <a href="usuario?op=4" class="btn btn-sm btn-info mb-3">Añadir nuevo Usuario</a>

                    <!--  datatables -->
		      		<table id="tablaOrdenable" class="display" style="width:100%">
				        <thead>
				            <tr>
				            	<th>ID</th>
				                <th>Nombre y Apellidos</th>
	                          	<th>Acciones</th>		                
				            </tr>
				        </thead>
				        <tbody>
                  			<c:forEach items="${usuarios}" var="u">
		                        <tr>
		                          <td>${u.id}</td>
		                          <td>${u.nombreApellido}</td>
		                          <td>
		                              <a class="btn btn-primary btn-action mr-1" data-toggle="tooltip" title="Edit" href="usuario?op=4&id=${u.id}"><i class="ion ion-edit"></i></a>
		                              <a onclick="confirmar(event)" class="btn btn-danger btn-action" data-toggle="tooltip" title="Delete" href="usuario?op=3&id=${u.id}"><i class="ion ion-trash-b"></i></a>
		                            </td>
		                        </tr>
	                        </c:forEach>
                        </tbody>
				    </table>
                      
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
      
      <script>
      		function confirmar( e ) {					
      			if ( confirm('¿Estas seguro que quieres ELIMINAR ?') ){
      				console.log('confirmado eliminar');
      			}else{
      				//prevenir el evento por defecto de <a href=''>
      				e.preventDefault();
      			}      				
			}
      </script>
      
      <%@ include file="../includes/footer.jsp"  %>