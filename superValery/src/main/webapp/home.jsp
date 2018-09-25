<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>


<main class="contenedor">
<div class="contenido">
        	
			
			<c:forEach items="${productos}" var = "producto">
		        <div class="producto">

	                <p class="${producto.descuento<=0?'invisible':'descuento'}">${producto.descuento}&#37;</p>
	
	                <img src="${producto.imagen}" alt="imagen-producto" />
	
	                <div class="texto-producto">
	
	                    <p>
	                    	<span class="${producto.descuento<=0?'invisible':'tachado'}">${producto.precio}&euro;</span>
	                    	<span clasS="${ producto.descuento<=0?'no-descuento':''}">${producto.calcularDescuento}&euro;</span>
	                    </p>
	                    <p class="precio-litro">(${producto.precioUnidad})</p>
	                    <p>${producto.nombre}</p>
	
	                    <div class="cantidad">
	                        <span>&#45;</span> 1 <span>&#43;</span>
	                    </div>
	
	                </div>
	
	                <a href="#">AÑADIR AL CARRO</a>

           		 </div> <!-- /.producto -->
		    </c:forEach>
            
        </div> <!-- /.contenido -->

</main>


<%@ include file="includes/footer.jsp" %> 