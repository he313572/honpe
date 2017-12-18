//iframe自适应高度
function iframeLoad(ele) {
	var mainheight = $(ele).contents().find("body").height();
	$(ele).height(mainheight);
}
// 导航栏点击
function goPage(cid, eles) {
	document.getElementById('iframe').src = "/honpe/content/preview/" + cid;
	$(".naticenav li").each(function(index, ele) {
		$(ele).removeClass("curul");
	})
	$(eles).addClass("curul");
}
$(function() {
	// 导航栏显示当前页面
	$(".naticenav li").each(function(index, ele) {
		var val = $(ele).attr("value");
		var cur = cid;
		if (val == cur) {
			$(ele).addClass("curul");
		}
	})
})
// 左侧导航栏手风琴动画效果
var i = 0;
$(".title1").on("click", function() {
	var height = -10
	if (i % 2 != 0) {
		height = 152
	}
	$(this).next("ul").animate({
		height : height
	}, 350)
	i++;
})
var m = 0;
$(".title2").on("click", function() {
	var height = 0
	if (m % 2 != 0) {
		height = 152
	}
	$(this).next("ul").animate({
		height : height
	}, 350)
	m++;
})
var n = 0;
$(".title3").on("click", function() {
	var height = 0
	if (n % 2 != 0) {
		height = 152
	}
	$(this).next("ul").animate({
		height : height
	}, 350)
	n++;
})