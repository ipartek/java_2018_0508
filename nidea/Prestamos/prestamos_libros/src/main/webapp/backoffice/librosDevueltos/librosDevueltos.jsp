<%@ include file="../includes/header.jsp"  %>
<!-- / header-->
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>

    <%@ include file="../includes/nav.jsp"  %>
    
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>Libros Devueltos</div>
          </h1>
          <div class="section-body">
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-header">
              		<%@ include file="../includes/alert.jsp"  %>
                    <h4>Listado de Libros Devueltos</h4>
                  </div>
                  <div class="card-body">
                  
                   <!--  datatables -->
		      		<table id="tablaOrdenable" class="display" style="width:100%">
				        <thead>
				            <tr>
					            <th>Titulo</th>
	                          	<th>Nombre y Apellidos</th>
	                          	<th>Fecha Prestamo</th>
	                          	<th>Fecha Devolución</th>
	                          	<th></th>	                
				            </tr>
				        </thead>
				        <tbody>
                  		     <c:forEach items="${devueltos}" var="d">
							<tr>
								<td>${d.libro.titulo}</td>
								<td>${d.usuario.nombreApellido}</td>
								
								<td><fmt:formatDate pattern = "MM/dd/yyyy" value = "${d.fecha_inicio}" /></td>
								<td><fmt:formatDate pattern = "MM/dd/yyyy" value = "${d.fecha_devuelto}" /></td>
								
								<td><a href="prestamo?op=8&libro=${d.libro.id}&usuario=${d.usuario.id}&fechaInicio=<fmt:formatDate pattern = "dd-MM-yyyy" value = "${d.fecha_inicio}" />" class="btn btn-primary"> Editar</a></td>
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
      <%@ include file="../includes/footer.jsp"  %>