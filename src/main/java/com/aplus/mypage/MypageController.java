package com.aplus.mypage;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aplus.event.EventVO;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;

@Controller
public class MypageController {

	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageService mypageService;


	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypagetGET(Model model, HttpSession session, MemberVO mem) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 마이 페이지 진입");

		String id = (String) session.getAttribute("id");// 세션 id가져오기
		mem = mypageService.memberDetail(id);// 고객 정보 가져오기
		model.addAttribute("member", mem);
		logger.info("memberDetail = " + mem);
		

		return "mypage/mypage";
	}

	@RequestMapping(value = "/myupdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String myupdateGET(Model model, HttpSession session, MemberVO mem) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 정보수정 페이지 진입");
		
		
		String id = (String) session.getAttribute("id");// 세션 id가져오기
		mem = mypageService.memberDetail(id);// 고객 정보 가져오기
		model.addAttribute("member", mem);
		
		
		return "mypage/myupdate";
	}
	
	@RequestMapping(value = "/myupdateAction", method = RequestMethod.POST)
	public String myupdateAction(MemberVO member) throws Exception {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> mypageUpdate 진입");

		// 회원가입 서비스 실행
		mypageService.mypageUpdate(member);

		logger.info("mypageUpdate Service 성공");

		return "redirect:/mypage";
	}

	@RequestMapping(value = "/myorder", method = { RequestMethod.GET, RequestMethod.POST })
	public String myorderGET(Model model,HttpSession session)throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 주문조회 페이지 진입");
		String id = (String) session.getAttribute("id");// 세션 id가져오기
		List<OrderVO> list = mypageService.myOrder(id);
		model.addAttribute("order", list);
		logger.info("order = " + list);	
		
		return "mypage/myorder";
	}

	@RequestMapping(value = "/mypoint", method = { RequestMethod.GET, RequestMethod.POST })
	public String mypointGET() throws Exception{
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 포인트 조회 페이지 진입");
		return "mypage/mypoint";
	}

	@RequestMapping(value = "/myreview", method = { RequestMethod.GET, RequestMethod.POST })
	public String myreviewGET() throws Exception{
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰관리 페이지 진입");
		
		return "mypage/myreview";
	}

	@RequestMapping(value = "/myqna", method = { RequestMethod.GET, RequestMethod.POST })
	public String myqnaGET() throws Exception{
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 큐엔에이 페이지 진입");
		return "mypage/myqna";
	}

}
