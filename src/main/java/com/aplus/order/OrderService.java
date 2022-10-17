package com.aplus.order;

import com.aplus.item.ItemAttrVO;
import com.aplus.model.MemberVO;

public interface OrderService {

	

	public void orderCreate(OrderVO vo) throws Exception;
	
	public ItemAttrVO order_item(Integer code) throws Exception;
	
	public MemberVO member(String id) throws Exception;
	
	public MemberVO pointUpdate(MemberVO vo) throws Exception;
}
