package com.aplus.event;

import java.util.List;

public interface EventDAO {
		
	public void eventCreate(EventVO vo) throws Exception;
	
	public List<EventVO> list() throws Exception;

	/*public List<EventVO> eventVOList(EventVO vo);*/

	public EventVO eventDetail(Integer num) throws Exception;
	
	public EventVO eventDelete(Integer num) throws Exception;

	public EventVO eventUpdate(EventVO vo) throws Exception;
	
	public int count() throws Exception;

}
