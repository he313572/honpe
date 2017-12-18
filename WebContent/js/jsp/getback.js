//按钮点击切换效果
function isClicked(ele) {
	$(".getbut").removeClass("onactive");
	$(ele).addClass("onactive");
	window.history.go("-1");
}
// 选项卡
$(".tabcontainer div").on("click", function() {
	$(this).css("background", "url(/honpe/img/tab1.png) no-repeat");
	$(this).siblings("div").css("background", "url(/honpe/img/tab2.png) no-repeat");
	var index = $(this).index()
	if (index == 0) {
		$(".tabinfo1").css("display", "block");
		$(".tabinfo2").css("display", "none");
	} else {
		$(".tabinfo1").css("display", "none");
		$(".tabinfo2").css("display", "block");
	}
})
// 按钮绑定发送邮件事件
$(function() {
	$("#sendemail").on("click", sendEmail);
	countdown = $.cookie("emailcookie");
	if (countdown > 0) {
		setTime($("#sendemail"))
	}
})
// 邮件发送验证码
function sendEmail() {
	var emailaddr = $("#email").val();
	if ("" == emailaddr) {
		$('#mymodel1').modal();
		return;
	}
	if (!(/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/.test(emailaddr))) {
		$("#warning1").html("邮箱格式不正确");
		$('#mymodel1').modal();
		return;
	}
	var url = "/honpe/getEmailCode";
	$.get(url, {
		email : emailaddr
	}, function(data) {
		if (data == 1) {
			$.cookie("emailcookie", 60, {
				expires : (1 / 86400) * 60
			});
			setTime($("#sendemail"))
		} else if (data == 2) {
			console.log(data);
			$('#prompt').html('无此邮箱注册');
		} else {
			$('#prompt').html('获取验证码失败，请稍后重试');
		}
	})
}
// 开始计算时间
function setTime(ele) {
	countdown = $.cookie("emailcookie");
	if (countdown == 0 || countdown == undefined) {
		clearInterval(time);
		ele.html("获取验证码");
		ele.on("click", sendEmail);
		return;
	} else {
		ele.off("click", sendEmail);
		ele.html(countdown + "秒");
		countdown--
		$.cookie("emailcookie", countdown, {
			expires : (1 / 86400) * (countdown + 1)
		});
	}
	var time = setTimeout(function() {
		setTime(ele)
	}, 800)
}

// 手机发送验证码
$("#sendphone").on("click", sendMsg);
function sendMsg() {
	$('#mymodel2').modal();
	// var telephoneaddr = $("#telephone").val();
	// if ("" == telephoneaddr) {
	// $('#mymodel2').modal();
	// return;
	// }
	// if (!(/^1[3|4|5|7|8]\d{9}$/.test(telephoneaddr))) {
	// $("#warning2").html("手机格式不正确");
	// $('#mymodel2').modal();
	// return;
	// }
	// var url = ""
	// $.get(url, {
	// telephone : telephoneaddr
	// }, function(data) {
	// if (data == 1) {
	// $(".sendphone").off("click", send)
	// var i = 60;
	// var j = setInterval(function() {
	// i--;
	// $(".sendphone").html(i + "秒");
	// if (i == 0) {
	// clearInterval(j);
	// $(".sendphone").html("获取验证码");
	// $(".sendphone").on("click", send);
	// }
	// }, 1000)
	// }
	// })
}

// 表单1数据前端验证
$(function() {
	$("#jsform1").validate({
		rules : {
			password : {
				required : true
			},
			confirm_password : {
				required : true,
				equalTo : "#password"
			},
			code : {
				required : true,
				mobile : true
			}
		},
		messages : {
			password : {
				required : "必填项"
			},
			confirm_password : {
				required : "必填项",
				equalTo : "确认密码必须和输入密码一致"
			},
			code : {
				required : "必填项"
			}
		},
		submitHandler : function() {

		}
	})
})
// 表单2数据前端验证
$(function() {
	$("#jsform2").validate({
		rules : {
			password : {
				required : true
			},
			confirm_password : {
				required : true,
				equalTo : "#password"
			},
			code : {
				required : true,
				mobile : true
			}
		},
		messages : {
			password : {
				required : "必填项"
			},
			confirm_password : {
				required : "必填项",
				equalTo : "确认密码必须和输入密码一致"
			},
			code : {
				required : "必填项"
			}
		},
		submitHandler : function() {

		}
	})
})
$.validator.setDefaults({
	errorElement : 'span'
});