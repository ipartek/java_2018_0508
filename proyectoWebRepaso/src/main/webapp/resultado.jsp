<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Tratamiento de las alertas -->
		<c:if test="${not empty alert}">
			<div class="alert ${alert.tipo} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${alert.texto}</strong>
			</div>
		</c:if>

<p>El resultado de sumar los 2 parametros es:</p>
<h2>Expresion Lenguange</h2>
<p>${suma}</p>

<h2>Scriplet</h2>
<p><%=request.getAttribute("suma") %></p>