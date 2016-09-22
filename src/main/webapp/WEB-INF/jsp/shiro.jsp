<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shiro标签</title>
</head>
<body>
	<!-- 具有admin角色才会显示标签内的信息 -->
	<shiro:hasRole name="admin">
		<!-- 获取用户信息。默认调用Subject.getPrincipal()获取，即 Primary Principal -->
	    这是admin角色登录：
	    <shiro:principal></shiro:principal>
	</shiro:hasRole>
	<!-- 用户拥有user:create这个权限才会显示标签内的信息 -->
	<shiro:hasPermission name="user:create">
	    有user:create权限信息
	</shiro:hasPermission>
</body>
</html>