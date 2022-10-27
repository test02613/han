package com.aplus.cart;

import java.util.List;

public interface CartService {
	// 장바구니 목록
	public List<CartVO> cart(String id) throws Exception;

	// 장바구니 추가
	public void cartInsert(CartVO vo) throws Exception;
	
	//장바구니 삭제
	public CartVO cartDelete(Integer code)throws Exception;
}
