//查询兼分页
function showPage(currentPage, name) {
	$("#currentPage").val(currentPage);
	$("#name").val(name);
	$("#stafffrom")[0].submit();
}
// 分页按钮点击变色
$(".index").on("click", function() {
	$(".index").removeClass("current");
	$(this).addClass("current")
})
// 全选/全不选
$(".allcheck").on("change", function() {
	var state = $(this).is(":checked")
	if (state == true) {
		$("tbody input[type='checkbox']").prop("checked", true)
	} else {
		$("tbody input[type='checkbox']").prop("checked", false)
	}
})
// 单个删除
function deleteOne(id) {
	easyDialog.open({
		container : {
			header : '提示',
			content : '你确定要删除吗?',
			yesFn : function() {
				var url = './remove'
				$.get(url, {
					"id" : id
				}, function() {
					location.reload()
				})
			},
			noFn : true
		}
	});
}
// 批量删除
function batchDel() {
	var ids = '';
	$('.persontable tbody input[type=checkbox]').each(function(index, ele) {
		if ($(ele).is(":checked")) {
			ids += $(ele).val() + ',';
		}
	})
	if ('' != ids) {
		easyDialog.open({
			container : {
				header : '提示',
				content : '你确定要删除吗?',
				yesFn : function() {
					var url = './batch'
					$.get(url, {
						ids : ids
					}, function(data) {
						if (data == 1) {
							easyDialog.open({
								container : {
									content : '删除成功'
								},
								autoClose : 1000
							});
							location.reload()
						} else {
							easyDialog.open({
								container : {
									content : '删除失败'
								},
								autoClose : 1000
							})
						}
					})
				},
				noFn : true
			}
		});
	} else {
		$('#mymodel').modal();
	}
}