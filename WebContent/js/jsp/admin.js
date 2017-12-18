//退出登录
function logout() {
	$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(isConfirm) {
		if (isConfirm) {
			location.href = '/honpe/tuser/signOut';
		}
	});
}
// 修改密码
function editPassword() {
	$('#editPwdWindow').window('open');
}
// 取消修改密码
function cancelPwd() {
	$('#editPwdWindow').window('close');
}
// 自定义验证
$.extend($.fn.validatebox.defaults.rules, {
	equal : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '确认密码和新密码不相同'
	},
	noequal : {
		validator : function(value, param) {
			return value != $(param[0]).val();
		},
		message : '新密码不能和原密码相同'
	}
});
// 修改密码提交
$("#btnEp").click(function() {
	var v = $("#editPasswordForm").form("validate");
	if (v) {
		var v1 = $("#password").val();
		var v2 = $("#newpassword").val();
		var url = "/honpe/tuser/revisePassword";
		$.post(url, {
			"password" : v1,
			"newpassword" : v2
		}, function(data) {
			if (data == '1') {
				$.messager.alert("提示信息", "密码修改成功！", "info");
			} else {
				$.messager.alert("提示信息", "密码修改失败！", "warning");
			}
			$("#editPasswordForm").find("input").val("");
			$("#editPwdWindow").window("close");
		});
	}
});
$(function() {
	// 树导航加载
	$('#treeMenu').tree({
		url : "/honpe/json/menu.json",
		method : "GET",
		animate : true,
		onClick : function(node) {
			treeOnClick(node)
		}
	});
	// 时间显示
	changetime();
	setInterval(changetime, 1000);
})
// 底部日期时间显示
function changetime() {
	var ary = Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	var date = new Date();
	var str = '    ' + date.toLocaleString() + '   ' + ary[date.getDay()];
	$("#today").html(str);
}
// 树导航添加事件
function treeOnClick(node) {
	// 判断树菜单节点是否含有 page属性
	if (node.page != undefined && node.page != "") {
		var url = "/honpe/" + node.page;
		var content = "<iframe src='" + url + "' scrolling='auto' style='width:100%;height:100%;border:0;'' ></iframe>"
		if ($("#centertab").tabs('exists', node.text)) {
			$('#centertab').tabs('select', node.text);
			var tab = $('#tabs').tabs('getSelected');
			$('#centertab').tabs('update', {
				tab : tab,
				options : {
					title : node.text,
					content : content
				}
			});
		} else {
			// 开启一个新的tab页面
			$('#centertab').tabs('add', {
				title : node.text,
				content : content,
				closable : true
			});
		}
	}
}