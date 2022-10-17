package com.aplus.admin;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.item.ItemVO;
@Repository
public class AdminDAOimpl implements AdminDAO {
	@Autowired SqlSession sql;
	
	@Override
	public void registItem(ItemVO vo) throws Exception {
		sql.insert("mapper.Admin_SQL.registItem",vo);
	}	
}
