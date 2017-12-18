<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/update_pwd.css" />
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
					<p class="location">您现在的位置：修改密码</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row title">帐号安全</div>
		<div class="row forminner">
			<div class="col-md-8 col-sm-10 col-md-offset-3 col-sm-offset-2">
				<form action="${pageContext.request.contextPath}/tuser/revisePwd" method="post" id="jsform" class="edpwdform">
					<font class="remind">${reviseError }</font>
					<ul>
						<li class="formli"><label for="password"><img class="stars" src="${pageContext.request.contextPath}/img/stars.png" alt="" />原密码：</label>
							<input type="password" name="password" id="password" /></li>
						<li class="formli"><label for="newpassword"><img class="stars" src="${pageContext.request.contextPath}/img/stars.png"
								alt="" />新密码：</label> <input type="password" name="newpassword" id="newpassword" /></li>
						<li class="formli"><label for="confirm_password"><img class="stars"
								src="${pageContext.request.contextPath}/img/stars.png" alt="" />请确认密码：</label> <input type="password" name="confirm_password"
							id="confirm_password" /></li>
					</ul>
					<p class="formbut">
						<input type="button" onclick="isClicked(this)" value="取消" /> <input class="pwdbut onactive" type="submit" value="确认" />
					</p>
				</form>
			</div>
		</div>
	</div>
	</section>
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsp/update_pwd.js"></script>
</html>