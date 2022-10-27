package com.aplus.mypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.item.ItemAttrVO;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;

@Repository
public class MypageDAOImpl implements MypageDAO {
	@Autowired
	SqlSession sql;

	// 회원정보 가져오기
	@Override
	public MemberVO memberDetail(String id) throws Exception {

		return sql.selectOne("mapper.Member_SQL.member_detail", id);
	}

	// 회원정보 수정
	@Override
	public MemberVO mypageUpdate(MemberVO vo) throws Exception {
		return sql.selectOne("mapper.Member_SQL.mypage_update", vo);
	}

	// 주문조회
	@Override
	public List<OrderVO> myOrder(String id) throws Exception {
		return sql.selectList("mapper.Mypage_SQL.mypage_order", id);
	}

	// 회원탈퇴
	@Override
	public MemberVO memberLeave(MemberVO vo) throws Exception {

		return sql.selectOne("mapper.Member_SQL.member_bye", vo);
	}

	// 포인트 충전
	@Override
	public MemberVO pointUpdate(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Member_SQL.mypoint_update", vo);
	}

}
