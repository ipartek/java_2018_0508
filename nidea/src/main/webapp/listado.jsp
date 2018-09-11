<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<main role="main" class="container">
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Código</th>
      <th scope="col">Nombre</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Precio</th>
      <th scope="col">Oferta</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Código</td>
      <td>Nombre</td>
      <td>Descripción</td>
      <td>Precio</td>
      <td>Oferta</td>
    </tr>
    <tr>
       <th scope="row">2</th>
      <td>Código</td>
      <td>Nombre</td>
      <td>Descripción</td>
      <td>Precio</td>
      <td>Oferta</td>
    </tr>
    <tr>
       <th scope="row">3</th>
      <td>Código</td>
      <td>Nombre</td>
      <td>Descripción</td>
      <td>Precio</td>
      <td>Oferta</td>
    </tr>
  </tbody>
</table>
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-end">
    <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">Previous</a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>
</main> 
    	
<%@include file="includes/footer.jsp" %>
