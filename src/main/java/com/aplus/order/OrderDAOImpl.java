package com.aplus.order;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.item.ItemAttrVO;
import com.aplus.model.MemberVO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SqlSession sql;

	@Override
	public void orderCreate(OrderVO vo) throws Exception {
		sql.insert("mapper.Order_SQL.order_insert",vo);

	}

	@Override
	public ItemAttrVO order_item(Integer code) throws Exception {
		return sql.selectOne("mapper.Item_SQL.order_item", code);
	}

	@Override
	public MemberVO member(String id) throws Exception{
		return sql.selectOne("mapper.Member_SQL.order_item",id);
	}
	
	@Override
	public MemberVO pointUpdate(MemberVO vo) throws Exception{
		return sql.selectOne("mapper.Member_SQL.use_point",vo);	
	}
	
}
