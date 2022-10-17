package com.aplus.item;

import java.util.List;

public interface ItemService {

	

	public List<ItemVO> itemList(Integer cat)  throws Exception;
	
	
	public List<ItemVO> itemListL(Integer cat)  throws Exception;

	//이벤트 상세페이지
	public ItemVO itemDetail(Integer num) throws Exception;
	
	//
	public List<ItemAttrVO> itemAttr(Integer num) throws Exception;
	
	public ItemAttrVO colorChk(ItemAttrVO vo) throws Exception;
	

}
