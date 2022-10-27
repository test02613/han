package com.aplus.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplus.item.ItemAttrVO;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	MypageDAO dao;

	// 회원정보 가져오기
	@Override
	public MemberVO memberDetail(String id) throws Exception {

		return dao.memberDetail(id);
	}

	// 회원정보 수정
	@Override
	public MemberVO mypageUpdate(MemberVO vo) throws Exception {

		return dao.mypageUpdate(vo);
	}

	// 주문조회
	@Override
	public List<OrderVO> myOrder(String id) throws Exception {

		return dao.myOrder(id);
	}

	// 회원탈퇴
	@Override
	public MemberVO memberLeave(MemberVO vo) throws Exception {

		return dao.memberLeave(vo);
	}

	// 포인트 충전
	@Override
	public MemberVO pointUpdate(MemberVO vo) throws Exception {

		return dao.pointUpdate(vo);
	}
}
