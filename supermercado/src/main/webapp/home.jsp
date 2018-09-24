<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
        
		<h2>Número de productos -> ${numeroProductos }</h2>
		
        <div class="contenido">
        	
        	<c:forEach items="${productos }" var="p">
        		<c:if test="${p.descuento gt 0 }">
        		
	        		<div class="producto">
		
		                <p class="descuento">${p.descuento }&#37;</p>
		
		                <img src="${p.imagen }" alt="imagen-producto" />
		
		                <div class="texto-producto">
		
		                    <p><span class="tachado">${p.precio }&euro;</span><span>${p.calcularDescuento }&euro;</span></p>
		                    <p class="precio-litro">(${p.precioUnidad }&euro; / Litro)</p>
		                    <p class="nombreProducto">${p.nombre }</p>
		                    <p>${p.descripcion }</p>
		
		                    <div class="cantidad">
		                        <span>&#45;</span> 1 <span>&#43;</span>
		                    </div>
		
		                </div>
		
		                <a href="#">AÑADIR AL CARRO</a>
		
		            </div> <!-- /.producto -->
        		
        		</c:if>
        		
        		<c:if test="${p.descuento le 0 }">
        		
        		<div class="producto">
	
	                <img src="${p.imagen }" alt="imagen-producto" />
	
	                <div class="texto-producto">
	
	                    <p class="no-descuento">${p.precio }&euro;</p>
	                    <p class="precio-litro">(${p.precioUnidad }&euro; / Litro)</p>
	                    <p class="nombreProducto">${p.nombre }</p>
	                    <p>${p.descripcion }</p>
	
	                    <div class="cantidad">
	                        <span>&#45;</span> 1 <span>&#43;</span>
	                    </div>
	
	                </div>
	
	                <a href="#">AÑADIR AL CARRO</a>
	
	            </div> <!-- /.producto -->
        		
        		</c:if>        	
	        	
        		
        	</c:forEach>
        	
        	

            
        </div> <!-- /.contenido -->

        <a href="#top" class="top">Top</a>

<%@ include file="includes/footer.jsp" %>