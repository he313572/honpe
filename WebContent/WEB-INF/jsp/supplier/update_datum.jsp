<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改资料</title>
<link rel="shortcut icon" href="../img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/head_location.css" />
<link rel="stylesheet" href="../css/update_datum.css" />
<link rel="stylesheet" href="../css/footer.css" />
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
</head>

<body>
	<%@include file="../header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">您现在的位置：修改资料</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row title">修改供应商资料</div>
		<div class="row forminner">
			<form action="${pageContext.request.contextPath }/supplier/modify" method="post" id="jsform" enctype="multipart/form-data">
				<input type="hidden" name="sid" value="${supplier.sid }"> <input type="hidden" name="company" value="${supplier.company }">
				<input type="hidden" name="orgCode" value="${supplier.orgCode }"> <input type="hidden" name="nullify"
					value="${supplier.nullify }"> <input type="hidden" name="auditor" value="${supplier.auditor }"> <input type="hidden"
					name="audittime" value="${supplier.audittime }">
				<div class="col-md-7 col-sm-10 col-md-offset-3 col-sm-offset-2">

					<ul>
						<li class="formli"><label for="">公司名称：</label>${supplier.company }</li>
						<li class="formli"><label for="">组织机构代码：</label>${supplier.orgCode }</li>
						<li class="formli"><label for="bank">对公银行：</label> <input type="text" value="${supplier.bank }" name="bank" id="bank" /></li>
						<li class="formli"><label for="bankNum">对公帐号：</label> <input type="text" value="${supplier.bankNum }" name="bankNum" id="bankNum" /></li>
						<li class="formli"><label for="taxcode">税务登记号：</label> <input type="text" value="${supplier.taxcode }" name="taxcode"
							id="taxcode" /></li>
					</ul>
				</div>
				<div class="uploadbox col-md-8 col-sm-12 col-md-offset-2">
					<div class="col-md-4 col-sm-4">
						<p>组织机构证书</p>
						<img id="organize_src" src="../img/uploadimg.jpg" alt="" /> <input class="filebut" id="organize" onchange="uploadFile('organize')"
							type="file" /> <input type="hidden" name="organize" id="input_organize" value="${supplier.organize }" />
					</div>
					<div class="col-md-4 col-sm-4">
						<p>税务登记证书</p>
						<img id="tax_src" src="../img/uploadimg.jpg" alt="" /> <input id="tax" onchange="uploadFile('tax')" class="filebut" type="file" /> <input
							type="hidden" name="tax" id="input_tax" value="${supplier.tax }" />
					</div>
					<div class="col-md-4 col-sm-4">
						<p>营业执照</p>
						<img id="license_src" src="../img/uploadimg.jpg" alt="" /> <input id="license" onchange="uploadFile('license')" class="filebut"
							type="file" /><input id="input_license" type="hidden" name="license" value="${supplier.license }" />
					</div>
				</div>
				<div class="warning col-md-8 col-sm-12 col-md-offset-2">如果是三证合一，只需上传营业执照</div>
				<div class="formbut col-md-7 col-sm-10 col-md-offset-3 col-sm-offset-2">
					<input type="button" value="取消" onclick="isClicked(this)" /> <input class="updatebut onactive" type="submit" value="确认" />
				</div>
			</form>
		</div>
	</div>
	</section>
</body>
<script type="text/javascript">
	var license_src = "${supplier.license}"
	var organize_src = "${supplier.organize}"
	var tax_src = "${supplier.tax}"
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jsp/update_datum.js"></script>
</html>