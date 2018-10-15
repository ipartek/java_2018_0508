<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

    <div id="wrapper">

		<%@include file="../includes/nav.jsp" %>

      <div id="page-wrapper" class="contenedor">
        <%@include file="../includes/alert.jsp" %>
            
            <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header titulo">Comentarios <span class="badge nComentarios">${fn:length(comentarios)}</span></h1>
            </div>
            <!-- /.col-lg-12 -->
        	</div>
        
	        <div class="row">
	        	<div class="col-lg-4">Aprobado</div>
	        	<div class="col-lg-4">Usuario</div>
	        	<div class="col-lg-4">Comentario</div>
	        </div>
        
        <form action="comentarios/aprobar" method="post">
        
        	<input type="submit" class="btn btn-warning boton-aprobar" value="Aprobar comentarios" />
        	
        	<c:forEach items="${comentarios}" var="c">
        	
        		<div class="form-row">
        	
					<div class="form-group col-lg-4">
						<input type="checkbox" name="id" class="form-control" value="${c.id}" />
					</div>
				
					<div class="form-group col-lg-4">
						<label>${c.usuario.nombre}</label>
					</div>
				
					<div class="form-group col-lg-4">
						<textarea class="form-control comentario-texto" onclick="showModalComentario('${c.usuario.nombre}', '${c.texto}')" cols="20" rows ="5" readonly>${c.texto}</textarea>
					</div>
					
				</div>
				
        	</c:forEach>
        </form>
        
        <!-- Modal comentario -->
        
        <div class="modal fade" id="modalComentario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="cabeceraModal"></h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <p id="textoComentario"></p>
			      </div>
			    </div>
			  </div>
			</div>
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

 <%@ include file="../includes/footer.jsp" %> 