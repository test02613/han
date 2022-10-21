package com.aplus.review;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.order.OrderVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired SqlSession sql;

	@Override
	public void reviewCreate(ReviewVO vo) throws Exception {
		
		sql.insert("mapper.Review_SQL.review_insert",vo);
	}

	@Override
	public List<ReviewVO> reviewList() throws Exception {
		return sql.selectList("mapper.Review_SQL.review_list");
	}

	@Override
	public ReviewVO reviewDetail(Integer num) throws Exception {
		return sql.selectOne("mapper.Review_SQL.review_detail",num);
	}

	@Override
	public void reviewCheck(OrderVO vo) throws Exception {
		 sql.selectOne("mapper.Review_SQL.review_check",vo);
		
	}
	
	@Override
	public ReviewVO reviewUpdate(ReviewVO vo) throws Exception{
		return sql.selectOne("mapper.Review_SQL.review_Update",vo);
	}
	
	@Override
	public ReviewVO reviewDelete(Integer num) throws Exception{
		return sql.selectOne("mapper.Review_SQL.review_Delete",num);
	}
	
	@Override
	public void reviewCheckDelete(OrderVO vo) throws Exception{
		 sql.selectOne("mapper.Review_SQL.review_check_delete",vo);
	}
	
	

}
