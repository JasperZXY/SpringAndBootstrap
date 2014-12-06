<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/share.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<script type="text/javascript">
jQuery(function() {
	$('#user-list button').on('click', function() {
		$tr = $(this).parents('tr');
		items = ['id', 'name', 'age'];
		for (i in items) {
			$('#form-user input[name=\"' + items[i] + '\"]').val($tr.find('.td-' + items[i]).html());
		}
		//$('#form-user input[name="id"]').val($tr.find('.td-id').html());
		//$('#form-user input[name="name"]').val($tr.find('.td-name').html());
		//$('#form-user input[name="age"]').val($tr.find('.td-age').html());
		$('#myModal').modal({show:true});
	});
	$('#update-user-bn').on('click', function() {
		if ($('#password2').val() == '') {
			$('#form-user .tip').html('密码不能为空');
			return;
		}
		if ($('#password2').val() != $('#password').val()) {
			$('#form-user .tip').html('两次密码不一致');
			return;
		}
		$('#form-user').submit();
	});
});
</script>
</head>
<body>

	<div class="col-md-3">
		<jsp:include page="/menu.jsp" flush="true">
			<jsp:param name="item" value="user-list" />
			<jsp:param name="group" value="user-manager" />
		</jsp:include>
	</div>

	<div class="col-md-6">
		<table id="user-list" class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>id</th>
					<th>用户名</th>
					<th>密码</th>
					<th>年龄</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users }" varStatus="status">
					<tr>
						<td class="td-id">${user.id }</td>
						<td class="td-name">${user.name }</td>
						<td class="td-password">${user.password }</td>
						<td class="td-age">${user.age }</td>
						<td>
							<button type="button" class="btn btn-primary" data-toggle="modal">编辑</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
					</div>
					<div class="modal-body">
						<form id="form-user" class="form-horizontal" role="form" method="post" action="/user/update">
							<input type="hidden" name="id" />
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
							<div class="tip">
							
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button id="update-user-bn" type="submit" class="btn btn-primary">确定</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>