<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp" %>

    <div class="contenedor">

		<%@ include file="includes/navbar.jsp" %>

		<!-- <h2>Numero de Productos ${numeroProductos}</h2> -->

        <div class="contenido">
        	<c:forEach items="${productos}" var="p">
	        	<div class="producto">
	        		<c:if test="${p.descuento > 0}">
	        			<p class="descuento">${p.descuento}&#37;</p>
	        		</c:if>
	               
	                <img src="${p.imagen}" alt="imagen-producto" />
	    
	                <div class="texto-producto">
		                <c:if test="${p.descuento > 0}"> <!-- Con descuento -->
		        			<p>
		        			<span class="tachado">${p.precio}&euro;</span>
		        			<span>
		        				<!-- ${p.calcularDescuento}&euro; -->
		        				<fmt:formatNumber value="${p.precio-(p.precio * (p.descuento/100))}"  maxFractionDigits="2"/>&euro;
			        			<!-- <fmt:formatNumber var="preDesc" value="${p.precio-(p.precio * (p.descuento/100))}"  maxFractionDigits="2" />
			        			${preDesc}&euro; -->
		        			</span>
		        			</p>
		        		</c:if>
		        		<c:if test="${p.descuento == 0}"> <!-- Sin descuento -->
		        			<p class="no-descuento">${p.precio}&euro;</p>
		        		</c:if>
	                    <p class="precio-litro">(${p.precioUnidad})</p>
	                    <p>${p.descripcion}</p>
	                    <div class="cantidad">
	                            <span>&#45;</span> 1 <span>&#43;</span>
	                    </div>
	                </div>
	                <a href="#" class="btn btn-outline-electric btn-block">AÑADIR AL CARRO</a>
	            </div> <!-- /.producto -->
        	</c:forEach>
        </div> <!-- /.contenido -->

        <a href="#top" class="top">Top</a>
       
     </div> <!-- /.contenedor -->
     
<%@ include file="includes/footer.jsp" %>