<%@ include file="includes/header.jsp" %>
<%@ include file="includes/nav.jsp" %>		



        <div class="contenido">
        <div class="titulo"><h2>Numero de paginas ${pagActual.id}/${numeroPaginas}</h2></div>
        <p>${pagActual.texto}</p>
        
        
       <div class="autor">
        <p>${pagActual.autor}</p>
       
        </div>
        
        
        
        
       	
        
        
             <nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="paginacion?id=${pagActual.id}&op=2" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			        <span class="sr-only">Anterior</span>
			      </a>
			    </li>
			    <li>
			      <a class="page-link" href="paginacion?id=${pagActual.id}&op=1" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			        <span class="sr-only">Siguiente</span>
			      </a>
			    </li>
			  </ul>
			</nav>
        
        
        
        
        
</div>
           <%@ include file="includes/footer.jsp" %> 