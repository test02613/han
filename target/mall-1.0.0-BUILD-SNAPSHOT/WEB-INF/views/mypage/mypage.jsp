<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
</head>
<body>

	<div id="member_info_wrap" >
	
		<table>

			<tr>
				<td>id:${member.id}</td>
				
				<td>name:${member.name}</td>
				
				<td>mobile:${member.mobile }</td>
				
				<td>email:${member.email }</td>

				<td>point:${member.point}</td>
				
				

			</tr>

		</table>
	</div>
	<h1>
		<a href="/myupdate">정보수정</a>
	</h1>
	<h1>
		<a href="/myorder">주문정보</a>
	</h1>
	<h1>
		<a href="/mypoint">포인트</a>
	</h1>
	<h1>
		<a href="/review">리뷰</a>
	</h1>
	<h1>
		<a href="/cart">장바구니</a>
	</h1>
	<h1>
		<a href="/myqna">1대1문의</a>
	</h1>
</body>
</html>