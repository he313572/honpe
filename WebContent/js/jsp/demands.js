//查询兼分页
function showPage(page, keyword) {
	$("#page").val(page);
	$("#keyword").val(keyword);
	$(".searchform")[0].submit();
}
// 分页按钮点击变色
$(".index").on("click", function() {
	$(".index").removeClass("current");
	$(this).addClass("current")
})
$(function() {
	// 搜索下拉列表初始化
	$(".searchbox option").each(function(index, ele) {
		if ($(ele).val() === fieldclass) {
			$(".searchbox option").removeAttr("selected");
			$(ele).attr("selected", "selected");
		}
	})
	// 右侧采购QQ咨询
	$("#aFloatTools_Show").click(function() {
		$('#divFloatToolsView').animate({
			width : 'show',
			opacity : 'show'
		}, 100, function() {
			$('#divFloatToolsView').show();
		});
		$('#aFloatTools_Show').hide();
		$('#aFloatTools_Hide').show();
	});
	$("#aFloatTools_Hide").click(function() {
		$('#divFloatToolsView').animate({
			width : 'hide',
			opacity : 'hide'
		}, 100, function() {
			$('#divFloatToolsView').hide();
		});
		$('#aFloatTools_Show').show();
		$('#aFloatTools_Hide').hide();
	});
})
