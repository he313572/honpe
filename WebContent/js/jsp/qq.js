//加遮罩效果防止页面载入显示混乱
var pc;
// 不要放在$(function(){});中
$.parser.onComplete = function() {
	if (pc)
		clearTimeout(pc);
	pc = setTimeout(closes, 150);
}
function closes() {
	$('#loading').fadeOut('normal', function() {
		$(this).remove();
	});
}
// 修改QQ
function editQq() {
	var isValid = $('#qqform').form('validate');
	if (isValid == true) {
		$('#qqform').form("submit");
		$('#qq_editor').window('close');
		$.messager.alert('提示', '操作成功', "'info'");
		setTimeout(function() {
			location.reload();
		}, 1000)
	} else {
		$.messager.alert('警告', '请把表单填写完整', 'warning');
	}
}
// QQ号码验证
$.extend($.fn.validatebox.defaults.rules, {
	isqq : {
		validator : function(value, param) {
			var reg = /[1-9][0-9]{4,14}/g
			var result = reg.test(value)
			return result;
		},
		message : 'QQ号码格式不正确'
	}
});
// 身份证验证
$.extend($.fn.validatebox.defaults.rules, {
	idcardno : {
		validator : function(value, param) {
			var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/g
			var result = reg.test(value)
			return result;
		},
		message : '身份证格式有误'
	}
});
var toolbar = [ {
	iconCls : 'icon-edit',
	text : '修改QQ',
	handler : function() {
		var row = $('#qqlist').datagrid("getSelected");
		if (row == null) {
			$.messager.alert('消息', '请选择要求修改的qq号码', "info");
		} else {
			$('#qqform').form('load', {
				qid : row.qid,
				qqnum : row.qqnum,
				user : row.user,
				cardno : row.cardno
			});
			$('#qq_editor').window('open');
		}
	}
} ]
$('#qqlist').datagrid({
	toolbar : toolbar,
	fit : true,
	singleSelect : true
});