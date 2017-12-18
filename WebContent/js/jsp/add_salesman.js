//按钮点击切换效果
function isClicked(ele) {
	$(".addbut").removeClass("onactive");
	$(ele).addClass("onactive");
	window.history.go("-1");
}
// 数据前端验证
$(function() {
	$("#jsform").validate({
		rules : {
			name : {
				required : true,
			},
			username : {
				required : true,
				minlength : 5
			},
			password : {
				required : true
			},
			confirm_password : {
				required : true,
				equalTo : "#password"
			},
			company : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			phone : {
				required : true,
				mobile : true
			}
		},
		messages : {
			name : {
				required : "必填项",
			},
			username : {
				required : "必填项",
				minlength : $.validator.format("输入用户名过短")
			},
			password : {
				required : "必填项"
			},
			confirm_password : {
				required : "必填项",
				equalTo : "确认密码必须和输入密码一致"
			},
			company : {
				required : "必填项"
			},
			email : {
				required : "必填项",
				email : "邮箱格式不正确"
			},
			phone : {
				required : "必填项"
			}
		},
		submitHandler : function() {
			$("#jsform").submit();
		}
	})
})
$.validator.setDefaults({
	errorElement : 'span'
});
// 手机验证规则
jQuery.validator.addMethod("mobile", function(value, element) {
	var mobile = /^1[3|4|5|7|8]\d{9}$/;
	return this.optional(element) || (mobile.test(value));
}, "手机格式不对");