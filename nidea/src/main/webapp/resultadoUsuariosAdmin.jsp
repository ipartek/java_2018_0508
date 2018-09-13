
<%@page import="com.ipartek.formacion.nidea.pojo.Usuario"%>
<%@page import="java.text.DecimalFormat" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <script>
            //Esperamos a que todo el HTML este cargado == body onload
            $(document).ready(function() { 
                // $('#example')  => selecciona un objeto por id="example"
                // .DataTable();  => ejecutar el plugin de dataTable
                $('#tablaOrdenable').DataTable({
                    "language": {
                        "url": "vendors/datatables/i18n/spanish/Spanish.json"
                    }
                });
            } );
        </script>
    


     <h1>Vista admin usuarios del sistema</h1>
     <a href="https://datatables.net" target="_blank">Documentacion oficial DataTables</a>
		<%
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
		%>
		<table id="tablaOrdenable" class="display responsive nowrap" width="100%">
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
    



<%@include file="includes/footer.jsp" %>