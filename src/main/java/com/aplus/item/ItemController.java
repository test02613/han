package com.aplus.item;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/itemList", method = { RequestMethod.GET, RequestMethod.POST })
	public String itemListGet(Model model, Integer cat) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> itemList 진입");
		List<ItemVO> list = itemService.itemList(cat);
		model.addAttribute("itemList", list);

		logger.info("itemService.itemList(cat)" + list);

		return "item/itemList";
	}

	@RequestMapping(value = "/itemListL", method = { RequestMethod.GET, RequestMethod.POST })
	public String itemListLGet(Model model, Integer cat) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> itemListL 진입");
		List<ItemVO> list = itemService.itemListL(cat);
		model.addAttribute("itemList", list);

		logger.info("itemService.itemListL(cat)" + list);

		return "item/itemList";
	}

	// 상품 상세페이지
	@RequestMapping(value = "/itemDetail", method = RequestMethod.GET)
	public String itemDetail(Model model, Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 상품 상세 페이지 진입");

		ItemVO list = itemService.itemDetail(num);
		model.addAttribute("detail", list);

		List<ItemAttrVO> attrlist = itemService.itemAttr(num);
		model.addAttribute("list1", attrlist);

		return "item/itemDetail";
	}
	
	@RequestMapping(value = "/colorChk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String colorChkGET(ItemAttrVO vo, Model model,@RequestParam("color") String color , @RequestParam("num") Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  진입");
		vo.setItemcolor(color);
		vo.setItemnum(num);
		
		/*List<ItemAttrVO> list = itemservice.colorChk(vo);*/
		vo = itemService.colorChk(vo);
		Integer cost = vo.getItemcost();
		Integer code = vo.getItemcode();
		String to = Integer.toString(cost);
		String tt = Integer.toString(code);
		logger.info("uuuu"+cost);
		logger.info("vo"+vo);
		
		return to;
	}
	
	@RequestMapping(value = "/itemCode", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String itemCodeGET(ItemAttrVO vo, Model model,@RequestParam("color") String color , @RequestParam("num") Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  진입");
		vo.setItemcolor(color);
		vo.setItemnum(num);
		
		/*List<ItemAttrVO> list = itemservice.colorChk(vo);*/
		vo = itemService.colorChk(vo);
		Integer cost = vo.getItemcode();
		String to = Integer.toString(cost);
		logger.info("uuuudddd"+cost);
		logger.info("vo"+vo);
		
		return to;
	}

}
