<%@ include file="includes/header.jsp" %>
<%@ include file="includes/nav.jsp" %>		



        <div class="contenido">
       
        <div class="titulo"><h2>Escribe tu nueva pagina</h2></div>
        <form action="pagina" method="post" >
	        <div class="form-group">
			    <label for="exampleFormControlTextarea1">Escribe aqui tú nueva página</label>
			    <textarea name="texto"class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
			    <button type="submit" class="btn btn-outline-secondary pagina">Añadir Página</button>
	  		</div>
		</form>
   
      
        
        
        
        
        </div>
        
        <%@ include file="includes/footer.jsp" %> 