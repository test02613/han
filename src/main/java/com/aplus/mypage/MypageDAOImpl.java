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
	@Autowired SqlSession sql;

	@Override
	public MemberVO memberDetail(String id) throws Exception {
				
		return sql.selectOne("mapper.Member_SQL.member_detail",id);
	}
	
	@Override
	public MemberVO mypageUpdate(MemberVO vo) throws Exception{
		return sql.selectOne("mapper.Member_SQL.mypage_update",vo);
	}
	
	@Override
	public List<OrderVO> myOrder(String id) throws Exception{
		return sql.selectList("mapper.Mypage_SQL.mypage_order", id);
	}

}
