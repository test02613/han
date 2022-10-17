package com.aplus.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplus.item.ItemAttrVO;
import com.aplus.model.MemberVO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired OrderDAO dao;

	@Override
	public void orderCreate(OrderVO vo) throws Exception {

		dao.orderCreate(vo);
		
	}
	public ItemAttrVO order_item(Integer code) throws Exception{
		return dao.order_item(code);
	}
	
	public MemberVO member(String id) throws Exception{
		return dao.member(id);
	}
	
	public MemberVO pointUpdate(MemberVO vo) throws Exception{
		return dao.pointUpdate(vo);
	}


}
