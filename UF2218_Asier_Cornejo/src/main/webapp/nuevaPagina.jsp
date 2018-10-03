<%@ include file="includes/header.jsp" %>
<%@ include file="includes/nav.jsp" %>		


	
		<c:if test="${not empty alert}">
		<p class="alerta">${alert.texto}</p>
			${alert=null}
	
		</c:if>

        <div class="contenido">
       
        <div class="titulo"><h2>Escribe tu nueva pagina</h2></div>
        <form action="pagina" class="pagina"method="post" >
	        <div class="form-group">
			    <label for="exampleFormControlTextarea1">Escribe aqui tu nueva página</label>
			    <textarea name="texto"class="form-control" rows="15" columns="20" id="exampleFormControlTextarea1" rows="3" >${texto}</textarea>
			    <button type="submit" class="btn btn-outline-secondary pagina">Añadir Página</button>
	  		</div>
		</form>
   
      
        
        
        
        
        </div>
        
        <%@ include file="includes/footer.jsp" %> 