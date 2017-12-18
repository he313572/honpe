<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑人员信息</title>
<link rel="shortcut icon" href="../img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/head_location.css" />
<link rel="stylesheet" href="../css/editor_person.css" />
<link rel="stylesheet" href="../css/footer.css" />
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
</head>

<body>
	<%@include file="../header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">
						您现在的位置：人员管理<img class="dayu" src="../img/dayu.png" />编辑员工信息
					</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row title">编辑人员信息</div>
		<div class="row">
			<div class="col-md-12 col-sm-12 basebox">
				<div class="basetitle col-md-12 col-sm-12">
					基本信息<span class="dateline"></span>
				</div>
				<div class="baseinfo col-md-7 col-sm-9 col-md-offset-4 col-sm-offset-3">
					<p>
						<label for="">姓名：</label>${tUser.name }
					</p>
					<p>
						<label for="">用户名：</label>${tUser.username }
					</p>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 basebox">
				<div class="basetitle basetitle2 col-md-12 col-sm-12">
					联系方式<span class="dateline"></span>
				</div>
				<form action="${pageContext.request.contextPath }/staff/edit" method="post" id="jsform">
					<input type="hidden" name="id" value="${tUser.id }">
					<div class="baseinfo col-md-7 col-sm-9 col-md-offset-4 col-sm-offset-3">
						<p>
							<label class="label1" for="phone">手机号码：</label><input type="text" value="${tUser.phone }" id="phone" name="phone" />
						</p>
						<p>
							<label class="label1" for="email">电子邮箱：</label><input type="email" value="${tUser.email }" id="email" name="email" />
						</p>
						<p class="basebut">
							<input type="button" onclick="isClicked(this)" value="取消" /> <input class="editbut onactive" type="submit" name="" id="" value="保存" />
						</p>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<%@include file="../footer.jsp"%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jsp/editor_person.js"></script>
</html>