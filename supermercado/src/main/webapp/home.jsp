<%@ include file="includes/header.jsp" %>

        <div class="contenido">
        	
			
			<c:forEach items="${productos}" var = "producto">
		        <div class="producto">

	                <p class="${producto.descuento<=0?'invisible':'descuento'}">${producto.descuento}&#37;</p>
	
	                <img src="${producto.imagen}" alt="imagen-producto" />
	
	                <div class="texto-producto">
	
	                    <p>
	                    	<span class="${producto.descuento<=0?'invisible':'tachado'}">${producto.precio}&euro;</span>
	                    	<span clasS="${ producto.descuento<=0?'no-descuento':''}">${producto.calcularDescuento	}&euro;</span>
	                    </p>
	                    <p class="precio-litro">(${producto.precioUnidad})</p>
	                    <p>${producto.nombre}: ${producto.descripcion}</p>
	
	                    <div class="cantidad">
	                        <span>&#45;</span> 1 <span>&#43;</span>
	                    </div>
	
	                </div>
	
	                <a href="#">AÑADIR AL CARRO</a>

           		 </div> <!-- /.producto -->
		    </c:forEach>
            
        </div> <!-- /.contenido -->

        <a href="#top" class="top">Top</a>

    <%@ include file="includes/footer.jsp" %>