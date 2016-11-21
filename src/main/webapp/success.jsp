<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!-- 
	现引入shiro的标签
	

 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Page</title>
</head>
<body>
	<h4>Success Page</h4>
	welcome:
	
	<br>
	<a href="logout">Logout</a>
	<br>

	<a href="testAnnotation">Test Annotation</a>
	<br>
<%-- 
	<shiro:hasAnyRoles name="user">
		<a href="user.jsp">User Page</a>
		<br>
	</shiro:hasAnyRoles>


	<shiro:hasAnyRoles name="admin">
		<a href="admin.jsp">Admin Page</a>
	</shiro:hasAnyRoles> --%>



</body>
</html>