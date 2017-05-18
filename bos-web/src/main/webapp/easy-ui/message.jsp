<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		 $.messager.alert("ddd","ddds","question");
		 
		 $.messager.confirm("标题","ssss",function(r){
			 alert(r);
		 });
		 
		 $.messager.show({
			 title:'huanyi',
			 msg:'sssssss',
			 timeout:500,
			 showType:'slide'
		 })
	});
	

</script>

<title>Insert title here</title>
</head>
</html>