<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div id="pagination">
	<div class="pagination_container">
		
		<c:forEach var="page" begin="1" end="${TotalPage}">
			<div class="page_number_item" onClick="insertParam('page', this.dataset.page)" data-page="${page}">
				${page}
			</div>
		</c:forEach>
	</div>
</div>