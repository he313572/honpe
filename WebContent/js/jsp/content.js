//加遮罩效果防止页面载入显示混乱
var pc;
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
// 内容预览
function preview(cid) {
	var url = '/honpe/content/preview/' + cid;
	window.open(url, '内容预览', 'location=0');
}
// 富文本编辑器配置
var addEditor;
var editEditor;
KindEditor.ready(function(K) {
	addEditor = K.create('#addcontent', {
		allowFileManager : true
	});
	editEditor = K.create('#editcontent', {
		allowFileManager : true
	});
});
// 添加内容提交
function submitAdd() {
	addEditor.sync();
	var isValid = $('#addform').form('validate');
	if (isValid == true) {
		$('#addform').form("submit");
		$('#addWindow').window('close');
		$.messager.alert('提示', '操作成功', "'info'");
		setTimeout(function() {
			location.reload();
		}, 1000)
	} else {
		$.messager.alert('警告', '请把表单填写完整', 'warning');
	}
}
// 编辑内容提交
function submitEdit() {
	editEditor.sync();
	var isValid = $('#editform').form('validate');
	if (isValid == true) {
		$('#editform').form("submit");
		$('#editWindow').window('close');
		$.messager.alert('提示', '操作成功', "'info'");
		setTimeout(function() {
			location.reload();
		}, 1000)
	} else {
		$.messager.alert('警告', '请把表单填写完整', 'warning');
	}
}
var toolbar = [ {
	iconCls : 'icon-add',
	text : '新增内容',
	handler : function() {
		$('#addWindow').window('open');
	}
}, {
	iconCls : 'icon-edit',
	text : '编辑内容',
	handler : function() {
		var row = $('#contentlist').datagrid("getSelected");
		if (row == null) {
			$.messager.alert('消息', '请选择要编辑的行', "info");
		} else {
			$('#editform').form('load', {
				cid : row.cid,
				contentname : row.name,
				contenttitle : row.title,
				caid : row.caid,
				category : row.category,
			});
			editEditor.html(row.content)
			$('#editWindow').window('open');
		}
	}
}, {
	iconCls : 'icon-clear',
	text : '删除内容',
	handler : function() {
		var row = $('#contentlist').datagrid("getSelected");
		if (row == null) {
			$.messager.alert('消息', '请选择要删除的行', "info");
		} else {
			$.messager.confirm('提示', '你确定要删除吗？', function(isConfirm) {
				if (isConfirm) {
					$.ajax({
						type : "POST",
						url : "/honpe/content/remove",
						data : "cid=" + row.cid,
						success : function(msg) {
							$.messager.alert("消息", "删除成功", "info");
							setTimeout(function() {
								location.reload();
							}, 1000)
						},
						error : function() {
							$.messager.alert('消息', '删除失败,请稍后重试', "info");
						}
					});
				}
			});

		}
	}
} ]
$('#contentlist').datagrid({
	toolbar : toolbar,
	fit : true,
	rownumbers : true,
	singleSelect : true
});