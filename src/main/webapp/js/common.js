/**
 * @param {string} url 请求的路径
 * @param data 传递的参数
 * @param {Function} successFun 成功后调用的函数
 */
function ajaxJsonp(url, data, successFun) {
	jQuery.ajax(url, {
		data: data,
		dataType: "jsonp"
	}).done(function(ret) {
		//alert(JSON.stringify(ret));
		if (ret.code == 0) {
			//alert('success:' + JSON.stringify(ret.data));
			successFun(ret.data);
		} else if (ret.code == 1) {
			alert('服务器异常，请重试或联系管理员');
		} else if (ret.code == 2){
			alert('没有登录，请重新登录');
		}
	});
}