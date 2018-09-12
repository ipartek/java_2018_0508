<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">

	<main class="container" role="main">
		<h1 class="text-center">Listado de Productos</h1>
		
		<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>id</th>
                <th>Código</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Oferta</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>0</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>1</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>2</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>3</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>4</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>5</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>6</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>7</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>8</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>9</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
           <tr>
                <td>10</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>1</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>0</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>1</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>0</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>1</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
           <tr>
                <td>0</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>1</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>0</td>
                <td>M0</td>
                <td>Mesa</td>
                <td>bslblsblsblsblslbslblsblsblslbslblsblslbslblsblslblsblslblsblsblslblsblsblslbl</td>
                <td>61&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            <tr>
                <td>1</td>
                <td>S0</td>
                <td>Sofá</td>
                <td>El mejor sofá around the world</td>
                <td>250&euro;</td>
                <td><input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="option1" aria-label="..."></td>
            </tr>
            
        </tbody>
        <tfoot>
            <tr>
                <th>Id</th>
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