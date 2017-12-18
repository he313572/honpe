<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">您现在的位置：注册</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row">
			<div class="col-md-7 col-sm-8 col-md-offset-3 col-sm-offset-2 registerform">
				<form action="${pageContext.request.contextPath}/tuser/register" method="post" id="jsform" enctype="multipart/form-data">
					<ul>
						<font class="remind">${registerError }</font>
						<li class="formli"><label for="username"> <img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />用户名：
						</label> <input type="text" name="username" value="${tuser.username }" id="username" /></li>
						<li class="formli"><label for="password"> <img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />密码：
						</label> <input type="password" value="${tuser.password }" name="password" id="password" /></li>
						<li class="formli"><label for="confirm_password"> <img class="stars"
								src="${pageContext.request.contextPath}/img/stars.png" />确认密码：
						</label> <input type="password" value="${confirm_password }" name="confirm_password" id="confirm_password" /></li>
						<li class="formli"><label for="email"> <img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />邮箱：
						</label> <input type="text" value="${tuser.email }" name="email" required="true" id="email" /></li>
						<li class="formli"><label for="phone"> <img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />手机：
						</label> <input type="text" value="${tuser.phone }" name="phone" id="phone" /></li>
						<li class="formli"><label for="company"> <img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />公司：
						</label> <input type="text" value="${supplier.company }" name="company" id="company" /></li>
						<li class="formli"><label for="orgCode"> <img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />组织机构代码：
						</label> <input type="text" value="${supplier.orgCode }" name="orgCode" id="orgCode" /></li>
						<li class="formli"><label for=taxcode><img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />税务登记号：</label>
							<input type="text" value="${supplier.taxcode }" name="taxcode" id="taxcode" /></li>
						<li class="formli"><label for="bank"><img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />对公银行：</label> <input
							type="text" value="${supplier.bank }" name="bank" id="bank" /></li>
						<li class="formli"><label for="bankNum"> <img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />对公帐号：
						</label> <input type="text" value="${supplier.bankNum }" name="bankNum" id="bankNum" /></li>
						<li class="formli"><label for="license"><img class="stars" src="${pageContext.request.contextPath}/img/stars.png" />请上传：</label>
							<div class="uploadbox">
								<input type="hidden" value="${supplier.license }" name="license" id="input_license"> <img id="license_src" width="100"
									height="90" src="${pageContext.request.contextPath}/img/license.jpg" alt="" title="营业执照" /> <input id="license"
									onchange="uploadFile('license')" type="file" />
							</div>
							<div class="uploadbox">
								<input type="hidden" value="${supplier.organize }" name="organize" id="input_organize"> <img id="organize_src" width="100"
									height="90" src="${pageContext.request.contextPath}/img/organize.jpg" alt="" title="组织机构证书" /> <input id="organize"
									onchange="uploadFile('organize')" type="file" />
							</div>
							<div class="uploadbox">
								<input type="hidden" value="${supplier.tax }" name="tax" id="input_tax"> <img id="tax_src" width="100" height="90"
									src="${pageContext.request.contextPath}/img/tax.jpg" alt="" title="税务登记证" /> <input onchange="uploadFile('tax')" id="tax"
									type="file" />
							</div></li>
						<p class="prompt">如果是三证合一，只需上传营业执照</p>
					</ul>
					<p class="formsubmit">
						<input type="button" value="取消" onclick="isClicked(this)" /> <input class="regbut onactive" type="submit" value="注册" />
					</p>
			</div>
		</div>
	</div>
	</section>
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript">
	var license_src = "${supplier.license}"
	var organize_src = "${supplier.organize}"
	var tax_src = "${supplier.tax}"
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsp/register.js"></script>
</html>