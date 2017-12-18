//按钮点击切换效果
function isClicked(ele) {
	$(".regbut").removeClass("onactive");
	$(ele).addClass("onactive");
	window.history.go("-1");
}
// 上传图片回显
$(function() {
	if (license_src != null && "" != license_src) {
		$("#license_src").attr("src", license_src);
	}
	if (organize_src != null && "" != organize_src) {
		$("#organize_src").attr("src", organize_src);
	}
	if (tax_src != null && "" != tax_src) {
		$("#tax_src").attr("src", tax_src);
	}
})
var ele = ""
function createFD() {
	var fd = new FormData();
	fd.append("upload", 1);
	fd.append("upfile", $("#" + ele).get(0).files[0]);
	return fd;
}
// ajax上传图片
function uploadFile(id) {
	ele = id;
	$.ajax({
		type : 'POST',
		url : "http://api.honpe.com:8099/api/oms/file/postuploadsuppic",
		data : createFD(),
		cache : false,
		contentType : false,
		processData : false,
		success : function(data) {
			if (data.Status == 0) {
				console.log(data.Data[0])
				$("#" + ele + "_src").attr("src", data.Data[0]);
				$("#input_" + ele).val(data.Data[0])
			}
		}
	})
}
// 数据前端验证
$(function() {
	$("#jsform").validate({
		rules : {
			username : {
				required : true,
				minlength : 6
			},
			password : {
				required : true,
				minlength : 6
			},
			confirm_password : {
				required : true,
				equalTo : "#password"
			},
			email : {
				required : true,
				email : true
			},
			phone : {
				required : true,
				mobile : true
			},
			company : {
				required : true
			},
			orgCode : {
				required : true,
				isOrgCode : true
			},
			taxcode : {
				required : true
			},
			bank : {
				required : true
			},
			bankNum : {
				required : true
			}
		},
		messages : {
			username : {
				required : "必填项",
				minlength : $.validator.format("输入用户名过短")
			},
			password : {
				required : "必填项",
				minlength : $.validator.format("输入密码过短")
			},
			confirm_password : {
				required : "必填项",
				equalTo : "确认密码必须和输入密码一致"
			},
			email : {
				required : "必填项",
				email : "邮箱格式不正确"
			},
			phone : {
				required : "必填项"
			},
			company : {
				required : "必填项"
			},
			orgCode : {
				required : "必填项"
			},
			taxcode : {
				required : "必填项"
			},
			bank : {
				required : "必填项"
			},
			bankNum : {
				required : "必填项"
			},
			submitHandler : function() {
				$("#jsfrom").submit();
			}
		}
	})
})
$.validator.setDefaults({
	errorElement : 'span'
});
// 组织机构代码验证规则
function isValidOrgCode(orgCode) {
	return "" == orgCode || orgCode.length == 10;
	var ret = false;
	var codeVal = [ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" ];
	var intVal = [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
			27, 28, 29, 30, 31, 32, 33, 34, 35 ];
	var crcs = [ 3, 7, 9, 10, 5, 8, 4, 2 ];
	if (!("" == orgCode) && orgCode.length == 10) {
		var sum = 0;
		for (var i = 0; i < 8; i++) {
			var codeI = orgCode.substring(i, i + 1);
			var valI = -1;
			for (var j = 0; j < codeVal.length; j++) {
				if (codeI == codeVal[j]) {
					valI = intVal[j];
					break;
				}
			}
			sum += valI * crcs[i];
		}
		var crc = 11 - (sum % 11);
		switch (crc) {
		case 10: {
			crc = "X";
			break;
		}
		default: {
			break;
		}
		}
		if (crc == orgCode.substring(9)) {
			ret = true;
		}
	} else if ("" == orgCode) {
		ret = true;
	}
	return ret;
}
// 手机验证规则
jQuery.validator.addMethod("mobile", function(value, element) {
	var mobile = /^1[3|4|5|7|8]\d{9}$/;
	return this.optional(element) || (mobile.test(value));
}, "手机格式不正确");
// 组织机构代码验证
jQuery.validator.addMethod("isOrgCode", function(value, element) {
	var isok = isValidOrgCode(value);
	return this.optional(element) || isok;
}, "格式不正确");