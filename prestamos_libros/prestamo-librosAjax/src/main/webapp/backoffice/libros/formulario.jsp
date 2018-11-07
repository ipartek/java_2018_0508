<%@page
	import="com.ipartek.formacion.prestamolibros.controller.CrudControllable"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>

<div id="page-wrapper">

	<%@include file="../includes/alert.jsp"%>

	<div class="row">
		<form action="biblioteca" method="post">

			<div class="form-group">
				<label for="id">ID:</label> <input type="text" class="form-control" id="id" name="id" value="${libro.id }" readonly />
			</div>

			<div class="form-group">
				<label for="titulo">Título:</label> 
				<input type="text" class="form-control" id="titulo" name="titulo" value="${libro.titulo }" required autofocus />
			</div>
			
			<div class="form-group">
				<label for="editorial">Editorial:</label>
				<select id="editorial" name="editorial" class="form-control">
					<c:forEach items = "${editoriales}" var = "e">
						<option value="${e.id }" ${(e.id == libro.editorial.id)? 'selected' : '' }>${e.editorial }</option>
					</c:forEach>
				</select>
				<span class="input-group-btn">
				    	<button class="btn btn-default" type="button"><i onclick="showModalNuevaEditorial()" class="fas fa-plus"></i></button>
				    </span>					
			</div>
			
			<c:if test="${libro.id == -1 }">
				<div class="form-group">
					<label for="numLibros">Cantidad:</label>
					<input type="number" class="form-control" id="numLibros" name="numLibros" min="1" value="1" required />
				</div>
			</c:if>
			<div class="form-group">
				<label for="isbn">ISBN:</label>
				<input type="text" class="form-control" id="isbn" name="isbn" value="${libro.isbn}" required />
			</div>

			<input type="hidden" name="op"
				value="<%=CrudControllable.OP_GUARDAR%>" /> <input type="submit"
				value="${(libro.id == -1)? 'Crear' : 'Modificar' }"
				class="btn btn-primary btn-block" />

			<c:if test="${libro.id >= 0}">
				<a
					href="biblioteca?id=${libro.id}&op=<%=CrudControllable.OP_ELIMINAR %>" onclick="confirmar(event)"
					class="btn btn-danger btn-block">Eliminar</a>
			</c:if>

		</form>

	</div>
	
	
	
	<!-- Modal Nueva Editorial -->
			<div class="modal fade" id="modalNuevaEditorial" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Nuevo Editorial</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      	<form action="editoriales" method="post">
			      	
			      		<div class="form-group">
				      		<label for="editorial">Editorial</label>
				        	<input type="text" class="form-control" id="editorial" name="nombre"/>
				        	<div class="modal-footer">
			        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			        		<button type="submit" id="btnAnadirAlumno" class="btn btn-primary">Crear</button>			        
			      		</div>

			        	<input type="hidden" name="id" id="id" value="-1"/>
			        	<input type="hidden" name="op" value=<%=CrudControllable.OP_GUARDAR %> />
			        	</div>
			        </form>
			      </div>
			    </div>
			  </div>
			</div>

</div>
<%@include file="../includes/footer.jsp"%>