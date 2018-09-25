<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.supermercado.model.pojo.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat" %>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

        <div class="contenido">
			<%
 				DecimalFormat df = new DecimalFormat("#0.00€");
            	ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
            	for(Producto p : productos){
            		
            	
            %>
            <div class="producto">

                 <img src="<%=p.getImgUrl() %>" alt="imagen-producto" />
                <div class="card-body">
                    <h5 class="card-title"><span class="tachar"><%=df.format(p.getPrecioProducto()) %> </span><span class="oferta"><%=df.format(p.getFinalPrice()) %></span></h5>
                    <span class="badge badge-danger"><%=p.getDescuento() %>%</span>
                    <p >(<%=p.getPrecioUnidad() %> / Litro)</p>
                    <%-- <p class="card-text"><%=p.getNombreProducto() %></p> --%>
                    <p class="card-text"><%=p.getDescripcion() %></p>
                    <div class="cantidad">
                        <span>&#45;</span> <%=p.getPrecioUnidad() %> <span>&#43;</span>
                    </div>           
                </div>

                <a href="#">AÑADIR AL CARRO</a>

            </div> <!-- /.producto -->
<%
            	}
%>
            

            
        </div> <!-- /.contenido -->

        <a href="#top" class="top">Top</a>

<%@ include file="includes/footer.jsp" %>