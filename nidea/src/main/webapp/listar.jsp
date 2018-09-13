<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="com.ipartek.formacion.nidea.model.ProductosDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<div class="container">

		<h1>Listado de productos</h1>
    <div class="row">

    	<%
		
    	DecimalFormat df = new DecimalFormat("#0.00€");
		ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
		
		for (Producto producto : productos) {
		%>
        <div class="col-sm-4">
            <div class="card">
                <img class="card-img-top img-fluid" src="<%=producto.getImagen()%>"" alt="Card image cap">
                <div class="card-body">
                    <h4 class="card-title text-primary"><%=producto.getNombre()%></h4>
                    

                    
                    <p class="card-text">Codigo: <%=producto.getCodigo()%></p>
                    <p class="card-text">Descripcion:<br> <%=producto.getDescripcion()%></p>
                   	<p class="card-text">Precio: <%=df.format(producto.getPrecio())%></p>
                    
                </div>
                <div class="card-footer">
				   	<p class="card-text">Precio: <%=df.format(producto.getPrecio())%></p>
				</div>
            </div>
        </div>
        <%
			}
        %>
    </div>
</div>