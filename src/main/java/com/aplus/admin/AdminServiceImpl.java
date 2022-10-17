package com.aplus.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplus.item.ItemVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired AdminDAO dao;
	
	@Override
	public void registItem(ItemVO vo) throws Exception {

		dao.registItem(vo);
	}
}
