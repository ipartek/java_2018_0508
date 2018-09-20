<c:if test="${not empty usuario}">
		  <div class="card card-outline-secondary my-4">
		  	<div class="card-header">
              Introduce un comentario
            </div>
            <div class="card-body">
            	<form action="comentario" method="post">
				  <div class="form-group">
				    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Escribe aqui tu comentario..."></textarea>
				  </div>
				  <button type="submit" class="btn btn-primary float-right">Enviar</button>
				</form>
            </div>
		  </div>
		  </c:if>
		  <c:if test="${empty usuario}">
			<div class="card card-outline-secondary my-4">
				<div class="card-header">
	              Introduce un comentario
	            </div>
				<div class="card-body">
	          	<p>*Por favor Inicia Session para introducir comentarios</p>
	          	</div>
	        </div>
		  </c:if>
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
              
            </div>
          </div>
          <!-- /.card -->