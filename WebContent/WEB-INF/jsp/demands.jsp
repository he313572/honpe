<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购需求</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/demands.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/online_service.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">您现在的位置：首页</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row groupnav"></div>
		<div class="row">
			<div class="searchcontainer col-md-7 col-sm-7">
				<form action="${pageContext.request.contextPath}/demand/list" method="post" class="searchform">
					<div class="searchbox">
						<input id="page" name="page" type="hidden" value="" /> <input type="search" name="keyword" id="" value="${empty keyword?'':keyword }"
							placeholder="请输入搜索条件" /> <select name="fieldclass">
							<option value="申请单号" selected="">单号</option>
							<option value="特殊事项">描述</option>
							<option value="交货日期">交期</option>
						</select>
					</div>
					<button>
						<img src="${pageContext.request.contextPath}/img/magnifier.png" alt="" />&#160;搜索
					</button>
				</form>
			</div>
			<div class="row">
				<div id="printContent" class="col-md-12 col-sm-12">
					<table class="table table-hover demandtable">
						<caption>采购需求</caption>
						<thead>
							<tr>
								<th>序号</th>
								<th>需求单号</th>
								<th>描述</th>
								<th>要求交期</th>
								<th>需求详情</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageBean.data }" var="demand" varStatus="vs">
								<tr>
									<td>${vs.count }</td>
									<td>${demand.申请单号 }</td>
									<td>${demand.特殊事项 }</td>
									<td>${demand.交货日期}</td>
									<td class="offer"><a href="${pageContext.request.contextPath}/product/list?demandId=${demand.申请单号}">详情</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<c:choose>
				<c:when test="${empty pageBean.data}">
					<div class="nodata row">暂无数据</div>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-md-12 col-sm-12">
							<p class="ppager">
								<c:if test="${pageBean.currentPage>1 }">
									<a class="pre" href="javascript:showPage('${pageBean.currentPage-1 }','${empty keyword?'':keyword}')">上一页</a>
								</c:if>
								<a class="pre" href="javascript:showPage('1','${empty keyword?'':keyword}')">首页</a>
								<c:forEach begin="${pageBean.start}" end="${pageBean.end}" var="num">
									<a class="index ${num==pageBean.currentPage?'current':''}" href="javascript:showPage('${num }','${empty keyword?'':keyword}')">${num}</a>
								</c:forEach>
								<img src="${pageContext.request.contextPath}/img/point.png" alt="" /> <a class="index"
									href="javascript:showPage('${pageBean.totalPage}','${empty keyword?'':keyword}')">尾页</a>
								<c:if test="${pageBean.currentPage<pageBean.totalPage }">
									<a class="next" href="javascript:showPage('${pageBean.currentPage+1 }','${empty keyword?'':keyword}')">下一页</a>
								</c:if>
							</p>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</section>
	<div id="floatTools" class="rides-cs" style="height: 350px">
		<div class="floatL">
			<a id="aFloatTools_Show" class="btnOpen" title="查看在线客服" style="top: 75px; display: block" href="javascript:void(0);">展开</a> <a
				id="aFloatTools_Hide" class="btnCtn" title="关闭在线客服" style="top: 75px; display: none" href="javascript:void(0);">收缩</a>
		</div>
		<div id="divFloatToolsView" class="floatR" style="display: none; height: 350px; width: 140px;">
			<div class="cn">
				<h3 class="titZx">红品模型</h3>
				<ul>
					<c:forEach items="${qqlist}" var="item" varStatus="vs">
						<li><span>采购${vs.count}</span> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${item.qqnum }&site=qq&menu=yes"><img
								border="0" src="${pageContext.request.contextPath}/img/qq.png" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></li>
					</c:forEach>
					<div class="qrcode">
						<img src="${pageContext.request.contextPath}/img/qrcode.png" style="width: 126px; height: 126px" alt="" />
					</div>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var fieldclass = '${fieldclass}';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsp/demands.js"></script>
</html>