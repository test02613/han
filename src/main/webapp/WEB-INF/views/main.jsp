<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>APLUS MALL</title>
<link rel="stylesheet" href="resources/css/main.css">
<script>
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);

		.nanumgothic * {
		 font-family: 'Nanum Gothic', sans-serif;
		}
</script>
</head>
<body>
<%@ include file="include/header.jsp" %>
<div class="wrapper">???
	<!-- 내용 -->
	<div class="content_area">
		<h1>content area</h1>
	</div>
	<!-- 푸터 -->
	<div class="footer_area">
		<h1>footer area</h1>
	</div>
</div>
</body>
</html>