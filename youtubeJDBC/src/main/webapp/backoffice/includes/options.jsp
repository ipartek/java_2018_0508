<div class="options">
	<c:if test="${view != 'form'}">
		<a href="<%=request.getContextPath()%>/backoffice/usuario?view=form"><i class="fab fa-wpforms fa-3x"></i></a>
	</c:if>
	<c:if test="${view != 'tree'}">
		<a href="<%=request.getContextPath()%>/backoffice/usuario?view=tree"><i class="fas fa-th-list fa-3x"></i></a>
	</c:if>
	<c:if test="${view != 'kanban'}">
		<a href="<%=request.getContextPath()%>/backoffice/usuario?view=kanban"><i class="fas fa-grip-vertical fa-3x"></i></a>
	</c:if>
</div> 