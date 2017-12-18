//遮罩弹窗开启关闭
$("#close").bind("click", function() {
	$(".popup").animate({
		"width" : "0",
		"height" : "0",
		"top" : "50%",
		"left" : "50%"
	}, 800)
	$(".popup").css("display", "none");
});
function historyOffer() {
	$(".popup").css("display", "block")
	$(".popup").animate({
		"width" : "100%",
		"height" : "100%",
		"top" : 0,
		"left" : 0
	}, 800)
}
// 保留小数后一位
function toDecimal(x) {
	var f = parseFloat(x);
	if (isNaN(f)) {
		return;
	}
	f = Math.round(x * 100) / 100;
	return f;
}
$(function() {
	// 计算单项总价
	$(".inp").bind("blur", function() {
		var input = $(this).parent("td").siblings("td").find("input[type=text]");
		var val1 = parseFloat($(this).val()) ? parseFloat($(this).val()) : 0
		var val2 = parseFloat(input.val()) ? parseFloat(input.val()) : 0
		var sum = $(this).parent("td").parent("tr").children("td:last-child")
		var num = $(this).parent("td").parent("tr").children("input:first-child")
		var tdsum = "";
		if ($(this).attr("class") == "inp taxrate") {
			tdsum = toDecimal((val1 + 1) * val2 * parseInt(num.val()))
		} else {
			tdsum = toDecimal(val1 * (val2 + 1) * parseInt(num.val()))
		}
		sum.html(tdsum);
	})
	// 日历初始化格式
	$('.date').datepick({
		dateFormat : 'yy-mm-dd'
	});
})
var regex1 = new RegExp("^([1-9][0-9]{0,9})(\.[0-9])?$")

var regex2 = new RegExp("^0(\.[0-9][1-9])$")
// 保存报价
function saveOffer() {
	var flag = false;
	var pids = "", taxrates = "", prices = "", dates = ""
	$(".pid").each(function() {
		pids += $(this).val() + ","
	})
	$(".date").each(function() {
		if (!$(this).val()) {
			flag = true;
			easyDialog.open({
				container : {
					content : '交货日期不能为空'
				},
				autoClose : 800
			});
			return;
		}
		dates += $(this).val() + ","
	})
	if (flag)
		return;
	$(".taxrate").each(function() {
		if (!regex2.test($(this).val())) {
			flag = true;
			easyDialog.open({
				container : {
					content : '税率填写有误'
				},
				autoClose : 800
			});
			return;
		}
		taxrates += $(this).val() + ","
	})
	if (flag)
		return;
	$(".price").each(function() {
		if (!(regex1.test($(this).val()))) {
			flag = true;
			easyDialog.open({
				container : {
					content : '价格填写有误'
				},
				autoClose : 800
			});
			return;
		}
		prices += $(this).val() + ","
	})
	if (flag)
		return;
	var url = "/honpe/offer/save";
	$.post(url, {
		"pids" : pids,
		"taxrates" : taxrates,
		"prices" : prices,
		"dates" : dates,
		"demandId" : demandNum
	}, function(data) {
		if (data == 1) {
			easyDialog.open({
				container : {
					content : '保存成功'
				},
				autoClose : 2000
			});
		} else {
			easyDialog.open({
				container : {
					content : '保存失败,稍后重试'
				},
				autoClose : 2000
			});
		}
	}, "text");
}
// 提交报价
function submitOffer() {
	var flag = false;
	$("#offersubmit").attr("disabled", "disabled")
	var pids = "", taxrates = "", prices = "", dates = "", nums = "";
	$(".pid").each(function() {
		pids += $(this).val() + ","
	})
	$(".date").each(function() {
		if (!$(this).val()) {
			flag = true;
			easyDialog.open({
				container : {
					content : '交货日期不能为空'
				},
				autoClose : 800
			});
			return;
		}
		dates += $(this).val() + ","
	})
	if (flag) {
		$("#offersubmit").removeAttr("disabled");
		return;
	}
	$(".taxrate").each(function() {
		if (!regex2.test($(this).val())) {
			flag = true;
			easyDialog.open({
				container : {
					content : '税率填写有误'
				},
				autoClose : 800
			});
			return;
		}
		taxrates += $(this).val() + ","
	})
	if (flag) {
		$("#offersubmit").removeAttr("disabled");
		return;
	}
	$(".price").each(function() {
		if (!(regex1.test($(this).val()))) {
			flag = true;
			easyDialog.open({
				container : {
					content : '价格填写有误'
				},
				autoClose : 800
			});
			return;
		}
		prices += $(this).val() + ","
	})
	if (flag) {
		$("#offersubmit").removeAttr("disabled");
		return;
	}
	$(".number").each(function() {
		nums += $(this).html() + ","
	})
	easyDialog.open({
		container : {
			header : '提示',
			content : '你确定提交报价吗?',
			yesFn : function() {
				var url = '/honpe/offer/offer';
				$.post(url, {
					"pids" : pids,
					"taxrates" : taxrates,
					"prices" : prices,
					"dates" : dates,
					"nums" : nums,
					"demandId" : demandNum
				}, function(data) {
					if (data == 1) {
						easyDialog.open({
							container : {
								content : '报价成功'
							},
							autoClose : 2000
						});
						location.href = '/honpe/demand/list';
					} else {
						easyDialog.open({
							container : {
								content : '报价失败,稍后重试'
							},
							autoClose : 2000
						})
						$("#offersubmit").removeAttr("disabled");
					}
				})
			},
			noFn : function() {
				$("#offersubmit").removeAttr("disabled");
			}
		}
	}, function() {
		$("#offersubmit").removeAttr("disabled");
	});
}