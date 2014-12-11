<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/share.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript">
jQuery(function() {
	$('#submit_jsonp').on('click', function(e) {
		if ($('#password2').val() == '' || $('#password').val() == '') {
			alert('密码不能为空');
			return;
		}
		if ($('#password2').val() != $('#password').val()) {
			alert('两次密码不一致');
			return;
		}
		var $data = $("#form-user").serialize();
		ajaxJsonp("/user/addForJsonp", $data, function(ret) {
			alert('成功：id=' + ret);
		});
		e.preventDefault();
	})
	$('#submit_json').on('click', function(e) {
		if ($('#password2').val() == '' || $('#password').val() == '') {
			alert('密码不能为空');
			return;
		}
		if ($('#password2').val() != $('#password').val()) {
			alert('两次密码不一致');
			return;
		}
		var $data = $("#form-user").serialize();
		ajaxJson("/user/addForJson", $data, true, function(ret) {
			alert('成功：id=' + ret);
		});
		e.preventDefault();
	})
});
</script>
<title>用户管理</title>
</head>
<body>

	<div class="col-md-3">
		<jsp:include page="/menu.jsp" flush="true">
			<jsp:param name="group" value="user-manager" />
			<jsp:param name="item" value="user-add" />
		</jsp:include>
	</div>

	<div class="col-md-5">
		<form id="form-user" class="form-horizontal" role="form" method="post" action="/user/add">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name"
						placeholder="用户名" name="name">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password"
						placeholder="密码" name="password">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码确认</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password2"
						placeholder="密码确认" name="password2">
				</div>
			</div>
			<div class="form-group">
				<label for="age" class="col-sm-2 control-label">年龄</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="age"
						placeholder="年龄" name="age">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="submit_json" type="button" class="btn btn-info">确定(json)</button>
					<button id="submit_jsonp" type="button" class="btn btn-info">确定(jsonp)</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>