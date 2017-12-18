<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内容管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/kindeditor-4.1.10/themes/default/default.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<style type="text/css">
.ke-container {
	display: inline-block;
	vertical-align: top;
}
</style>
<body>
	<div id="loading"
		style="position: absolute; z-index: 1000; top: 0px; left: 0px; width: 100%; height: 100%; background: #DDDDDB; text-align: center; padding-top: 20%;">
		<h1>
			<font color="#15428B">加载中....</font>
		</h1>
	</div>
	<table id="contentlist" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'cid',width:'5%',align:'center'">编号</th>
				<th data-options="field:'name',width:'25%',align:'center'">名称</th>
				<th data-options="field:'title',width:'25%',align:'center'">标题</th>
				<th data-options="field:'preview',width:'10%',align:'center'">内容预览</th>
				<th data-options="field:'caid',width:'10%',align:'center'">类别编号</th>
				<th data-options="field:'category',width:'25%',align:'center'">类别</th>
				<th data-options="field:'content',hidden:'true'"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contentList }" var="item">
				<tr>
					<td>${item.cid}</td>
					<td>${item.contentname}</td>
					<td>${item.contenttitle}</td>
					<td><a id="preview" href="javascript:preview('${item.cid }')" class="easyui-linkbutton" data-options="iconCls:'icon-search'">效果预览</a></td>
					<td>${item.caid}</td>
					<td>${item.categoryname}</td>
					<td>${item.content}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<!--添加内容-->
	<div id="addWindow" class="easyui-window" title="编辑内容" style="width: 80%; height: 85%;"
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false,closed:true">
		<div region="north">
			<div class="datagrid-toolbar">
				<a href="javascript:submitAdd()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
			</div>
		</div>
		<div region="center" style="width: 80%; padding: 20px 0 20px 15%;">
			<form id="addform" method="post" action="${pageContext.request.contextPath }/content/add">
				<div>
					<label for="">内容标题：</label> <input id="contenttitle" class="easyui-validatebox" type="text" name="contenttitle"
						data-options="required:true" />
				</div>
				<br>
				<div>
					<label for="">内容名称：</label> <input class="easyui-validatebox" type="text" name="contentname" data-options="required:true" />
				</div>
				<br>
				<div>
					<label for="">内容类别：</label> <input class="easyui-combobox" name="caid" style="width: 175px;"
						data-options="valueField:'caid',textField:'categoryname',url:'${pageContext.request.contextPath }/category/list'" />
				</div>
				<br>
				<div>
					<label for="">编辑内容：</label>
					<textarea id="addcontent" name="content" rows="" cols="" style="width: 80%; height: 400px; visibility: hidden;"></textarea>
				</div>
			</form>
		</div>
	</div>
	<!--编辑内容-->
	<div id="editWindow" class="easyui-window" title="编辑内容" style="width: 80%; height: 85%;"
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false,closed:true">
		<div region="north">
			<div class="datagrid-toolbar">
				<a href="javascript:submitEdit()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a>
			</div>
		</div>
		<div region="center" style="width: 80%; padding: 20px 0 20px 15%;">
			<form id="editform" method="post" action="${pageContext.request.contextPath }/content/edit">
				<input type="hidden" name="cid" value="" />
				<div>
					<label for="">内容标题：</label> <input class="easyui-validatebox" type="text" name="contenttitle" data-options="required:true" />
				</div>
				<br>
				<div>
					<label for="">内容名称：</label> <input class="easyui-validatebox" type="text" name="contentname" data-options="required:true" />
				</div>
				<br>
				<div>
					<label for="">内容类别：</label> <input class="easyui-combobox" name="caid" style="width: 175px;"
						data-options="valueField:'caid',textField:'categoryname',url:'${pageContext.request.contextPath }/category/list'" />
				</div>
				<br>
				<div>
					<label>编辑内容：</label>
					<textarea id="editcontent" name="content" rows="" cols="" style="width: 80%; height: 400px; visibility: hidden;"></textarea>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jsp/content.js"></script>
</html>