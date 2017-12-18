<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="container-fluid head">
	<div class="container headconteriner">
		<div class="row">

			<div class="headleft col-md-7 col-sm-7">
				<img class="headlogo" src="${pageContext.request.contextPath}/img/logo.png" alt="" /><span class="headtitle">红品供应商报价系统</span> <span
					class="vertical hidden-sm"></span> <span class="righttitle hidden-sm">开发路上<span class="space"></span>红品知己
				</span>
			</div>
			<div class="headright col-md-5 col-sm-5">
				<div class="topbox">
					<c:if test="${!empty user}">
						<div class="navtitle">
							<font class="navhover">我的导航</font><img src="${pageContext.request.contextPath}/img/xiala0.png" alt="" />
							<div class="usernav">
								<ul>
									<c:forEach items="${userMenu}" var="item">
										<li><a target="_self" href="${pageContext.request.contextPath}${item.page}">${item.name} </a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</c:if>
					<div class="headtop">
						您好，
						<c:choose>
							<c:when test="${empty user}">
								请 <a target="_self" href="${pageContext.request.contextPath}/login">登录</a>
							</c:when>
							<c:otherwise>
								<a target="_self" href="${pageContext.request.contextPath}/login">${user.username}</a>
							</c:otherwise>
						</c:choose>
						<i></i>|<i></i> <a target="_self" href="${pageContext.request.contextPath}/register">注册</a> </span>
					</div>
				</div>
				<nav class="navcontainer">
					<a target="_self" href="http://www.honpe.com">官网首页</a> <a target="_self" href="${pageContext.request.contextPath}/demand/list">系统首页</a>
					<a target="_self" href="${pageContext.request.contextPath}/tuser/signOut">退出系统</a>
				</nav>
			</div>
		</div>
	</div>
</header>
<script type="text/javascript">
<%--更换导航栏背景--%>
	window.onload = function() {
		var length = 0;
		if ('${!empty userMenu}') {
			length = '${userMenu.size()}'
			if (length == 2) {
				var usernav = document.querySelector(".usernav");
				usernav.style.backgroundImage = "url(${pageContext.request.contextPath}/img/navbg1.png)"
				usernav.style.backgroundSize = "100% 100%"
			}
		}
	}
</script>
