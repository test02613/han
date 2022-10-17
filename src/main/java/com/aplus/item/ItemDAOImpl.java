package com.aplus.item;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl implements ItemDAO {
	@Autowired SqlSession sql;
	
	@Override
	public List<ItemVO> itemList(Integer cat) {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Item_SQL.item_list",cat);
	}
	
	@Override
	public List<ItemVO> itemListL(Integer cat) {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Item_SQL.item_listL",cat);
	}


	@Override
	public ItemVO itemDetail(Integer num) throws Exception {
		// TODO Auto-generated method stub
		
		return sql.selectOne("mapper.Item_SQL.item_detail",num);
	}

	//상품 디테일
	@Override
	public List<ItemAttrVO> itemAttr(Integer num) throws Exception {
	
		return sql.selectList("mapper.Item_SQL.item_attr", num);
	}
	
	@Override
	public ItemAttrVO colorChk(ItemAttrVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Item_SQL.item_color",vo);
	}

}
