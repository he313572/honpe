<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的报价</title>
<link rel="shortcut icon" href="../img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/head_location.css" />
<link rel="stylesheet" href="../css/salesman_myoffer.css" />
<link rel="stylesheet" href="../css/footer.css" />
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>

</head>

<body>
	<%@include file="../header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">
						您现在的位置：我的报价 
					</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row tabs">
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#current" aria-controls="current" role="tab" data-toggle="tab">当前报价</a>
				</li>
				<li role="presentation"><a href="#history" aria-controls="history" role="tab" data-toggle="tab">历史报价</a></li>
			</ul>
			<div class="tab-content">
				<iframe id="current" role="tabpanel" class="tab-pane active col-md-12 col-sm-12"
					src="${pageContext.request.contextPath }/offer/currentOffer/1" scrolling="no" width="" height="590"></iframe>

				<iframe id="history" role="tabpanel" class="tab-pane col-md-12 col-sm-12"
					src="${pageContext.request.contextPath }/offer/historyOffer" scrolling="no" width="" height="640"></iframe>
			</div>
		</div>
	</div>
	</section>
	<%@include file="../footer.jsp"%>
</body>
</html>