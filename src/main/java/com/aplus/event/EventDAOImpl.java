package com.aplus.event;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOImpl implements EventDAO {
	@Autowired SqlSession sql;
	
	@Override
	public void eventCreate(EventVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("mapper.Event_SQL.event_insert",vo);
	}

	
	/*@Override
	public List<EventVO> getList() {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Event_SQL.event_list");
	}*/


	@Override
	public List<EventVO> list() {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Event_SQL.event_list");
	}


	@Override
	public EventVO eventDetail(Integer num) throws Exception {
		// TODO Auto-generated method stub
		
		return sql.selectOne("mapper.Event_SQL.event_detail",num);
	}

	@Override
	public EventVO eventDelete(Integer num) throws Exception {
		// TODO Auto-generated method stub
		
		return sql.selectOne("mapper.Event_SQL.event_Delete",num);
	}
	
	@Override
	public EventVO eventUpdate(EventVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		return sql.selectOne("mapper.Event_SQL.event_Update",vo);
	}


	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Event_SQL.event_Count");
	}

}
