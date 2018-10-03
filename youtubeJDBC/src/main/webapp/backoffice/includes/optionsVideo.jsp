
<div class="options">
	<c:if test="${view != 'form'}">
		<a href="<%=request.getContextPath()%>/backoffice/video?view=form"><i class="fab fa-wpforms fa-3x"></i></a>
	</c:if>
	<c:if test="${view != 'tree'}">
		<a href="<%=request.getContextPath()%>/backoffice/video?view=tree"><i class="fas fa-th-list fa-3x"></i></a>
	</c:if>
	<c:if test="${view != 'kanban'}">
		<a href="<%=request.getContextPath()%>/backoffice/video?view=kanban"><i class="fas fa-grip-vertical fa-3x"></i></a>
	</c:if>
</div> 