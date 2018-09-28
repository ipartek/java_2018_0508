<%@ include file="includes/header.jsp" %>	
    
    <!-- Page Content -->
    <div class="container">
    	
      <%@ include file="includes/nav.jsp"  %>
      <%@ include file="includes/alert.jsp"  %>	
      	
      <div class="row">

        <div class="col-lg-3">        	
          <h4 class="my-4"><fmt:message key="lista.reproduccion"/></h4>
          
			<c:if test="${ empty editar}">
				<c:if test="${not empty sessionScope.usuario}">
					 <a class="badge badge-primary" href="inicio?editar=true">Editar</a>
				</c:if>
			          <ul class="list-group">                     
			          	  <c:forEach items="${videos}" var="v">          
				            <li class="list-group-item d-flex justify-content-between align-items-center">
				            	<span>${v.id}</span>    
				          	  	<a href="inicio?id=${v.id}">${v.nombre}</a>
				          	  	<a href="inicio?id=${v.id}&op=1"><%-- ${HomeController.OP_ELIMINAR} --%>
				          	  		<i style="color:red;" class="float-right fas fa-trash-alt"></i>
				          	  	</a>
				            </li>
				          </c:forEach>
			            </ul>
			  </c:if>
	         
	        
            <c:if test="${not empty editar}">
            	<c:if test="${not empty sessionScope.usuario}">
	            	<c:forEach items="${videos }" var="v">
	            		
	            		<form action="inicio">
		            		<input class="editar-nombre-lista" name="editarNombreGet${v.id }" placeholder="${v.nombre }"  class="form-control mr-sm-2" type="text" >
		            		<%-- <input name="codigo" value="${v.codigo }" class="form-control mr-sm-2" type="text" > --%>
		            		<input class="invisible" name="editarNombreIdGet${v.id }" value="${v.id }">
	           		</c:forEach>	
		            		<button class="btn btn-primary" type="submit" >guardar</button>
	            		</form>
	            	
	            </c:if>
           	</c:if>
            		<hr> 
            	
            
            
            <hr>
            
            <h4 class="my-4">Videos Visualizados</h4>
	          <ul class="list-group">	          	
          		   <c:forEach items="${reproducidos}" var="r">
			            <li class="list-group-item d-flex justify-content-between align-items-center">     
			          	  	<a href="?id=${r.id}">${r.nombre}</a>	          	  	
			            </li>
		           </c:forEach>
		            
		            <c:if test="${empty sessionScope.usuario}">
		        		<li class="list-group-item d-flex justify-content-between align-items-center">
	          				<p>*Por favor Inicia Session para guardar tus video reproducidos</p>
	          			</li>
          			</c:if>
	          	
	            </ul>
            
          </div>
         
        
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="card mt-4">
          
            <iframe id="iframe" width="823" height="415" src="https://www.youtube.com/embed/${videoInicio.codigo}?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            
            <div class="card-body">
              <h3 class="card-title"></h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->

          <div class="card card-outline-secondary my-4">
            <div class="card-header">
              Comentarios
            </div>
            <div class="card-body">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              
            </div>
          </div>
          <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->

 <%@ include file="includes/footer.jsp" %> 
