<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp"%>

<%@include file="includes/navbar.jsp"%>

<main class="container" role="main" >
	<h1 class="text-center mb-3 ">Listado de productos</h1>
	
	<table id="lista" class="display" style="width:100%">
        <thead class="thead-dark">
            <tr>
                <th>Nombre</th>
                <th>Categoría</th>
                <th>Código</th>
                <th>Precio &euro;</th>
                <th>En oferta</th>
                <th>Descripción</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Encimera tradicional</td>
                <td>Cocina</td>
                <td>C1234</td>
                <td>320,800 &euro;</td>
                <td>No</td>
                <td>Encimera clásica de los 90.</td>
            </tr>
            <tr>
                <td>Sofá de topos blanco</td>
                <td>Salón</td>
                <td>S1357</td>
                <td>170,750 &euro;</td>
                <td>Si</td>
                <td>Sofá blanco de gran tamaño.</td>
            </tr>
            <tr>
                <td>Juego toallas beige</td>
                <td>Baño</td>
                <td>B2468</td>
                <td>86,000 &euro;</td>
                <td>Si</td>
                <td>Juego de toallas completo de color beige.</td>
            </tr>
            <tr>
                <td>Escritorio moderno con cajón</td>
                <td>Habitación</td>
                <td>H1256</td>
                <td>433,000 &euro;</td>
                <td>No</td>
                <td>Escritorio de madera con cajonera de 4 cajones.</td>
            </tr>
            
        </tbody>
    </table>

</main>

<%@include file="includes/footer.jsp"%>