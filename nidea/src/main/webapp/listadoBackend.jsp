<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%
ArrayList <Producto> lista = new ArrayList<Producto>();
lista.add(new Producto("Mesa","M0","Basura",false,25.0f));
lista.add(new Producto("Silla","S0","Banco",true,45.0f));
lista.add(new Producto("Cama","C0","Nido",false,65.0f));
lista.add(new Producto("Sofa","SO0","Cuero",true,265.55f));
%>



<main role="main" class="container">
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Codigo</th>
      <th scope="col">Nombre</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Oferta</th>
    </tr>
  </thead>
  <tbody>
<!-- <% for (Producto p: lista){%>
  
  <tr>
  	<th scope="row">0</th>
  	  <td><%p.getCodigo(); %></td>
      <td><%p.getNombre(); %></td>
      <td><%p.getDescripcion(); %></td>
  <%} %> -->  
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td><input type="checkbox" name="oferta" class="form-control" tabindex="2"></td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
       <td><input type="checkbox" name="oferta" class="form-control" tabindex="2"></td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
       <td><input type="checkbox" name="oferta" class="form-control" tabindex="2"></td>
    </tr>
  </tbody>
</table>

</main>



<%@include file="includes/footer.jsp" %>