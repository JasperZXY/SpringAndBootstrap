<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/share.jsp" %>
<!DOCTYPE html>
<html>
<body>

<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<div style="margin-top:100px;"></div>
		<div>
			<form id="form-login" class="form-horizontal" role="form" method="post" action="/loginout/login">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="uid"
							placeholder="用户名" name="uid">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="uid"
							placeholder="密码" name="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="submit" type="submit" class="btn btn-info">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>

</body>
</html>
