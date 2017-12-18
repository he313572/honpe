<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>需求报价</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/easydialog.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/calendar/css/jquery.datepick.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.lightbox.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easydialog.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar/js/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar/js/jquery.datepick-zh-CN.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">
						您现在的位置：首页<img class="dayu" src="${pageContext.request.contextPath}/img/dayu.png" />需求报价
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
				<p>采购单号：${demand.申请单号 }</p>
				<p>要求交期：${demand.交货日期 }</p>
				<p>
					附件下载：
					<c:choose>
						<c:when test="${empty attachments}">
						无附件
						</c:when>
						<c:otherwise>
							<c:forEach items="${attachments}" var="attachment">
								<a href="${attachment.存放位置}">${attachment.文件名称}</a>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</p>
				<p>
				<div class="destitle">
					描 <span class="space4"> </span>述：
				</div>
				<div class="desinfo">${demand.特殊事项 }</div>
				</p>
			</div>
		</div>
	</div>

	<div class="container offercontainer">
		<div class="row offerform">
			<p>表格填写格式：税率保留两位小数如0.05,单价首位不得为零最多保留一位小数如300或300.0</p>
			<table class="table offertable table-hover">
				<caption>
					需求详情
					<c:if test="${!empty historyOffers}">
						<button id="offersave" onclick="historyOffer()">历史报价</button>
					</c:if>
					<button id="offersave" onclick="saveOffer()">保存报价</button>
					<button id="offersubmit" onclick="submitOffer()">报价</button>
				</caption>
				<thead>
					<tr>
						<th>物品名称</th>
						<th>物品图片</th>
						<th>规格</th>
						<th>材质</th>
						<th>数量</th>
						<th>后处理要求</th>
						<th>备注</th>
						<th>交货日期</th>
						<th>税率</th>
						<th>单价</th>
						<th>总价</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productExts }" var="productExt">
						<tr>
							<input type="hidden" value="${productExt.数量}">
							<input class="pid" type="hidden" name="pid" value="${productExt.零件编码 }">
							<td>${productExt.物品名称}</td>
							<td class="pictd"><a href="${productExt.存放位置 }" rel="lightbox" title="3D图纸"> <img src="${productExt.存放位置 }" alt="" />
							</a></td>
							<td>${productExt.规格}</td>
							<td>${productExt.材质}</td>
							<td><span class="number">${productExt.数量}</span>${productExt.单位}</td>
							<td>${productExt.后处理要求 }</td>
							<td>${productExt.采购备注}</td>
							<td class="pricetd"><input class="inpu date" name="date" type="search"
								value="<fmt:formatDate value="${productExt.offer.offertime}" pattern="yyyy-MM-dd" />" placeholder="年-月-日" readonly="readonly" /></td>
							<td class="pricetd"><input class="inp taxrate" name="taxrate" type="text" value="${productExt.offer.taxrate }" /></td>
							<td class="pricetd"><input class="inp price" name="price" type="text" value="${productExt.offer.price }" /></td>
							<td class="tpprice"><fmt:formatNumber value="${(productExt.offer.taxrate+1)*productExt.offer.price*productExt.数量 }"
									pattern="0.0" maxFractionDigits="1" /></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="popup">
		<span id="close"> × </span>
		<div class="container">
			<table class="table table-bordered">
				<caption>
					<font>历史驳回报价 </font>
				</caption>
				<thead>
					<tr class="demandhead">
						<th>需求单号</th>
						<th>描述</th>
						<th>要求交期</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${demand.申请单号 }</td>
						<td>${demand.特殊事项 }</td>
						<td>${demand.交货日期}</td>
					</tr>
				</tbody>
			</table>
			<c:forEach items="${historyOffers }" var="historyOffer">
				<table class="table table-bordered table-hover">
					<caption>
						<span>驳回原因：${historyOffer.驳回原因}</span> <span class="rebut">驳回时间：${historyOffer.驳回日期}</span>
					</caption>
					<thead>
						<tr>
							<th>物品名称</th>
							<th>物品图片</th>
							<th>规格</th>
							<th>材质</th>
							<th>数量</th>
							<th>交货日期</th>
							<th>税率</th>
							<th>单价</th>
							<th>总价</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${historyOffer.报价明细}" var="item">
							<tr>
								<td>${item.物品名称 }</td>
								<td class="pictd"><a href="${item.存放位置}" rel="lightbox" title="3d图纸"> <img src="${item.存放位置}" alt="" />
								</a></td>
								<td>${item.规格}</td>
								<td>${item.材质}</td>
								<td>${item.数量}</td>
								<td>${item.交货日期}</td>
								<td>${item.税率}</td>
								<td>${item.报价单价}</td>
								<td><fmt:formatNumber value="${(item.税率+1)*item.报价单价*item.数量}" pattern="0.0" maxFractionDigits="1" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:forEach>
		</div>
	</div>
	</section>
</body>
<script type="text/javascript">
	var demandNum = '${demand.申请单号 }';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsp/products.js"></script>
</html>