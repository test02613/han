package com.aplus.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartDAO dao;

	// 장바구니 목록
	@Override
	public List<CartVO> cart(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.cart(id);
	}

	// 장바구니 추가
	@Override
	public void cartInsert(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.cartInsert(vo);
	}

	//장바구니 삭제
	public CartVO cartDelete(Integer code)throws Exception{
		return dao.cartDelete(code);
	}

}
