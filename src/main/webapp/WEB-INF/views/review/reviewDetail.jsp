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
	<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

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


	<!-- 게시판 부트스트랩 -->
	<div class="wrapper">
		<div id="wrapper">
			<h1>리뷰</h1>
			<table class="table">

				<thead class="table-dark">
					<tr>
						<th id="title" width="100" scope="col">번호</th>
						<th id="title" scope="col">제목</th>
						<th id="title" width="100" scope="col">작성일</th>


					</tr>
				</thead>
				<tbody>


					<tr>
						<td id="title" style="text-decoration: none;"><c:out
								value="${detail.reviewnum}" /></td>
						<td><c:out value="${detail.reviewtitle}" /></td>
						<td style="text-decoration: none;"><c:out
								value="${detail.reviewdate}" /></td>
					</tr>

					<tr>
						<td><c:out value="${detail.ordernum}"/></td>
						<td colspan="3" height="500" scope="col"><c:out
								value="${detail.reviewcontent}" /></td>



					</tr>

				</tbody>
			</table>
		</div>
		<div id="button">
			<a href='${path}/reviewUpdate?num=${detail.reviewnum}'><button>수정하기</button></a>
			<a class="deletereview" href='${path}/reviewDelete?num=${detail.reviewnum}'><button id="delete_button" >삭제</button></a>
			<a href="/review"><button>목록</button></a>

		</div>
	</div>
	<script>
	 
	var ordernum = ${ordernum}
	$(document).ready(function() {
		// 새글 등록 버튼
		$("#delete_button").click(function() {
			${}
			$.ajax({
				type:"POST",
				url:"/reviewCheckDelete",
				dataType:'json',
				async : false,//전역 변수 보내기
				data:{num : ordernum  },
			       success : function(result) {
			           code = result;

			           console.log("확인 : " + result);
			           if (result) {
			              /* alert("완료"+code); */  
			              return code;
			           } else {
			             /*  alert("전송된 값 없음"+result); */
			           }
			        },
			        error : function() {
			            /* alert("에러 발생"+result); */ 
			        }

			     });//아작스 끝
			})
	})
	
		</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>