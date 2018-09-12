<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="java.text.DecimalFormat" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

Resultado productos admin
<%
	ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
	
%>
<table id="example" class="display responsive nowrap" width="100%">
<thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Codigo</th>
                        <th>Descripcion</th>
                        <th>Oferta</th>
                        <th>Precio</th>
                       
                    </tr>
                </thead>
                <tbody>
                <%
                	for( Producto p : productos){
                		
                	
                %>
                    <tr>
                        <td><%=p.getNombre()%></td>
                        <td><%=p.getCodigo()%></td>
                        <td><%=p.getDescripcion()%></td>
                        <td><%=p.isOferta()%></td>
                        <td><%=p.getPrecio()%></td>
                        
                    </tr>
				<%
					}
				%>
                </tbody>
                <!-- <tfoot>
                    <tr>
                       <th>Nombre</th>
                        <th>Codigo</th>
                        <th>Descripcion</th>
                        <th>Oferta</th>
                        <th>Precio</th>
                    </tr>
                </tfoot> -->
       </table>


<%@include file="includes/footer.jsp" %>