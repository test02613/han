<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c태그 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
}

/* 이벤트 타이틀 */
#contents {
	height: 100px;
	color: #24292F;
	font-size: 40px;
	margin-top: 20px;
	text-align: center;
}

/* 게시판 상단 타이틀 */
#title {
	text-align: center;
	align-content: center;
}

/* 목록에 마우스 가져다대면 회색으로 처리함 */
#list:hover {
	background-color: lightgray;
}
/* 게시글번호, 작성일자 가운데정렬 */
#center {
	text-align: center;
}

button {
	text-align: center;
	align-content: left;
}
</style>

</head>
<body>


	<!-- 게시판 부트스트랩 -->
	<div class="wrapper">
		<div id="wrapper">
			<h1>리뷰</h1>
			<table class="table">

				<thead class="table-dark">
					<tr>
						<th id="title" width="100" scope="col">#</th>
						<th id="title" scope="col">제목</th>
						<th id="title" width="100" scope="col">작성일</th>


					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">

						<tr
							onClick="location.href='${path}/reviewDetail?num=${list.reviewnum}'"
							style="cursor: pointer;">
							<td id="title" style="text-decoration: none;"><c:out
									value="${list.reviewnum}" /></td>
							<td><c:out value="${list.reviewtitle}" /></td>
							<td style="text-decoration: none;"><c:out
									value="${list.reviewdate}" /></td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>

		<div id="button">
			<a href="/reviewCreate"><button>글쓰기</button></a>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>