<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">您现在的位置：登录</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row">
			<div class="col-md-7 col-sm-10 col-md-offset-3 col-sm-offset-2 loginform">
				<font class="remind">${loginError }</font>
				<form action="${pageContext.request.contextPath }/tuser/login" method="post">
					<p>
						<label for="username">登录名：</label><span class="space"></span><input type="text" autocomplete="on" name="username" id="username"
							value="" />
					</p>
					<p>
						<label for="password">密<span class="space1"></span>码：
						</label><span class="space"></span><input type="password" name="password" id="password" value="" />
					</p>
					<p>
						<label for="code">验证码：</label><span class="space2"></span> <span class="codeimg"> <input class="codeinput" type="text"
							name="code" id="code" value="" /><img id="codeimg"
							onclick="javascript:document.getElementById('codeimg').src='${pageContext.request.contextPath}/validatecode?'+Math.random()"
							src="${pageContext.request.contextPath}/validatecode" alt="" />
						</span>
					</p>
					<div class="formbottom">
						<div class="middlediv">
							<div onclick="check(this)">
								<input type="checkbox" name="rememberMe" id="rememberMe" value="rememberMe" />
							</div>
							<label for="">下次自动登录</label>
						</div>
						<div class="rightdiv">
							<a href="${pageContext.request.contextPath}/getback">忘记密码?</a>
						</div>
					</div>
					<p class="formsubmit">
						<input class="onactive submitbnt" type="submit" value="登录" /> <input type="button" value="注册" onclick="isClicked(this)" />
					</p>
				</form>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row notice">
			<div class="col-md-4 col-sm-4 noticeinner">
				<p>供应商使用须知</p>
				<ul id="ul1"></ul>
			</div>
			<div class="col-md-4 col-sm-4 noticeinner">
				<p>常见问题</p>
				<ul id="ul2"></ul>
			</div>
			<div class="col-md-4 col-sm-4 noticeinner noticeright">
				<p>相关规章</p>
				<ul id="ul3"></ul>
			</div>
		</div>
	</div>
	</section>
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsp/login.js"></script>
</html>