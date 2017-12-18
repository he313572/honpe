//按钮点击切换效果
function isClicked(ele) {
	$(".updatebut").removeClass("onactive");
	$(ele).addClass("onactive");
	window.history.go("-1");
}
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
// 图片回显
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