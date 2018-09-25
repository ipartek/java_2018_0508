<%@ include file="includes/header.jsp" %>
<%@ include file="includes/nav.jsp" %>		



        <div class="contenido">
        <div class="titulo"><h2>Numero de productos ${numeroProductos}</h2></div>
        
			 <c:forEach items="${productos}" var="p"> 
			 
			 <c:if test="${p.descuento gt 0 }">
            <div class="producto">

                <p class="descuento">${p.descuento}&#37;</p>

                <img src="${p.imagen}" alt="imagen-producto" />

                <div class="texto-producto">

                    <p><span class="tachado">${p.precio}&euro;</span><span> ${p.calcularDescuento}&euro;</span></p>
                    <p class="precio-litro">(${p.precioCantidad }&euro; / Litro)</p>
                    <p>${p.descripcion}</p>

                    <div class="cantidad">
                        <span>&#45;</span> 1 <span>&#43;</span>
                    </div>

                </div>

                <a href="#">AÑADIR AL CARRO</a>

            </div> <!-- /.producto -->
            
            </c:if>
            <c:if test="${p.descuento le 0 }">
            
            <div class="producto">

              

                <img src="${p.imagen}" alt="imagen-producto" />

                <div class="texto-producto">

                    <p><span> ${p.precio}&euro;</span></p>
                    <p class="precio-litro">(${p.precioCantidad }&euro; / Litro)</p>
                    <p>${p.descripcion}</p>

                    <div class="cantidad">
                        <span>&#45;</span> 1 <span>&#43;</span>
                    </div>

                </div>

                <a href="#">AÑADIR AL CARRO</a>

            </div> <!-- /.producto -->
            
            
            
            </c:if>
            </c:forEach>
            

        </div> <!-- /.contenido -->

           <%@ include file="includes/footer.jsp" %> 