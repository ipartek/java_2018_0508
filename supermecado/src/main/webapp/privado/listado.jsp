
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.supermercado.model.pojo.*"%>
<%@ include file="../includes/header.jsp" %>    
<%@ include file="../includes/navbar.jsp" %>    
    <div class="contenedor">

         

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
                   <%
         			ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos"); 
                  	for(Producto p : productos){
                	  
                 
       		 		%>
                    <tr>
                        <!-- <td>Beefeater</td>
                        <td>12.95&euro;</td>
                        <td>25</td>
                        <td>20&#37;</td>
                        <td>18.50&euro; / L</td>
                        <td>BEEFEATER ginebra inglesa botella 70cl.</td>
                        <td><img src="https://supermercado.eroski.es/images/313577.jpg" alt="imagen-ginebra-beefeater" /></td> -->
                        <td><%=p.getNombreProducto() %></td>
                        <td><%=p.getPrecioProducto() %>&euro;</td>
                        <td><%=p.getPrecioUnidad() %></td>
                        <td><%=p.getDescuento() %>;</td>
                        <td><%=p.getPrecioUnidad() %>&euro; / L</td>
                        <td><%=p.getDescripcion() %></td>
                        <td><img src="<%=p.getImgUrl() %>" alt="imagen-ginebra-beefeater" /></td>
                    </tr>
                        
                   <%
                  }
                   %>
                        
                </tbody>

            </table>
            
        </main>
    <%@ include file="../includes/footer.jsp" %>  

