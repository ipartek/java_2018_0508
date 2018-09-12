<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="java.text.DecimalFormat" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%-- <%@include file="vendors/datatables/1.10.19/css/jquery.dataTables.min.css" %>
<%@include file="vendors/datatables/2.1.0/css/responsive.dataTables.css" %>
<%@include file="vendors/jquery/jquery-3.3.1.js" %>
<%@include file="vendors/jquery/1.10.19/js/jquery.dataTables.min.js" %>
<%@include file="vendors/datatables/2.1.0/js/dataTables.responsive.js" %>   --%>

  
    

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
                        <th>Name</th>
                        <th>Position</th>
                        <th>Office</th>
                        <th>Age</th>
                        <th>Start date</th>
                        <th>Salary</th>
                    </tr>
                </tfoot> -->
       </table>

<%-- <%
	Producto p = (Producto)request.getAttribute("productos");
	DecimalFormat df = new DecimalFormat("#0.00€");

%>
	<main role="main" class="container">
	
		<table id="example" class="display responsive nowrap" width="100%">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Position</th>
                        <th>Office</th>
                        <th>Age</th>
                        <th>Start date</th>
                        <th>Salary</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Tiger Nixon</td>
                        <td>System Architect</td>
                        <td>Edinburgh</td>
                        <td>61</td>
                        <td>2011/04/25</td>
                        <td>$320,800</td>
                    </tr>

                </tbody>
                <tfoot>
                    <tr>
                        <th>Name</th>
                        <th>Position</th>
                        <th>Office</th>
                        <th>Age</th>
                        <th>Start date</th>
                        <th>Salary</th>
                    </tr>
                </tfoot>
            </table>
	</main> --%>
	
	


<%@include file="includes/footer.jsp" %>