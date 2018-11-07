<!-- Page codification -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp" %>
<%@ include file="/include/navbar.jsp" %>

        <main class="container" role="main">
	
            <h1><i class="fas fa-clipboard-list"></i> Listado de productos</h1>
                
            <table id="listado-productos" class="display">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Descuento</th>
                        <th>Precio / Litro</th>
                        <th>Descripción</th>
                        <th>Imagen (URL)</th>
                    </tr>
                </thead>

                <tbody>
                
                 <c:forEach items="${productos}" var="producto">
                    
                    <tr>
                        <td>${producto.nombre}</td>
                        <td>${producto.precio}&euro;</td>
                        <td>25</td>
                        <td>${producto.descuento}&#37;</td>
                        <td>${producto.precio}&euro; / ${producto.unidad}</td>
                        <td>${producto.descripcion}</td>
                        <td><img src="${producto.imagen}" alt="imagen-ginebra-beefeater" /></td>
                    </tr>
                    
                  </c:forEach>
                        
                </tbody>

            </table>
            
        </main>

<%@ include file="/include/footer.jsp" %>