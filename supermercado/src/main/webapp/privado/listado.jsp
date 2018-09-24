<%@ include file="../includes/header.jsp" %>
<%@ include file="../includes/navbar.jsp" %>

        <main class="container" role="main">
	
            <h1><i class="fas fa-clipboard-list"></i> Listado de productos</h1>
                
            <table id="listado-productos" class="display">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Descuento</th>
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
                        <td>${p.precioUnidad }&euro; / L</td>
                        <td>${p.descripcion }</td>
                        <td><img src="${p.imagen }" alt="imagen-ginebra-beefeater" /></td>
                    </tr>
                </c:forEach>
                    
                        
                </tbody>

            </table>
            
        </main>
        
        
<%@ include file="../includes/footer.jsp" %>