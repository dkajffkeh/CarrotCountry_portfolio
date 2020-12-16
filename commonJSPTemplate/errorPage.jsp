<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="commonNavbar.jsp" %>

	<br><br><br><br><br>
	<h4 align="center" style="color:orange"><b><%= errorMsg %></b></h4>



</body>
</html>