<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码找回成功</title>
<link rel="shortcut icon" href="../img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="../css/head_location.css" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
</head>
<style type="text/css">
.container-content {
	border: 2px solid #adafb0;
	box-shadow: 0 0 2px #adafb0;
	padding: 50px;
	border-radius: 2px;
	margin: 0;
	margin-top: 50px;
}

.container-content div {
	text-align: center;
}

.container-content p {
	font-size: 18px;
	margin-top: 40px;
}

.inner-right {
	font-size: 30px;
	color: #ff4e00;
	margin-left: 60px;
}

hr {
	border-style: dashed;
	border-color: #adafb0;
}
</style>

<body>
	<%@include file="header.jsp"%>
	<section class="container">
	<div class="row container-content">
		<div class="col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
			<img src="../img/sgou.png" /><span class="inner-right">密码找回成功</span>
			<hr />
			<p>
				<span id='ts'>3</span>秒后跳转到<a href="">登录页面</a>
			</p>
		</div>
	</div>
	</section>
</body>
<script type="text/javascript">
	var ts = document.getElementById('ts');
	var i = 3
	var time = setInterval(function() {
		i--;
		if (i === 0) {
			clearInterval(time);
			location.href = '/honpe';
		}
		ts.innerHTML = i;
	}, 1500)
</script>
</html>