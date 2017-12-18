<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册业务员</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath }/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/add_salesman.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/footer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
</head>

<body>
	<%@include file="../header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">
						您现在的位置：人员管理<img class="dayu" src="${pageContext.request.contextPath }/img/dayu.png" />注册员工
					</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row title">注册员工</div>
		<div class="row">
			<div class="col-md-7 col-sm-8 col-md-offset-3 col-sm-offset-2 registerform">
				<form action="${pageContext.request.contextPath }/staff/add" method="post" id="jsform">
					<ul>
						<font class="remind">${addError }<font>
								<li class="formli"><label for="name"><img class="stars" src="../img/stars.png" />姓名：</label> <input type="text" name="name"
									id="name" /></li>
								<li class="formli"><label for="username"><img class="stars" src="../img/stars.png" />用户名：</label> <input type="text"
									name="username" id="username" /></li>
								<li class="formli"><label for="password"><img class="stars" src="../img/stars.png" />密码：</label> <input type="password"
									name="password" id="password" /></li>
								<li class="formli"><label for="confirm_password"><img class="stars" src="../img/stars.png" />确认密码：</label> <input
									type="password" name="confirm_password" id="confirm_password" /></li>
								<li class="formli"><label for="email"><img class="stars" src="../img/stars.png" />邮箱：</label> <input type="text" name="email"
									required="true" id="email" /></li>
								<li class="formli"><label for="phone"><img class="stars" src="../img/stars.png" />手机：</label> <input type="text" name="phone"
									id="phone" /></li>
					</ul>
					<p class="formsubmit">
						<input type="button" value="取消" onclick="isClicked(this)" /> <input class="addbut onactive" type="submit" value="注册" />
					</p>
			</div>
			</form>
		</div>
	</div>
	</div>
	</section>
	<%@include file="../footer.jsp"%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jsp/add_salesman.js"></script>
</html>