<%@include file="../includes/header.jsp"%>    
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/taglibs.jsp"%> 
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
		<h1 class="page-header">Listado usuarios</h1>
		
		</div>
		<!-- /col-lg-12 -->
	</div>
	<!-- /row -->
	<div class="row">
		<div class="col-md-8">
		TODO BUSCADOR CON LUPA
		</div>
		<div class="col-md-4 ">
			<a href="usuarios?id=-1" class="btn btn-success">Crear nuevo</a>		
		</div>
	
	</div>
	<div class="row">
		<!-- /DataTable -->
		<table id="tablaOrdenable" class="display" style="width:100%">

        <thead>
            <tr>
                <th>id</th>
                <th>Nombre</th>
                <th>Contraseña</th>
                <th>rol</th>                
            </tr>
        </thead>
        <tbody>
       	 <c:forEach items="${usuarios}" var="u">
        	<tr>
                <td>${u.id }</td>
                <td><a href="usuarios?id=${u.id }">${u.nombre }</a></td>
                <td>${u.contrasena}</td>
                <td>${u.rol==1?'normal':'administrador'}</td>                
            </tr> 
        </c:forEach>
                       
        </tbody>
        <tfoot>
            <tr>
                <th>id</th>
                <th>Nombre</th>
                <th>Contraseña</th>
                <th>rol</th>
            </tr>
        </tfoot>
    </table>
	</div>
	
	
	
</div>
<!-- /page-wrapper -->



    
    
    <%@include file="../includes/footer.jsp"%>