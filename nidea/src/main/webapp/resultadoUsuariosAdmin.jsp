
<%@page import="com.ipartek.formacion.nidea.pojo.Usuario"%>
<%@page import="java.text.DecimalFormat" %>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tablas</title>

    
    
    <link rel="stylesheet" href="vendors/datatables/1.10.19/css/jquery.dataTables.min.css">    
    <link href="vendors/datatables/2.1.0/css/responsive.dataTables.css" rel="stylesheet" type="text/css" />      
    <script src="vendors/jquery/jquery-3.3.1.js"></script>
    <script src="vendors/jquery/1.10.19/js/jquery.dataTables.min.js"></script>    
    <script src="vendors/datatables/2.1.0/js/dataTables.responsive.js"></script>
    
    <link rel="stylesheet" href="css/tabla.css"/> 
    <!-- ***** -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css">    
    
    <script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script> 
    <script src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script> 


    <script>
            //Esperamos a que todo el HTML este cargado == body onload
            $(document).ready(function() { 
                // $('#example')  => selecciona un objeto por id="example"
                // .DataTable();  => ejecutar el plugin de dataTable
                $('#example2').DataTable({
                    "language": {
                        "url": "vendors/datatables/i18n/spanish/Spanish.json"
                    }
                });
            } );
        </script>
    

</head>
<body>
    

</head>
    
<body>

     <h1>Vista admin usuarios del sistema</h1>
     <a href="https://datatables.net" target="_blank">Documentacion oficial DataTables</a>
		<%
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
		%>
		<table id="example2" class="display responsive nowrap" width="100%">
			<thead>
                    <tr>
                    	<th>Id</th>
                        <th>Nombre</th>
                        <th>email</th>
                        <th>password</th>
                    </tr>
                </thead>
                <tbody>
                <%
                	for( Usuario u : usuarios){
                		
                	
                %>
                    <tr>
                    	<td><%=u.getId()%></td>
                        <td><%=u.getNombre()%></td>
                        <td><%=u.getEmail()%></td>
                        <td><%=u.getPassword()%></td>

                        
                    </tr>
				<%
					}
				%>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>email</th>
                        <th>password</th>
                    </tr>
                </tfoot>
       		</table> 
</body>    
</html>


<%@include file="includes/footer.jsp" %>