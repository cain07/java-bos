<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>


<title>Insert title here</title>
</head>
<body>
	<!-- 普通的 -->
	<table>
		<thead>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>001</td>
				<td>sss</td>
				<td>22</td>
			</tr>
		</tbody>
	</table>
	<!-- easyui-datagrid的 -->
	<table class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'id'">编号</th>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'age'">年龄</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>001</td>
				<td>sss</td>
				<td>22</td>
			</tr>
		</tbody>
	</table>


	<!-- easyui-datagrid json ajax的 -->
	<table
		data-options="url:'${pageContext.request.contextPath }/json/datagrid.json'"
		class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'id'">编号</th>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'age'">年龄</th>
			</tr>
		</thead>

	</table>

	<table id="easyui_table">

	</table>


</body>
<script type="text/javascript">
	$(function() {
		$("#easyui_table").datagrid({
			//定义标题行所有的列
			columns : [ [ {
				title : '编号',
				field : 'id',
				checkbox : true
			}, {
				title : '姓名',
				field : 'name'
			}, {
				title : '年龄',
				field : 'age'
			}, {
				title : '地址',
				field : 'address'
			} ] ],
			//指定数据表格发送ajax请求的地址
			url : '${pageContext.request.contextPath }/json/datagrid.json',
			rownumbers : true,
			singleSelect : true,
			//定义工具栏
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				//为按钮绑定单击事件
				handler : function() {
					alert('add...');
				}
			}, {
				text : '删除',
				iconCls : 'icon-remove'
			}, {
				text : '修改',
				iconCls : 'icon-edit'
			}, {
				text : '查询',
				iconCls : 'icon-search'
			} ],
			//显示分页条
			pagination : true

		})

	})
</script>

</html>