<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%! int count=50; %>
<main role="main" class="container">
<table id="tablaordenada" class="display responsive nowrap" width="100%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Código</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Oferta</th>
            </tr>
        </thead>
        <tbody>
            <% for(int i=0;i<count;i++) { %>
			<tr>
                <td><%= i %></td>
                <td>Código <%= i %></td>
                <td>Nombre <%= i %></td>
                <td>Descipcion <%= i %></td>
                <td>Precio <%= i %>€</td>
                <td>Oferta <%= i %></td>
            </tr>
			<% } %>
        </tbody>
        <tfoot>
            <tr>
                <th>ID</th>
                <th>Código</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Oferta</th>
            </tr>
        </tfoot>
    </table>
</main> 

		
    	
<%@include file="includes/footer.jsp" %>
