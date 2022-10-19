package com.aplus.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	// 회원 ID
	private String id;

	// 회원 이름
	private String name;

	// 회원 비밀번호
	private String pw;

	// 회원 생년월일
	private Date birth;

	// 회원 이메일
	private String email;

	// 회원 핸드폰번호
	private String mobile;

	// 회원 우편번호
	private String postcode;

	// 회원 주소
	private String address;

	// 회원 상세주소
	private String addressDetail;

	// 관리자 구분
	private String admin;

	// 등록일자
	private Date joinDate;

	// 회원 포인트
	private String point;

	// 회원 탈퇴
	private String leave;

}