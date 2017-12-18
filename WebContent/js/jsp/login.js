//自动登录复选框点击
var flag = 0
function check(ele) {
	if (flag % 2 == 0) {
		$("#autologin").attr("checked", "checked");
		$(ele).css({
			"background" : 'url(/honpe/img/gou.png) no-repeat',
			"background-size" : "cover"
		});
	} else {
		$("#autologin").attr("checked", "");
		$(ele).css("background", "none");
	}
	flag++;
}
// 按钮点击切换效果
function isClicked(ele) {
	$(".submitbnt").removeClass("onactive");
	$(ele).addClass("onactive");
	location.href = '/honpe/register';
}
// 异步加载须知导航链接列表
$(function() {
	var getUrl = '/honpe/content/title'
	$.get(getUrl, function(data) {
		var group1 = data.group1;
		for (i in group1) {
			var html = "<a href='/honpe/natice/" + group1[i].cid + "'><li>" + group1[i].contentname + "</li></a>"
			$("#ul1").append(html);
		}
		var group2 = data.group2;
		for (i in group2) {
			var html = "<a href='/honpe/natice/" + group2[i].cid + "'><li>" + group2[i].contentname + "</li></a>"
			$("#ul2").append(html);
		}
		var group3 = data.group3;
		for (i in group3) {
			var html = "<a href='/honpe/natice/" + group3[i].cid + "'><li>" + group3[i].contentname + "</li></a>"
			$("#ul3").append(html);
		}
	})
})