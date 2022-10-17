package com.aplus.model;

import java.sql.Date;

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

	public MemberVO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public MemberVO(String id, String name, String pw, Date birth, String email, String mobile, String postcode,
			String address, String addressDetail, String admin, Date joinDate, String point, String leave) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.birth = birth;
		this.email = email;
		this.mobile = mobile;
		this.postcode = postcode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.admin = admin;
		this.joinDate = joinDate;
		this.point = point;
		this.leave = leave;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", pw=" + pw + ", birth=" + birth + ", email=" + email
				+ ", mobile=" + mobile + ", postcode=" + postcode + ", address=" + address + ", addressDetail="
				+ addressDetail + ", admin=" + admin + ", joinDate=" + joinDate + ", point=" + point + ", leave="
				+ leave + "]";
	}
	
	

}