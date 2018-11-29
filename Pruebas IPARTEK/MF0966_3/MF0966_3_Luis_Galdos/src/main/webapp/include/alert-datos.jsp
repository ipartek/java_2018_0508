<%@page import="com.ipartek.formacion.personas.pojo.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


	<c:if test="${ not empty resultado }">
	
		<!-- ALERT-DATOS STARTS HERE -->
		<div class="alert alert-success alert-dismissible fade show mt-0" role="alert">

			<p>Lineas Leidas: ${ resultado.filasTotales }</p>
			<p>Lineas Insertadas: ${ resultado.filasIntroducidas }</p>
			<p>Lineas Evitadas: ${ resultado.filasEvitadas }</p>

			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
			</button>
		</div>
		
		${resultado = null}
	</c:if>
	
	