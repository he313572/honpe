//按钮点击切换效果
function isClicked(ele) {
	$(".editbut").removeClass("onactive");
	$(ele).addClass("onactive");
	window.history.go("-1");
}
// 表单数据前端验证
$(function() {
	$("#jsform").validate({
		rules : {
			phone : {
				required : true,
				tm : true

			},
			email : {
				required : true,
				email : true
			}
		},
		messages : {
			phone : {
				required : "必填项"
			},
			email : {
				required : "必填项",
				email : "邮箱格式不正确"
			}
		},
		submitHandler : function() {
			$("#jsform")[0].submit()
		}
	})
	// 电话或手机验证规则
	jQuery.validator
			.addMethod(
					"tm",
					function(value, element) {
						var tm = /(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
						return this.optional(element) || (tm.test(value));
					}, "手机格式不正确");
})
$.validator.setDefaults({
	errorElement : 'span'
})