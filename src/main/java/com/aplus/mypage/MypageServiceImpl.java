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

	@Override
	public MemberVO memberDetail(String id) throws Exception {

		return dao.memberDetail(id);
	}
	
	@Override
	public MemberVO mypageUpdate(MemberVO vo) throws Exception{
		
		return dao.mypageUpdate(vo);
	}
	
	@Override
	public List<OrderVO> myOrder(String id) throws Exception{
		
		return dao.myOrder(id);
	}
	
}
