<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${empty alert }">
	${alert = null }
</c:if>

<c:if test="${not empty alert }">
	<div class="alert ${alert.tipo } alert-dismissible fade show mt-4 mb-4" role="alert">
		<span>${alert.texto }</span>
	 	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	 		<span aria-hidden="true">&times;</span>
	 	</button>
	</div>
	${sessionScope.alert=null}
</c:if>