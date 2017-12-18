<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/current_offer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body>
	<section class="container-fluid">
	<div class="row">
		<div class="offerlist col-md-12 col-sm-12">
			<c:forEach items="${pageBean.data}" var="item">
				<table class="table table-bordered">
					<caption>需求单号：${item.申请单号}</caption>
					<thead>
						<tr>
							<th>报价日期</th>
							<th>交货日期</th>
							<th>报价金额</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${item.报价日期}</td>
							<td>${item.交货日期}</td>
							<td>${item.报价金额}</td>
							<td>进行中</td>
						</tr>
					</tbody>
				</table>
			</c:forEach>
		</div>
	</div>
	<div class="row">
		<c:choose>
			<c:when test="${empty pageBean.data}">
				<div class="nodata row">暂无数据</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col-md-12 col-sm-12">
						<p class="ppager">
							<c:if test="${pageBean.currentPage>1 }">
								<a class="pre" href="${pageContext.request.contextPath}/offer/currentOffer/${pageBean.currentPage-1 }">上一页</a>
							</c:if>
							<a class="pre" href="${pageContext.request.contextPath}/offer/currentOffer/1">首页</a>
							<c:forEach begin="${pageBean.start}" end="${pageBean.end}" var="num">
								<a class="index ${num==pageBean.currentPage?'current':''}" href="${pageContext.request.contextPath}/offer/currentOffer/${num}">${num}</a>
							</c:forEach>
							<img src="${pageContext.request.contextPath}/img/point.png" alt="" /> <a class="index"
								href="${pageContext.request.contextPath}/offer/currentOffer/${pageBean.totalPage}">尾页</a>
							<c:if test="${pageBean.currentPage<pageBean.totalPage }">
								<a class="next" href="${pageContext.request.contextPath}/offer/currentOffer/${pageBean.currentPage+1 }">下一页</a>
							</c:if>
						</p>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	</section>
</body>

<script type="text/javascript">
	
<%--分页按钮点击变色--%>
	$(".index").on("click", function() {
		$(".index").removeClass("current");
		$(this).addClass("current")
	})
</script>

</html>