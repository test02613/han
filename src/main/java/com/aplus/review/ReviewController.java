package com.aplus.review;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aplus.event.EventVO;
import com.aplus.order.OrderVO;

@Controller
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String reviewGET(Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰페이지 진입");

		List<ReviewVO> list = reviewService.reviewList();
		model.addAttribute("list", list);

		logger.info("list" + list);

		return "review/review";
	}

	@RequestMapping(value = "/reviewCreate", method = RequestMethod.GET)
	public String reviewCreateGet( Model model, Integer ordernum, Integer itemnum ) throws Exception {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰 작성 페이지 진입");
	model.addAttribute("ordernum",ordernum);
	model.addAttribute("itemnum",itemnum);
	

		return "review/reviewCreate";
	}

	@RequestMapping(value = "/reviewCreateAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String eventCreateActionPost(ReviewVO vo,HttpSession session) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰 작성 버튼");
		String id = (String) session.getAttribute("id");// 세션 id가져오기
	      vo.setId(id);

		reviewService.reviewCreate(vo);
		logger.info("vo" + vo);
		return "redirect:/review";
	}
	
	@RequestMapping(value = "/reviewDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewDetailGET(Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 디테일 진입");
		ReviewVO vo = reviewService.reviewDetail(num);
		 model.addAttribute("detail", vo);
		 logger.info("vo"+vo);
		return "review/reviewDetail";
	}
	@RequestMapping(value="/reviewCheck", method= { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void reviewCheck(@RequestParam("num")String num,OrderVO vo) throws Exception {
		Integer ordernum = Integer.parseInt(num);
		vo.setOrdernum(ordernum);
		
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰 작성 체크");
		reviewService.reviewCheck(vo);
		
	}
	
	@RequestMapping(value = "/reviewUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewUpdateGET(Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 수정 진입");
		ReviewVO vo = reviewService.reviewDetail(num);
		model.addAttribute("detail", vo);
		logger.info("vo"+vo);
		return "review/reviewCreate";
	}
	@RequestMapping(value = "/reviewUpdateAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewUpdateActionGET(ReviewVO vo,Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 수정실행 진입");
		reviewService.reviewDetail(num);
		
		vo.setReviewnum(num);
		logger.info("vo"+num);
		 reviewService.reviewUpdate(vo);
		/*model.addAttribute("update", vo1);*/
		return "redirect:/reviewDetail?num="+num;
	}
	@RequestMapping(value = "/reviewDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public String reviewDeleteAction(ReviewVO vo,Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 삭제 실행");
		reviewService.reviewDetail(num);
		
		vo.setReviewnum(num);
		logger.info("vo"+num);
		reviewService.reviewDelete(num);
		/*model.addAttribute("update", vo1);*/
		return "review/reviewDetail";
	}
	
	@RequestMapping(value="/reviewCheckDelete", method= { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void reviewCheckDelete(@RequestParam("num")String num,OrderVO vo) throws Exception {
		Integer ordernum = Integer.parseInt(num);
		vo.setOrdernum(ordernum);
		
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰 작성 체크 삭제");
		reviewService.reviewCheckDelete(vo);
		
	}
}
