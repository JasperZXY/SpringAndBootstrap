/**
 * ajax请求，jsonp格式
 * 
 * @param {string} url 请求的路径
 * @param data 传递的参数
 * @param {Function} successFun 成功后调用的函数
 */
function ajaxJsonp(url, data, successFun) {
	jQuery.ajax('/jsonp' + url, {
		data : data,
		dataType : "jsonp"
	}).done(function(ret) {
		// alert(JSON.stringify(ret));
		if (ret.code == 0) {
			// alert('success:' + JSON.stringify(ret.data));
			successFun(ret.data);
		} else if (ret.code == 1) {
			alert('服务器异常，请重试或联系管理员');
		} else if (ret.code == 2) {
			alert('没有登录，请重新登录');
		}
	});
}

/**
 * ajax请求，json格式
 * 
 * @param {string} url 请求的路径
 * @param data 传递的参数
 * @param {Boolean} isPost 是否是post方式
 * @param {Function} successFun 成功后调用的函数
 */
function ajaxJson(url, data, isPost, successFun) {
	var type = 'POST';
	if (!isPost) {
		type = 'GET';
	}
	jQuery.ajax({
		dataType : "json",
		type : type,
		url : '/json' + url,
		data : data,
		success : function(ret) {
			if (ret.code == 0) {
				successFun(ret.data);
			} else if (ret.code == 1) {
				alert('服务器异常，请重试或联系管理员');
			} else if (ret.code == 2) {
				alert('没有登录，请重新登录');
			}
		}
	});
}