<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/share.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试分页</title>
<script type="text/javascript">
jQuery(function() {
});
function topage(page) {
	$('#form-page').find('input[name="topage"]').val(page);
	$('#form-page').submit();
}
</script>
</head>
<body>

	<div class="col-md-3">
		<jsp:include page="/menu.jsp" flush="true">
			<jsp:param name="group" value="test" />
			<jsp:param name="item" value="admin-test-page" />
		</jsp:include>
	</div>

	<div class="col-md-9">
		<form id="form-page" action="/admin/testPage" method="get">
			<input type="hidden" name="topage">
		</form>
		<table id="list" class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>数据</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${page.result }" varStatus="status">
					<tr>
						<td>${item }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/fenye.jsp" %>
	</div>

</body>
</html>