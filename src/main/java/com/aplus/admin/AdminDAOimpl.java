package com.aplus.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemVO;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;
import com.aplus.review.ReviewVO;

@Repository
public class AdminDAOimpl implements AdminDAO {
	@Autowired
	SqlSession sql;

	// 회원관리 리스트
	@Override
	public List<MemberVO> memberList() throws Exception {

		return sql.selectList("mapper.Admin_SQL.member_list");
	}

	// 회원 블랙처리
	@Override
	public MemberVO memberBlack(MemberVO vo) throws Exception {

		return sql.selectOne("mapper.Admin_SQL.member_black", vo);
	}

	// 회원 블랙처리
	@Override
	public MemberVO blackReturn(MemberVO vo) throws Exception {

		return sql.selectOne("mapper.Admin_SQL.black_return", vo);
	}

	// 주문관리
	@Override
	public List<OrderVO> orderAdmin() throws Exception {

		return sql.selectList("mapper.Admin_SQL.order_admin");
	}

	// 주문-배송상태 변경
	@Override
	public OrderVO stateChange(OrderVO vo) throws Exception {

		return sql.selectOne("mapper.Admin_SQL.state_change", vo);
	}

	// 리뷰관리
	@Override
	public List<ReviewVO> reviewAdmin() throws Exception {

		return sql.selectList("mapper.Admin_SQL.review_admin");
	}

	// 리뷰삭제
	@Override
	public ReviewVO reviewDeleteAdmin(Integer reviewnum) throws Exception {

		return sql.selectOne("mapper.Admin_SQL.reviewdelete_admin", reviewnum);
	}

	// 상품등록
	@Override
	public void registItem(ItemVO vo) throws Exception {
		sql.insert("mapper.Admin_SQL.registItem", vo);
	}

	// 상품상세 등록
	@Override
	public void itemattrInsert(ItemAttrVO attr) throws Exception {

		sql.insert("mapper.Admin_SQL.itemattr_insert", attr);
	}

	// 상품(대분류)수정
	@Override
	public ItemVO itemUpdate(ItemVO vo) throws Exception {

		return sql.selectOne("mapper.Admin_SQL.item_update", vo);
	}

	// 상품상세(중분류)수정
	@Override
	public ItemAttrVO attrUpdate(ItemAttrVO attr) throws Exception {

		return sql.selectOne("mapper.Admin_SQL.attr_update", attr);
	}

	// 상품 구분
	@Override
	public List<ItemVO> itemSelect(ItemVO vo) throws Exception {

		return sql.selectList("mapper.Admin_SQL.item_select", vo);
	}

	// 상품상세 등록시(대분류)값 들고오기
	@Override
	public ItemVO itemInfo(ItemVO vo) throws Exception {

		return sql.selectOne("mapper.Admin_SQL.item_info", vo);
	}

	// 상품상세 수정시 값 들고오기
	@Override
	public ItemAttrVO attrInfo(ItemAttrVO attr) throws Exception {

		return sql.selectOne("mapper.Admin_SQL.attr_info", attr);
	}

	// 상품 삭제
	public void itemDelete(Integer num) throws Exception {
		sql.selectOne("mapper.Admin_SQL.item_Delete", num);
	}

	// 상품 옵션 동시 삭제
	public void itemAttrDeleteAll(Integer num) throws Exception {
		sql.selectOne("mapper.Admin_SQL.itemAttr_Delete_All", num);

	}

	// 상품 옵션 삭제
	public void itemAttrDelete(Integer num) throws Exception {
		sql.selectOne("mapper.Admin_SQL.itemAttr_Delete", num);
	}

}
