<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/share.jsp" %>
<script type="text/javascript">
(function($) {
	
})(window.jQuery);
jQuery(function() {
	//$('#' + $('#select_group').val().trim()).addClass('in');
	//用这种方式预点击可以实现，不然左边栏的父菜单一开始要先点击一下才能正常使用
	$('#' + $('#select_group').val().trim()).prev().find('a').click();
	$('#' + $('#select_item').val().trim()).addClass('active');
});
</script>

<input type="hidden" value='<%out.println(request.getParameter("item"));%>' id="select_item" />
<input type="hidden" value='<%out.println(request.getParameter("group"));%>' id="select_group" />

<div class="container-fluid">
	<a href="/loginout/logout" class="row col-md-12 btn btn-danger">重新登录</a>
</div>
<div class="panel-group" id="accordion" role="tablist"
		aria-multiselectable="true">
		<div class="panel panel-info">
			<div class="panel-heading" role="tab" id="headingOne">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#user-manager" aria-expanded="true"
						aria-controls="collapseOne">用户管理 </a>
				</h4>
			</div>
			<div id="user-manager" class="panel-collapse collapse"
				role="tabpanel" aria-labelledby="headingOne">
				<div class="panel-body">
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<li id="user-add" role="presentation"><a href="/user/addUI">添加用户</a></li>
						<li id="user-list" role="presentation"><a href="/user/listAll">所有用户</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading" role="tab" id="headingTwo">
				<h4 class="panel-title">
					<a class="collapsed" data-toggle="collapse"
						data-parent="#accordion" href="#collapseTwo" aria-expanded="false"
						aria-controls="collapseTwo"> 系统管理 </a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
				aria-labelledby="headingTwo">
				<div class="panel-body">
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<li id="user-add" role="presentation"><a href="/user/addUI">添加用户</a></li>
						<li id="user-list" role="presentation"><a href="/user/listAll">所有用户</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading" role="tab" id="headingThree">
				<h4 class="panel-title">
					<a class="collapsed" data-toggle="collapse"
						data-parent="#accordion" href="#collapseThree"
						aria-expanded="false" aria-controls="collapseThree">
						系统管理 </a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse"
				role="tabpanel" aria-labelledby="headingThree">
				<div class="panel-body">
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<li id="user-add" role="presentation"><a href="/user/addUI">添加用户</a></li>
						<li id="user-list" role="presentation"><a href="/user/listAll">所有用户</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>