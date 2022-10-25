<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>Basic Bootstrap Table</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>주문 정보 조회</h2>
		<table class="table" style="font-size: 12px;">
			<thead>
				<tr>
					<th>주문번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>주문 날짜</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>상세주소</th>
					<th>전화번호</th>
					<th>상품</th>
					<th></th>
					<th>리뷰작성</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${order}" var="order">
					<tr>
						<td>${order.ordernum}</td>
						<td>${order.name}</td>
						<td>${order.ordercost}</td>
						<td>${order.orderdate}</td>
						<td>${order.postcode}</td>
						<td>${order.address}</td>
						<td>${order.addressdetail}</td>
						<td>${order.mobile}</td>
						<td>${order.itemattrvo.itemname }</td>
						<td><img src="${order.itemvo.itemimg }"
							style="width: 100px; height: 100px;"></td>
						<td>
						<c:if test="${order.review == null}">
								<div id="button">
									<a href="${path}/reviewCreate?ordernum=${order.ordernum}&itemnum=${order.itemattrvo.itemnum}"><button>리뷰쓰기</button></a>
								</div>
						</c:if>
						<c:if test="${order.review eq 1 }">
								<div id="button">
									<button style="color:gray;">리뷰완료</button>
								</div>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>