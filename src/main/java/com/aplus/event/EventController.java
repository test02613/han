package com.aplus.event;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String eventGET(EventVO vo, Model model,HttpServletResponse response, HttpSession session) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 이벤트 페이지 진입");
		/*int admin =  (int) session.getAttribute("admin");*/
	        model.addAttribute("list", eventService.list());
	        logger.info("list"+vo);
	       /* logger.info("list"+eventService.list());*/
	      
		return "event/event";
	}
	
	@RequestMapping(value = "/eventCreate", method = { RequestMethod.GET, RequestMethod.POST })
	public String evntcreateGET(EventVO vo, Model model,HttpServletResponse response, HttpSession session) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 글쓰기 페이지 진입");
		/*int admin =  (int) session.getAttribute("admin");*/
		return "event/eventCreate";
	}
	
	@RequestMapping(value = "/eventCreateAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String eventCreateActionPost(EventVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 글쓰기  진입");
		eventService.eventCreate(vo);
		logger.info("vo"+vo);
		return "redirect:/event";
	}
	
	@RequestMapping(value = "/eventDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String eventDetailGET(Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 디테일 진입");
		EventVO vo = eventService.eventDetail(num);
		 model.addAttribute("detail", vo);
		 logger.info("vo"+vo);
		return "event/eventDetail";
	}
	
	@RequestMapping(value = "/eventUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String eventUpdateGET(Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 수정 진입");
		EventVO vo = eventService.eventDetail(num);
		model.addAttribute("detail", vo);
		logger.info("vo"+vo);
		return "event/eventCreate";
	}
	@RequestMapping(value = "/eventUpdateAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String eventUpdateActionGET(EventVO vo,Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 수정실행 진입");
		eventService.eventDetail(num);
		
		vo.setEventnum(num);
		logger.info("vo"+num);
		 eventService.eventUpdate(vo);
		/*model.addAttribute("update", vo1);*/
		return "redirect:/eventDetail?num="+num;
	}
	
	@RequestMapping(value = "/eventDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public String eventDeleteGET(EventVO vo,Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 수정실행 진입");
		eventService.eventDetail(num);
		
		vo.setEventnum(num);
		logger.info("vo"+num);
		eventService.eventDelete(num);
		/*model.addAttribute("update", vo1);*/
		return "redirect:/event";
	}
}
