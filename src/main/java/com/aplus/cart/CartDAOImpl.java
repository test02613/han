package com.aplus.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO {
	@Autowired
	SqlSession sql;

	// 장바구니 목록
	@Override
	public List<CartVO> cart(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Cart_SQL.cart", id);
	}

	// 장바구니 추가
	@Override
	public void cartInsert(CartVO vo) throws Exception {

		sql.insert("mapper.Cart_SQL.insert_cart",vo);
	}

	//장바구니 삭제
	@Override
	public CartVO cartDelete(Integer code)throws Exception{

		return sql.selectOne("mapper.Cart_SQL.delete_cart",code);
	}
}
