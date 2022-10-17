<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c태그 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
</head>
<body>
	<form id="item_regist_form" method="post">
		<div class="wrap">
			<h3>상품등록정보</h3>

			<div class="boardWrite">
				<table border="1" summary="">

					<tbody>
						<tr>
							<th scope="row">상품명</th>
							<td><input id="itemname" name="itemname"
								class="inputTypeText" value="" type="text" />
						</tr>
						<tr>
							<th scope="row">상품 가격</th>
							<td><input id="itemcost" name="itemcost" type="number" /></td>
						</tr>
						<tr id="category">
							<th>카테고리</th>
							<td><select id="itemcategory" name="itemcategory">
									<option value="" selected="selected">카테고리를 선택 해주세요.</option>
									<option value="11">iMAC</option>
									<option value="12">MacBook Pro</option>
									<option value="13">MacBook Air</option>
									<option value="21">iPad Pro</option>
									<option value="22">iPad Air</option>
									<option value="23">iPad</option>
									<option value="24">iPad mini</option>
									<option value="31">iPhone14</option>
									<option value="32">iPhone13</option>
									<option value="33">iPhoneSE</option>
									<option value="34">iPhone12</option>
									<option value="41">Apple Watch Ultra</option>
									<option value="42">Apple Watch 8</option>
									<option value="43">Apple Watch SE</option>
									<option value="44">Apple Watch Hermes</option>
									<option value="51">AirPods2</option>
									<option value="52">AirPods3</option>
									<option value="53">AirPods Pro2</option>
									<option value="54">AirPods Max</option>
									<option value="61">case</option>
									<option value="62">cable</option>
									<option value="63">MacSafe</option>
									<option value="64">AirTag</option>
							</select></td>
						</tr>
						<tr>
							<th scope="row">수량</th>
							<td><input id="itemstock" name="itemstock" type="number" /></td>
						</tr>
						<tr>
							<th scope="row">썸네일 이미지 업로드</th>
							<td><input type="file" id="itemImgupload"
								style="height: 30px;"></td>
							<td><input type="button" class="itemImg_button" value="등록하기"></td>
						</tr>
						<tr>
							<th scope="row">썸네일 이미지 등록</th>
							<td><input type="text" id="itemImg" style="height: 30px;"></td>
						<tr>
							<th scope="row">상세 이미지 업로드</th>
							<td><input type="file" id="itemDetailImgupload"
								style="height: 30px;"></td>
							<td><input type="button" class="itemDetailImg_button"
								value="등록하기"></td>
						</tr>
												<tr>
							<th scope="row">썸네일 이미지 등록</th>
							<td><input type="text" id="itemImg" style="height: 30px;"></td>
						<tr>
					</tbody>
				</table>
			</div>
			<div class="regist_button_wrap">
				<input type="button" class="regist_button" value="상품 등록하기">
			</div>
		</div>
	</form>
	<script>
		$(document).ready(function() {
			// 상품등록 버튼
				$(".regist_button").click(function() {
				$("#item_regist_form").attr("action", "/itemRegistAction");
				$("#item_regist_form").submit();

			})
		})
 		$(document).ready(function() {
			//이미지 업로드 버튼
			$(".itemImg_button").click(function() {
				$("#itemImg").attr("action", "/imgAction");
				$("#itemImg").submit();

			})
		})
				$(document).ready(function() {
			//이미지 업로드 버튼
			$(".itemDetailImg_button").click(function() {
				$("#itemDetailImg").attr("action", "/detailImgAction");
				$("#itemDetailImg").submit();

			})
		})
		/* 이미지 업로드 */
		$("input[type='file']").on("change", function(e) {

			let formData = new FormData();
			let fileInput = $('input[name="uploadFile"]');
			let fileList = fileInput[0].files;
			let fileObj = fileList[0];

			if (!fileCheck(fileObj.name, fileObj.size)) {
				return false;
			}

			formData.append("uploadFile", fileObj);

			$.ajax({
				url : '/uploadAjaxAction',
				processData : false,
				contentType : false,
				data : formData,
				type : 'POST',
				dataType : 'json',
				success : function(result) {
					console.log(result);
					showUploadImage(result);
				},
				error : function(result) {
					alert("이미지 파일이 아닙니다.");
				}
			});

		});

		/* var, method related with attachFile */
		let regex = new RegExp("(.*?)\.(jpg|png)$");
		let maxSize = 20971520; //20MB	

		function fileCheck(fileName, fileSize) {
			if (fileSize >= maxSize) {
				alert("파일 사이즈 초과");
				return false;
			}

			if (!regex.test(fileName)) {
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
			}

			return true;

		}
	</script>
</body>
</html>