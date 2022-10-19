<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myUpdate</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
   crossorigin="anonymous"></script>
<!-- <link rel="stylesheet" href="/resources/css/join.css"> -->


</head>
<body>
	<form id="update_form" method="post">
		<div class="wrap">
			<div class="subjecet">
				<span>회원정보 수정</span>
			</div>
			<div class="id_wrap">
				<div class="id_name">아이디</div>
				<div class="id_input_box">
					<input class="id_input" name="id" value="${member.id}" readonly>
				</div>

			</div>

			<div class="pw_wrap">
				<div class="pw_name">비밀번호</div>
				<input type="password" id="pw" name="pw" placeholder="비밀번호" />
			</div>
		</div>
		<div class="pwck_wrap">
			<div class="pwck_name">비밀번호 확인</div>
			<input type="password" id="pwcheck" placeholder="비밀번호 확인" />
			<div>
				<font id="chkNotice" size="2"></font>
			</div>
		</div>

		<div class="user_wrap">
			<div class="user_name">이름</div>
			<div class="user_input_box">
				<input class="user_input" name="name" value="${member.name }">
			</div>
		</div>
		<div class="mail_check_wrap">
			<div class="mail_name">이메일</div>
			<div class="mail_input_box">
				<input class="mail_input" name="email" value="${member.email }">
			</div>
<!--  			<div class="mail_check_wrap">
				<div class="mail_check_input_box" id="mail_check_input_box_false">
					<input class="mail_check_input" disabled="disabled">
				</div>
				<div class="mail_check_button">
					<span>인증번호 전송</span>
				</div> 
				<div class="clearfix"></div>
				<span id="mail_check_input_box_warn"></span>
			</div> -->
		</div>
		<div class="address_wrap">
			<div class="address_name">주소</div>
			<div class="address_input_1_wrap">
				<div class="address_input_1_box">
					<input class="address_input_1" name="postcode" readonly="readonly" value="${member.postcode}">
				</div>
<!-- 				<div class="address_button" onclick="execution_daum_address()">
					<span>주소 찾기</span>
				</div>
 -->				<div class="clearfix"></div>
			</div>
			<div class="address_input_2_wrap">
				<div class="address_input_2_box">
					<input class="address_input_2" name="address" readonly="readonly" value="${member.address}">
				</div>
			</div>
			<div class="address_input_3_wrap">
				<div class="address_input_3_box">
					<input class="address_input_3" name="addressDetail"
						readonly="readonly" value="${member.addressDetail}">
				</div>
			</div>
		</div>
		<div class="update_button_wrap">
			<input type="button" class="update_button" value="회원정보 수정">
		</div>
	</form>
   <script
      src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
      $(document).ready(function() {
         // 회원가입 버튼
         $(".update_button").click(function() {
            $("#update_form").attr("action", "/myupdateAction");
            $("#update_form").submit();

         })
      })
      
      /* 비밀번호 일치 여부 */
      $(function() {
         $('#pw').keyup(function() {
            $('#chkNotice').html('');
         });

         $('#pwcheck').keyup(function() {

            if ($('#pw').val() != $('#pwcheck').val()) {
               $('#chkNotice').html('비밀번호 일치하지 않음<br><br>');
               $('#chkNotice').attr('color', 'red');
            } else {
               $('#chkNotice').html('비밀번호 일치함<br><br>');
               $('#chkNotice').attr('color', 'green');
            }

         });
      });
   </script>
</body>
</html>