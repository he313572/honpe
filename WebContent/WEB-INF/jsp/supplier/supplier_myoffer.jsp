<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的报价</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/demands.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/supplier_offer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<%@include file="../header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">您现在的位置：我的报价</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row groupnav"></div>
		<div class="row">
			<div class="searchcontainer col-md-7 col-sm-7">
				<form action="${pageContext.request.contextPath}/offer/sup_myoffer" method="post" class="searchform">
					<input id="page" type="hidden" name="page" value="${pageBean.currentPage }"> <input id="demandId" type="search" name="demandId"
						value="${demandId}" placeholder="请输入申请单号" />
					<button>
						<img src="${pageContext.request.contextPath}/img/magnifier.png" alt="" />&#160;搜索
					</button>
				</form>
			</div>
			<div class="row">
				<div id="printContent" class="col-md-12 col-sm-12">
					<table class="table table-hover demandtable">
						<caption>当前报价</caption>
						<thead>
							<tr>
								<th>序号</th>
								<th>需求单号</th>
								<th>报价日期</th>
								<th>报价金额</th>
								<th>状态</th>
								<th>报价详情</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageBean.data}" var="item" varStatus="vs">
								<tr>
									<td>${vs.count }</td>
									<td>${item.申请单号 }</td>
									<td>${item.报价日期 }</td>
									<td>${item.报价金额}</td>
									<td><c:choose>
											<c:when test="${item.中标状态 == 0}">
											进行中
										</c:when>
											<c:when test="${item.中标状态 == 1 }">
										中标
										</c:when>
											<c:otherwise>
											未中标
										</c:otherwise>
										</c:choose></td>
									<td class="offer"><a href="${pageContext.request.contextPath}/offer/detail/${item.报价单号}/${item.报价人}/${item.交货日期}">详情</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
		</div>
	</div>
	</section>
</body>

<script type="text/javascript">
	
<%--查询兼分页--%>
	function showPage(page, demandId) {
		$("#page").val(page);
		$("#demandId").val(demandId);
		$(".searchform")[0].submit();
	}
<%--分页按钮点击变色--%>
	$(".index").on("click", function() {
		$(".index").removeClass("current");
		$(this).addClass("current")
	})
</script>

</html>