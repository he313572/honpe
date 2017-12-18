<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/getback.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">您现在的位置：找回密码</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row tabcontainer">
			<div class="tableft col-md-6 col-sm-6">
				<img class="tabimg" src="${pageContext.request.contextPath}/img/mailbox.png" alt="" />邮箱找回
			</div>
			<div class="tabright col-md-6 col-sm-6">
				<img class="tabimg" src="${pageContext.request.contextPath}/img/phone.png" alt="" />手机找回
			</div>
		</div>
		<div class="row tabinner">
			<div class="tabinfo1 col-md-12 col-sm-12">
				<div class="col-md-7 col-sm-10 col-sm-offset-2 tabinfo-container">
					<font id="prompt" class="remind">${getbackError }</font>
					<form action="${pageContext.request.contextPath }/tuser/setPwd" method="post" id="jsform1" class="getbackform">
						<ul>
							<li class="formli"><label for="email">电子邮箱：</label> <input type="text" name="email" id="email" /> <a href="javascript:void(0)"
								id="sendemail">获取验证码</a>
								<div id="mymodel1" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
									<div class="modal-dialog modal-sm" role="document">
										<div class="modal-content">
											<h4 class="warninginfo" id="warning1">请填写注册邮箱</h4>
										</div>
									</div>
								</div></li>
							<li class="formli"><label for="password">请输入新密码：</label> <input type="password" name="password" id="password" /></li>
							<li class="formli"><label for="confirm_password">请确认密码：</label> <input type="password" name="confirm_password"
								id="confirm_password" /></li>
							<li class="formli"><label for="code">验证码：</label> <input type="text" name="code" id="code" /></li>
						</ul>
						<p class="formsubmit">
							<input type="button" value="取消" onclick="isClicked(this)" /> <input class="getbut onactive" type="submit" value="提交" />
						</p>
					</form>
				</div>
			</div>
			<div class="tabinfo2 col-md-12 col-sm-12">
				<div class="col-md-7 col-sm-10 col-sm-offset-2 tabinfo-container">
					<font class="remind"></font>
					<form action="" method="post" id="jsform2" class="getbackform">
						<ul>
							<li class="formli"><label for="telephone">手机号码：</label> <input type="text" name="telephone" id="telephone" /> <a
								href="javascript:void(0)" id="sendphone">获取验证码</a>
								<div id="mymodel2" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
									<div class="modal-dialog modal-sm" role="document">
										<div class="modal-content">
											<h4 class="warninginfo" id="warning2">功能正在开发中...</h4>
										</div>
									</div>
								</div></li>
							<li class="formli"><label for="password">请输入新密码：</label> <input type="password" name="password" id="password" /></li>
							<li class="formli"><label for="confirm_password">请确认密码：</label> <input type="password" name="confirm_password"
								id="confirm_password" /></li>
							<li class="formli"><label for="code">验证码：</label> <input type="text" name="code" id="code" /></li>
						</ul>
						<p class="formsubmit">
							<input type="button" value="取消" onclick="isClicked(this)" /> <input class="getbut onactive" type="submit" value="提交"
								disabled="disabled" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section>
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsp/getback.js"></script>
</html>