
<%@page import="java.util.Iterator"%>
<%@page import="com.ipartek.formacion.gestor.libros.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="includes/header.jsp"%>
<%@ include file="includes/navbar.jsp"%>
<br>
<form action="listado" method="post">
	<table>
	
		<thead>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>ISBN</th>
				<th>Editorial</th>
				<th>Estado</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Libro> biblioteca = (ArrayList<Libro>)(request.getAttribute("biblioteca"));
			 	Iterator<Libro> it=biblioteca.iterator();
			%>
	
			<%while(it.hasNext()){
              Libro libro=it.next();%>
             <tr class="<%= (libro.isPrestado()==true)?"prestado":"libre" %>">
             	<td><%= libro.getId() %></td>
             	<td><%= libro.getTitulo() %></td>
             	<td><%= libro.getIsbn() %></td>
             	<td><%= libro.getEditorial() %></td>
             	<td><%= (libro.isPrestado()==true)?"Prestado":"Libre" %></td>
              </tr>
              <%}%>  
		</tbody>
		
	</table>
</form>
