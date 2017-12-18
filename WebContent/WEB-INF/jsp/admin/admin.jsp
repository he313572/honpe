<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>红品采购后台管理系统</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath }/img/small_logo.png" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/index.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/outOfBounds.js"></script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north',title:'红品采购报价系统后台',split:true" class="northcontainer">
		<img src="${pageContext.request.contextPath }/img/adminbg.png" alt="" />
		<div class="systemtitle">红品采购报价系统后台</div>
		<div id="sessionInfoDiv" class="showuser">
			[<strong>管理员</strong>]，欢迎你！
		</div>
		<div class="control">
			<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
		</div>
		<div id="layout_north_kzmbMenu">
			<div onclick="editPassword();">修改密码</div>
			<div class="menu-sep"></div>
			<div onclick="logout();">退出系统</div>
		</div>
	</div>
	<div class="westcontainer" data-options="region:'west',title:'导航',split:true">
		<div id="navpanel" class="easyui-panel" data-options="fit:true">
			<div title="采购系统" data-options="iconCls:'icon-large-picture',selected:true">
				<ul id="treeMenu" class="ztree"></ul>
			</div>
		</div>
	</div>
	<div class="centercontainer" data-options="region:'center',title:''">
		<div id="centertab" fit="true" class="easyui-tabs"></div>
	</div>
	<div class="southcontainer" data-options="region:'south',border:false">
		<div class="timeshow">
			<i class="iconfont icon-shijian"></i><span id="today"></span>
		</div>
	</div>
	<!--修改密码窗口-->
	<div id="editPwdWindow" class="easyui-window" title="修改密码" collapsible="false" minimizable="false" modal="true" closed="true"
		resizable="false" maximizable="false" icon="icon-save" style="width: 300px; height: 190px; padding: 5px; background: #fafafa">
		<div class="easyui-layout" fit="true">
			<div class="editpwdcenter" region="center" border="false">
				<form id="editPasswordForm">
					<table cellpadding=3>
						<tr>
							<td>原密码：</td>
							<td><input id="password" type="password" class="easyui-validatebox" required="true" /></td>
						</tr>
						<tr>
							<td>新密码：</td>
							<td><input id="newpassword" type="password" class="easyui-validatebox" required="true" validType="noequal['#password']" /></td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td><input id="confirm_password" type="password" class="easyui-validatebox" required="true" validType="equal['#newpassword']" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="editpwdsouth" data-options="region:'south',border:false">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确定</a> <a id="btnCancel" class="easyui-linkbutton"
					icon="icon-cancel" href="javascript:cancelPwd()">取消</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jsp/admin.js"></script>
</html>