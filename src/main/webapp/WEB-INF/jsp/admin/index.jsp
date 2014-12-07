<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>后台管理</title>
</head>
<body>

	<div class="col-md-3">
		<jsp:include page="/menu.jsp" flush="true">
			<jsp:param name="item" value="" />
			<jsp:param name="group" value="" />
		</jsp:include>
	</div>
	
	<div class="col-md-9">
		<h3>待完善</h3>
		<ul>
			<li>退出按钮放的位置需调整</li>
			<li>用户的修改，可考虑添加一个异步操作</li>
		</ul>
	</div>

</body>
</html>