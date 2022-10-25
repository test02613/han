<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c태그 사용 -->


<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<title>새글등록</title>
</head>
<body>


	<center>
		<h1>${detail.reviewnum }</h1>
		<a href="/logout">Log-out</a>
		<hr>
		<form id="reviewCreate_form" method="post">
			<table border="1" cellpadding="0" cellspacing="0">

				<c:if test="${detail.reviewnum == null}">
					<tr>

						<td bgcolor="orange" width="70">제목</td>
						<td align="left"><input type="text" name="reviewtitle" /></td>
					</tr>
					<tr>
						<td bgcolor="orange">내용</td>
						<td align="left"><textarea name="reviewcontent" cols="40"
								rows="10"></textarea></td>
					</tr>
					<input type="hidden" name="ordernum" id="ordernum" value="${ordernum}">
					<input type="hidden" name="itemnum"	id="itemnum" value="${itemnum}">
				</c:if>
				<c:if test="${detail.reviewnum != null}">
					<tr>
						<td bgcolor="orange" width="70">제목</td>
						<td align="left"><input id="titlewrite" type="text" name="reviewtitle"
							value="${detail.reviewtitle}" /></td>
					</tr>
					<tr>
						<td bgcolor="orange">내용</td>
						<td align="left"><textarea name="reviewcontent" cols="40"
								rows="10">${detail.reviewcontent}</textarea></td>


					</tr>
				</c:if>
			</table>
			<c:if test="${detail.reviewnum == null}">
				<input type="button" class="reviewCreate_button" value="등록하기">
			</c:if>
			<c:if test="${detail.reviewnum != null}">
				<input type="button" class="reviewUpdate_button" value="수정하기">
			</c:if>
		</form>
		<hr>
		<a href="/review">글 목록 가기</a>
	</center>

	<script>
	 
	 /* var ordernum = document.getElementById("ordernum").value */
	 var ordernum = ${ordernum}
		$(document).ready(function() {
			// 새글 등록 버튼
			$(".reviewCreate_button").click(function() {
				$("#reviewCreate_form").attr("action", "/reviewCreateAction");
				/* var ordernum=${ordernum}; */
				
				$.ajax({
					type:"POST",
					url:"/reviewCheck",
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
				$("#reviewCreate_form").submit();

			})
		})

		$(document)
				.ready(
						function() {
							// 글 수정 버튼
							$(".reviewUpdate_button")
									.click(
											function() {
												$("#reviewCreate_form")
														.attr("action",
																'${path}/reviewUpdateAction?num=${detail.reviewnum}');
												$("#reviewCreate_form")
														.submit();

											})
						})
	</script>
</body>
</html>