<%@ include file="includes/header.jsp" %>
<%@ include file="includes/nav.jsp" %>		



        <div class="contenido">
        <c:if test="${not empty alert}">
		<p class="alerta">${alert.texto}</p>
			${alert=null}
	
		</c:if>
        
        <div class="titulo"><h2>Numero de paginas ${pagActual.id}/${numeroPaginas}</h2></div>
        
        <div class="texto"><p>${pagActual.texto}</p></div>
        
        
        
       <div class="autor">
        <p>${pagActual.autor}</p>
       
        </div>
        
        <div class="pagiancion"> 
        	<a  href="paginacion?id=${pagActual.id}&op=2" >Anterior</a>
        
        	<a  href="paginacion?id=${pagActual.id}&op=1">Siguiente</a>
        </div>
         
</div>
           <%@ include file="includes/footer.jsp" %> 