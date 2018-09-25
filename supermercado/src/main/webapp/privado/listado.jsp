<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/navbar.jsp" %>

        <main class="container" role="main">
        
        	<c:if test="${empty alert }">
      		${alert = null }
      		
	      	</c:if>
	      	
	      	<c:if test="${not empty alert }">
	      	
	      		<div class="alert ${alert.tipo } alert-dismissible fade show" role="alert">
				  <p>${alert.texto }</p>
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
	      	</c:if>	
	      		
            <h1><i class="fas fa-clipboard-list"></i> Listado de productos</h1>
                
            <table id="listado-productos" class="display">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Descuento</th>
                        <th>Precio final</th>
                        <th>Precio / Litro</th>
                        <th>Descripción</th>
                        <th>Imagen (URL)</th>
                    </tr>
                </thead>

                <tbody>
                
                <%
                
                ArrayList<Producto> productos = (ArrayList<Producto>)request.getAttribute("productos"); 
                
                %>
                
                <c:forEach items="${productos }" var="p">
                	<tr>
                        <td>${p.nombre }</td>
                        <td>${p.precio }&euro;</td>
                        <td>${p.descuento }&#37;</td>
                        <td>${p.calcularDescuento }&euro;</td>
                        <td>${p.precioUnidad }&euro; / L</td>
                        <td>${p.descripcion }</td>
                        <td><img src="${p.imagen }" alt="imagen-producto" /></td>
                    </tr>
                </c:forEach>
                    
                        
                </tbody>

            </table>
            
        </main>
        
        
<%@ include file="../includes/footer.jsp" %>