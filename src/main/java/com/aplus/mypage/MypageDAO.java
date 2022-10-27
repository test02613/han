package com.aplus.mypage;

import java.util.List;

import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;

public interface MypageDAO {

	// 회원 정보 가져오기
	public MemberVO memberDetail(String id) throws Exception;

	// 회원정보 수정
	public MemberVO mypageUpdate(MemberVO vo) throws Exception;

	// 주문조회
	public List<OrderVO> myOrder(String id) throws Exception;

	// 회원탈퇴
	public MemberVO memberLeave(MemberVO vo) throws Exception;

	// 포인트 충전
	public MemberVO pointUpdate(MemberVO vo) throws Exception;

}
