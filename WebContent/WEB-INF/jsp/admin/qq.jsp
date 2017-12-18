<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QQ管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div id="loading"
		style="position: absolute; z-index: 1000; top: 0px; left: 0px; width: 100%; height: 100%; background: #DDDDDB; text-align: center; padding-top: 20%;">
		<h1>
			<font color="#15428B">加载中....</font>
		</h1>
	</div>
	<table id="qqlist" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'qid',width:'10%',align:'center'">编号</th>
				<th data-options="field:'qqnum',width:'10%',align:'center'">QQ号码</th>
				<th data-options="field:'user',width:'20%',align:'center'">持有人</th>
				<th data-options="field:'cardno',width:'20%',align:'center'">身份证号码</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${qqlist }" var="item">
				<tr>
					<td>${ item.qid}</td>
					<td>${ item.qqnum}</td>
					<td>${ item.user}</td>
					<td>${ item.cardno}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!--编辑采购QQ-->
	<div id="qq_editor" class="easyui-window" title="编辑采购QQ" style="width: 400px; height: 300px;"
		data-options="modal:true,minimizable:false,maximizable:false,collapsible:false,closed:true">
		<div region="north">
			<div class="datagrid-toolbar">
				<a id="btn" href="javascript:editQq()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
			</div>
		</div>
		<div region="center" style="width: 80%; padding-left: 20%; margin-top: 20px;">
			<form id="qqform" method="post" action="${pageContext.request.contextPath }/qq/reviseQq">
				<input type="hidden" name="qid" value="" />
				<div>
					<label for="qqnum">&#160;QQ号码：</label> <input id="qqnum" class="easyui-validatebox" type="text" name="qqnum"
						data-options="validType:'isqq',required:true" />
				</div>
				<br> <br>
				<div>
					<label for="user">&#160;&#160;&#160;持有人：</label> <input id="user" class="easyui-validatebox" type="text" name="user"
						data-options="required:true" />
				</div>
				<br> <br>
				<div>
					<label for="cardno">身份证号：</label> <input id="cardno" class="easyui-validatebox" type="text" name="cardno"
						data-options="validType:'idcardno',required:true" />
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jsp/qq.js"></script>
</html>
