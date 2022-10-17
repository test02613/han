package com.aplus.event;

import java.util.List;

public interface EventService {

	//CRUD 기능의 메소드 구현
	
	//이벤트 글쓰기
	public void eventCreate(EventVO vo) throws Exception;
	//이벤트 목록
	public List<EventVO> list()  throws Exception;
	//이벤트 상세페이지
	public EventVO eventDetail(Integer num) throws Exception;
	
	public EventVO eventDelete(Integer num) throws Exception;
	
	public EventVO eventUpdate(EventVO vo) throws Exception;
	
	public int count() throws Exception;
}
