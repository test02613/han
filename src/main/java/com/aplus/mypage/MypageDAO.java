package com.aplus.mypage;

import java.util.List;

import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;

public interface MypageDAO {
		
	public MemberVO memberDetail(String id) throws Exception;
	
	public MemberVO mypageUpdate(MemberVO vo) throws Exception;
	
	public List<OrderVO> myOrder(String id) throws Exception;

}
