<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户须知</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/notice.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">您现在的位置：用户须知</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row">
			<nav class="naticenav hidden-sm">
			<p class="title1">供应商使用须知</p>
			<ul>
				<c:forEach items="${group1 }" var="item">
					<li value="${item.cid }" onclick="goPage('${item.cid}',this)"><span></span><font>${item.contentname}</font></li>
				</c:forEach>
			</ul>
			<p class="title2">常见问题</p>
			<ul>
				<c:forEach items="${group2 }" var="item">
					<li value="${item.cid }" onclick="goPage('${item.cid}',this)"><span></span><font>${item.contentname}</font></li>
				</c:forEach>
			</ul>
			<p class="title3">相关规章</p>
			<ul>
				<c:forEach items="${group3 }" var="item">
					<li value="${item.cid }" onclick="goPage('${item.cid}',this)"><span></span><font>${item.contentname}</font></li>
				</c:forEach>
			</ul>
			</nav>
			<iframe id="iframe" class="content" onload="iframeLoad(this)" src="${pageContext.request.contextPath }/content/preview/${cid}"
				scrolling="no" width="" height=""></iframe>
		</div>
	</div>
	</section>
</body>
<script type="text/javascript">
	var cid = '${cid}';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jsp/natice.js"></script>
</html>