//按钮点击切换效果
function isClicked(ele) {
	$(".pwdbut").removeClass("onactive");
	$(ele).addClass("onactive");
	window.history.go("-1");
}
// 表单数据前端验证
$(function() {
	$("#jsform").validate({
		rules : {
			password : {
				required : true
			},
			newpassword : {
				required : true,
				notEqual : "#password"
			},
			confirm_password : {
				required : true,
				equalTo : "#newpassword"
			}
		},
		messages : {
			password : {
				required : "必填项"
			},
			newpassword : {
				required : "必填项",
				notEqual : "新密码不能和原密码一样"
			},
			confirm_password : {
				required : "必填项",
				equalTo : "确认密码必须和输入密码一致"
			}
		},
		submitHandler : function() {
			$("#jsform")[0].submit()
		}
	})
	// 自定义验证规则
	$.validator.addMethod("notEqual", function(value, element, param) {
		var val = $(param).val();
		var flag = val === value ? false : true;
		return this.optional(element) || flag;
	}, "新密码不能和原密码一样")
})
$.validator.setDefaults({
	errorElement : 'span'
})