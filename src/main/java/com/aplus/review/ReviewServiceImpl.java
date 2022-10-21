package com.aplus.review;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplus.order.OrderVO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired ReviewDAO dao;

	@Override
	public void reviewCreate(ReviewVO vo) throws Exception {
		dao.reviewCreate(vo);
		
	}

	@Override
	public List<ReviewVO> reviewList() throws Exception {
		
		return dao.reviewList();
	}

	@Override
	public ReviewVO reviewDetail(Integer num) throws Exception {
		return dao.reviewDetail(num);
	}

	@Override
	public void reviewCheck(OrderVO vo) throws Exception {
		dao.reviewCheck(vo);
		
	}
	
	@Override
	public ReviewVO reviewUpdate(ReviewVO vo) throws Exception{
		return dao.reviewUpdate(vo);
	}

	@Override
	public ReviewVO reviewDelete(Integer num) throws Exception {
		
		return dao.reviewDelete(num);
	}

	@Override
	public void reviewCheckDelete(OrderVO vo) throws Exception {
		dao.reviewCheckDelete(vo);		
	}
	
}
