<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="com.ipartek.formacion.nidea.model.ProductosDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- El detalle con un card -->
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tablas</title>

    
    
    <link rel="stylesheet" href="vendors/datatables/1.10.19/css/jquery.dataTables.min.css">    
    <link href="vendors/datatables/2.1.0/css/responsive.dataTables.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/tabla.css"/>    
    <script src="vendors/jquery/jquery-3.3.1.js"></script>
    <script src="vendors/jquery/1.10.19/js/jquery.dataTables.min.js"></script>    
    <script src="vendors/datatables/2.1.0/js/dataTables.responsive.js"></script>


    <script>
            //Esperamos a que todo el HTML este cargado == body onload
            $(document).ready(function() { 
                // $('#example')  => selecciona un objeto por id="example"
                // .DataTable();  => ejecutar el plugin de dataTable
                $('#example').DataTable({
                    "language": {
                        "url": "vendors/datatables/i18n/spanish/Spanish.json"
                    }
                });
            } );
        </script>
    

</head>
<body>

        <h1>Ejemplo Tabla con productos</h1>
        <a href="https://datatables.net" target="_blank">Documentacion oficial DataTables</a>
        <p>
        	<a href="index.jsp">Inicio</a>
        </p>
        

        <table id="example" class="display responsive nowrap" width="100%">
                <thead>
                    <tr>
                    	<th>Codigo</th>
                        <th>Nombre</th>           
                        <th>Descripcion</th>
                        <th>Oferta</th>
                        <th>Precio</th>
                        <th>Imagen</th>
                    </tr>
                </thead>
                <tbody>
                <%
					DecimalFormat df = new DecimalFormat("#0.00€");
					ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");	
				%>
	
				<%
				
					for (Producto producto : productos) {
				%>
                    <tr>
                        <td>Tiger Nixon</td>
                        <td>System Architect</td>
                        <td>Edinburgh</td>
                        <td>61</td>
                        <td>2011/04/25</td>
                        <td>$320,800</td>
                    </tr>
                    <%
						}
					%>
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
    
</body>
</html>