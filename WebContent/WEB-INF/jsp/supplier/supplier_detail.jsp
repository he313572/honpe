<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报价详情</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lightbox-jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.lightbox.min.js"></script>
</head>

<body>
	<%@include file="../header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">
						您现在的位置：我的报价<img class="dayu" src="${pageContext.request.contextPath}/img/dayu.png" />详情 
					</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row groupnav"></div>
		<div class="row">
			<div class="demandinfo col-md-12 col-sm-12">
				<p>采购单号：${offerDetailExts[0].申请单号 }</p>
				<p>
					附件下载：
					<c:choose>
						<c:when test="${empty attachments }">
						无附件
					</c:when>
						<c:otherwise>
							<c:forEach items="${attachments }" var="attachment">
								<a href="${attachment.存放位置 }">${attachment.文件名称}</a>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
	</div>

	<div class="container offercontainer">
		<form action="" method="post">
			<div class="row offerform">
				<table class="table table-hover offertable">
					<caption>报价详情</caption>
					<thead>
						<tr>
							<th>序号</th>
							<th>物品名称</th>
							<th>物品图片</th>
							<th>规格</th>
							<th>材质</th>
							<th>数量</th>
							<th>交货日期</th>
							<th>后处理要求</th>
							<th>备注</th>
							<th>报价人</th>
							<th>税率</th>
							<th>报价金额</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${offerDetailExts}" var="item" varStatus="vs">
							<tr>
								<td>${vs.count}</td>
								<td>${item.物品名称 }</td>
								<td class="pictd"><a href="${item.存放位置 }" rel="lightbox" title="3d图纸"> <img src="${item.存放位置 }" alt="" />
								</a></td>
								<td>${item.规格 }</td>
								<td>${item.材质 }</td>
								<td>${item.数量 }</td>
								<th>${item.交货日期 }</th>
								<td>${item.后处理要求 }</td>
								<td>${item.备注}</td>
								<td>${offerName }</td>
								<td>${item.税率 }</td>
								<td>${item.报价单价 }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
	</div>
	</section>
</body>
</html>