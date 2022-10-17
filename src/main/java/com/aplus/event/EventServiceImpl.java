package com.aplus.event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
	
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired EventDAO dao;
	
	@Override
	public void eventCreate(EventVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.eventCreate(vo);
	}

	/*@Override
	public void List<EventVO> eventVOList(EventVO vo) throws Exception {
		
		return dao.eventVOList(vo);
	}*/

	@Override
	public List<EventVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public EventVO eventDetail(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return dao.eventDetail(num);
	}

	@Override
	public EventVO eventDelete(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return dao.eventDelete(num);
	}
	
	@Override
	public EventVO eventUpdate(EventVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.eventUpdate(vo);
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return dao.count();
	}
	

}
