<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通用测试界面</title>
</head>
<body>
<div align="center">
<br/><br/><br/><br/>
属性名：<input type="text" value="" id="textName" />
<input type="button" value="添加输入框" id="textBtn"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
属性名：<input type="text" value="" id="fileName"/>
<input type="button" value="添加文件" id="fileBtn"/>
<hr>
<br/><br/><br/><br/>

<form enctype="multipart/form-data"	action="/"	method="post" id="testForm">
	<div >URL: <input id="urlStr" type="text" name="action" style="width:900px"/> </div><br/>	
	<div id="formdiv"></div>
	
	<input type="submit" value="提交" id="subm"/><br/><br/>
</form>
</div>
<script src="<%= request.getContextPath() %>/static/js/jQuery-core/jquery-1.9.1.min.js"></script>
<script >
	$(function() {
        $("#textBtn").click(function() {
			var textname = $('#textName').val();
			if(textname==""){
				alert("输入框名称不能为空");
				return;
			}
			var txt="<div>"+textname+":<input type='text' value='' id='"+textname+"' name='"+textname+"' style='width:900px'/></div><br/>"; 
            $("#formdiv").append(txt);
            $('#textName').val("");
			$("#"+textname).focus();
        });
		
		$("#fileBtn").click(function() {
			var filename = $('#fileName').val();
			if(filename==""){
				alert("文件属性名称不能为空");
				return;
			}
			var file="<div>"+filename+":<input type='file' value='' id='"+filename+"' name='"+filename+"' style='width:900px'/></div><br/>"; 
            $("#formdiv").append(file);
            $('#fileName').val("");
            $("#"+filename).focus();
        });
        
		$("#subm").click(function() {
			var urlStr = $('#urlStr').val();
			if(urlStr==""){
				alert("url不能为空");
				return;
			}
			$("#testForm").attr("action", "${pageContext.request.contextPath}/"+urlStr);
			$("#testForm").submit();	
        });
		
    });
</script>
</body>
</html>