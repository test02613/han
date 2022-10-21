package com.aplus.review;

import java.util.List;

import com.aplus.order.OrderVO;

public interface ReviewDAO {
		
	public void reviewCreate(ReviewVO vo) throws Exception;
	
	public List<ReviewVO> reviewList() throws Exception;
	
	public ReviewVO reviewDetail(Integer num) throws Exception;
	
	public void reviewCheck(OrderVO vo) throws Exception;
	
	public ReviewVO reviewUpdate(ReviewVO vo) throws Exception;

	public ReviewVO reviewDelete(Integer num) throws Exception;
	
	public void reviewCheckDelete(OrderVO vo) throws Exception;
	
}
