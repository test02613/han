package com.aplus.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	// 회원탈퇴시 leave 1로 변경
	@RequestMapping(value = "/memberLeave", method = { RequestMethod.GET, RequestMethod.POST })

	public String memberLeave(MemberVO vo, Model model, HttpSession session) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  진입");

		String memInfo = (String) session.getAttribute("id");// 세션 id가져오기
		vo = mypageService.memberDetail(memInfo);// 고객 정보 가져오기

		mypageService.memberLeave(vo);

		session.invalidate(); // 세션 종료

		return "redirect:/main";
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

	// 포인트 조회 페이지
	@RequestMapping(value = "/mypoint", method = RequestMethod.GET)
	public String mypointGET(Model model, HttpSession session, MemberVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 포인트 조회 페이지 진입");

		String memInfo = (String) session.getAttribute("id");// 세션 id가져오기
		vo = mypageService.memberDetail(memInfo);// 고객 정보 가져오기
		model.addAttribute("member", vo);

		return "mypage/myPoint";
	}

	// 포인트 충전
	@RequestMapping(value = "/mypointUpdateAction", method = RequestMethod.POST)
	public String mypointUpdateAction(Model model, HttpSession session, MemberVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 포인트 조회 페이지 진입");

		String memInfo = (String) session.getAttribute("id");// 세션 id가져오기
		vo = mypageService.memberDetail(memInfo);// 고객 정보 가져오기
		Integer a = Integer.parseInt(vo.getPoint());
		mypageService.pointUpdate(vo);
		Integer b = Integer.parseInt(vo.getPoint());
		
		Integer pcharge = a + b;
		String c = Integer.toString(pcharge);
		
		vo.setPoint(c);
		mypageService.pointUpdate(vo);
		return "redirect:/mypage";
	}

	// 리뷰관리 페이지 -> ReviewController로 이동

	// 1:1문의 페이지
	@RequestMapping(value = "/myqna", method = { RequestMethod.GET, RequestMethod.POST })
	public String myqnaGET(Model model, OrderVO vo, HttpSession session) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 큐엔에이 페이지 진입");

		return "mypage/myQna";
	}

}
