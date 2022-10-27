<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c태그 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<style>
#wrapper {
	width: 1000px;
	margin: auto;
	margin-top: 30px;
	border-radius: 10px;
}

#title {
	text-align: center;
	align-content: center;
}

td:hover {
	text-decoration: underline;
}

h1 {
	text-align: center;
}

#button {
	text-align: center;
}
</style>
</head>
<body>

	<form id="cart" method="post">
		<!-- 게시판 부트스트랩 -->
		<div class="wrapper">
			<div id="wrapper">
				<h1>장바구니</h1>
				<table class="table">
					<thead class="table-dark">
						<tr>
							<th id="title" width="100">이미지</th>
							<th id="title" scope="col">제품명</th>
							<th id="title" width="100">가격</th>
							<th id="title" width="100">색상,용량</th>
							<th id="title" width="100" scope="col">삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="list">
							<tr>
								<td style="text-decoration: none;"><img
									src="${list.itemimg}" style="width: 100px; height: 100px;" /></td>
								<td id="itemname" style="text-decoration: none;"><c:out
										value="${list.itemname}" /></td>
								<td><c:out value="${list.itemcost}" /></td>
								<td><c:out value="${list.itemattr}" /></td>
								<td style="text-decoration: none;"><a
									href='/cartDeleteAction?code=${list.itemcode}'><button
											type="button">삭제</button></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div>
					<a href="/cartOrderAction"><button>구매하기</button></a>
				</div>
			</div>
		</div>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

</body>
</html>