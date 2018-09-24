<!-- Page codification -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="vendor/include/header.jsp" %>
<%@ include file="vendor/include/navbar.jsp" %>

    <div class="contenedor">
    
    <h2>Número de productos ${numProductos}</h2>

        <div class="contenido">
        
        <c:forEach items="${productos}" var="producto">
	     
	     <div class="producto">

                <c:if test="${producto.descuento != 0}">
                	<p class="descuento">${producto.descuento} &#37;</p>
                </c:if>

                <img src="${producto.imagen}" alt="imagen-producto" />

                <div class="texto-producto">

                    <p><span class="tachado">${producto.precio}&euro;</span>   
                    <span>${ (producto.descuento > 0) ? producto.calcularDescuento.concat('&euro;') : ""}</span></p>
                    
                    <p class="precio-litro">(${producto.precio} &euro; / ${producto.unidad})</p>
                    <p><span class="titulo">${producto.nombre.concat(' ')}</span> ${producto.descripcion}</p>

                    <div class="cantidad">
                        <span>&#45;</span> <span>1</span> <span>&#43;</span>
                    </div>

                </div>

                <a href="#">AÑADIR AL CARRO</a>

            </div> <!-- /.producto -->
	     
	     </c:forEach>
            
        </div> <!-- /.contenido -->
	
<%@ include file="vendor/include/footer.jsp" %>