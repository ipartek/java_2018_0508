<%@ include file="includes/header.jsp"  %>
<!-- / header-->
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>

    <%@ include file="includes/nav.jsp"  %>
    
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>Libros Prestados</div>
          </h1>
          <div class="section-body">
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-header">
                  	 <%@ include file="../includes/alert.jsp"  %>
                    <h4>Listado de Libros</h4>
                  </div>
                  <div class="card-body">
                    <!--  datatables -->
		      		<table id="tablaOrdenable" class="display" style="width:100%">
				        <thead>
				            <tr>
	                          <th>Titulo</th>
	                          <th>Nombre y Apellidos</th>
	                          <th>Dias Restantes</th>
	                          <th>Fecha Prestamo</th>
	                          <th>Fecha Devolución</th> 
	                          <th></th>
	                          <th></th>
                        	</tr>
				        </thead>
				        <tbody>
                  			<c:forEach items="${prestamos}" var="p">
								<tr>
									<td>${p.libro.titulo}</td>
									<td>${p.usuario.nombreApellidos}</td>
									<td>${p.diasRestantes}</td>
									<td><fmt:formatDate pattern = "MM/dd/yyyy" value = "${p.fech_inicio}" /></td>
									<td><fmt:formatDate pattern = "MM/dd/yyyy" value = "${p.fech_fin}" /></td>
									
										<td><button type="button" class="btn btn-primary btn-sm" onclick="showModalDevolucion('${p.libro.id}','${p.usuario.id}','<fmt:formatDate pattern = "MM/dd/yyyy" value = "${p.fech_inicio}" />')"> Devolver</button></td>
										<td><a href="prestamo?op=6&libro=${p.libro.id}&usuario=${p.usuario.id}&fechaInicio=<fmt:formatDate pattern = "dd-MM-yyyy" value = "${p.fech_inicio}" />" class="btn btn-primary btn-sm"> Editar</a></td>
										
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

      <%@ include file="includes/footer.jsp"  %>