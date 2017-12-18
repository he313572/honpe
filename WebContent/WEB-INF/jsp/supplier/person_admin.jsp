<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员管理</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/easydialog.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_location.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/person_admin.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easydialog.min.js"></script>
</head>

<body>
	<%@include file="../header.jsp"%>
	<div class="container-fluid locationbox">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 locationdiv">
					<p class="location">您现在的位置：人员管理</p>
				</div>
			</div>
		</div>
	</div>
	<section class="container-fluid">
	<div class="container sectioninner">
		<div class="row title">人员管理</div>
		<div class="row functionbox">
			<div class="row funtionboxinner">
				<div class="col-md-12 col-sm-12 functionbut">
					<div class="col-md-6 col-sm-6">
						<a href="${pageContext.request.contextPath}/supplier/add_salesman"><img src="../img/person_add.png" />增加</a> <a
							href="javascript:batchDel()"><img src="../img/person_cha.png" />删除</a>
						<div id="mymodel" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-sm" role="document">
								<div class="modal-content">
									<h4 class="warninginfo" id="warning">请选择要删除的行</h4>
								</div>
							</div>
						</div>
					</div>
					<form action="${pageContext.request.contextPath}/staff/list" method="get" id="stafffrom">
						<div class="col-md-6 col-sm-6">
							<div class="searchinput">
								<input id="currentPage" type="hidden" name="currentPage" /> <input id="name" type="search" name="name" value="${name }"
									placeholder="请输入业务员姓名" /> <img onclick="javascript:document.getElementById('stafffrom').submit()" class="submit"
									src="../img/person_search.png" alt="" />
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-12 col-sm-12">
					<table class="table table-hover persontable">
						<thead>
							<tr>
								<th><input type="checkbox" class="allcheck" />序号</th>
								<th>姓名</th>
								<th>用户名</th>
								<th>手机号码</th>
								<th>电子邮箱</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageBean.data }" var="item" varStatus="vs">
								<tr>
									<td><input type="checkbox" value="${item.id }" />${vs.count }</td>
									<td>${item.name }</td>
									<td>${item.username }</td>
									<td>${item.phone }</td>
									<td>${item.email }</td>
									<td><a href="javascript:deleteOne('${item.id}')"><img src="../img/person_cha.png" alt="" /></a> <a
										href="${pageContext.request.contextPath}/staff/goEdit?id=${item.id}"><img src="../img/person_writer.png" /></a></td>
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
									<a class="pre" href="javascript:showPage('${pageBean.currentPage-1 }','${empty name?'':name}')">上一页</a>
								</c:if>
								<a class="pre" href="javascript:showPage('1','${empty name?'':name}')">首页</a>
								<c:forEach begin="${pageBean.start}" end="${pageBean.end}" var="num">
									<a class="index ${num==pageBean.currentPage?'current':''}" href="javascript:showPage('${num }','${empty name?'':name}')">${num}</a>
								</c:forEach>
								<img src="${pageContext.request.contextPath}/img/point.png" alt="" /> <a class="index"
									href="javascript:showPage('${pageBean.totalPage}','${empty name?'':name}')">尾页</a>
								<c:if test="${pageBean.currentPage<pageBean.totalPage }">
									<a class="next" href="javascript:showPage('${pageBean.currentPage+1 }','${empty name?'':name}')">下一页</a>
								</c:if>
							</p>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</section>
	<%@include file="../footer.jsp"%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsp/person_admin.js"></script>
</html>