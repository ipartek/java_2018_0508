<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn"  uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${not empty juego }">
	<h2>Video juego creado</h2>
	id: ${ juego.id }
	titulo : id: ${ juego.titulo }
	<br>
	fecha inicio : ${juego.fechaLanzamiento }
</c:if>