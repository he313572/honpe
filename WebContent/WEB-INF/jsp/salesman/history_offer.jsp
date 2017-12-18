<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/history_offer.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/calendar/css/jquery.datepick.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.0.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar/js/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar/js/jquery.datepick-zh-CN.js"></script>
</head>

<body>
	<section class="container-fluid">
	<div class="row">
		<form action="${pageContext.request.contextPath}/offer/historyOffer" method="post" id="offerform">
			<div class="searchebox col-md-12 col-sm-12">
				<input id="page" type="hidden" value="${pageBean.currentPage}" name="page"> 报价日期&#160;&#160;&#160;<input class="date"
					type="text" name="startdate" value="${startdate}" placeholder="年-月-日" readonly="readonly" /><span class="space3"></span><b>—</b><span
					class="space3"></span><input class="date" name="enddate" value="${enddate }" type="text" placeholder="年-月-日" readonly="readonly" />
				<div class="searchinput">
					<input class="demandId" type="search" name="demandId" id="demandId" value="${demandId}" placeholder="输入需求单号" /> <img
						onclick="javascript:document.getElementById('offerform').submit()" class="submit" src="../img/person_search.png" alt="" />
				</div>
			</div>
		</form>
	</div>
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
							<td>${item.中标状态  == 1?"中标":"未中标" }</td>
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
								<a class="pre" href="javascript:showPage('${pageBean.currentPage-1 }','${empty demandId?'':demandId}')">上一页</a>
							</c:if>
							<a class="pre" href="javascript:showPage('1','${empty demandId?'':demandId}')">首页</a>
							<c:forEach begin="${pageBean.start}" end="${pageBean.end}" var="num">
								<a class="index ${num==pageBean.currentPage?'current':''}" href="javascript:showPage('${num }','${empty demandId?'':demandId}')">${num}</a>
							</c:forEach>
							<img src="${pageContext.request.contextPath}/img/point.png" alt="" /> <a class="index"
								href="javascript:showPage('${pageBean.totalPage}','${empty demandId?'':demandId}')">尾页</a>
							<c:if test="${pageBean.currentPage<pageBean.totalPage }">
								<a class="next" href="javascript:showPage('${pageBean.currentPage+1 }','${empty demandId?'':demandId}')">下一页</a>
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
<%--查询兼分页--%>
	function showPage(page, demandId) {
		$("#page").val(page);
		$("#demandId").val(demandId);
		$("#offerform").submit();
	}
	$(function() {
<%--日历初始化格式--%>
	$('.date').datepick({
			dateFormat : 'yy-mm-dd'
		});
	})
</script>
</html>