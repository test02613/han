package com.aplus.cart;

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

import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemService;
import com.aplus.item.ItemVO;
import com.aplus.order.OrderService;


@Controller
public class CartController {
private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	

	@Autowired	
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ItemService itemService;

	
	//장바구니 목록
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cartGet(Model model,HttpSession session,CartVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>장바구니 진입");
		
		//세션에서 아이디 가져와서 list에 저장
		String id = (String) session.getAttribute("id");
		List<CartVO> list = cartService.cart(id);
		
		model.addAttribute("list", list);
		logger.info("list" + list);
		
				
		return "cart/cart";
	}

	//장바구니 추가
	@RequestMapping(value = "/addCartAction", method = RequestMethod.GET)
	public String addCartAction(HttpSession session,CartVO vo, Integer code, Model model,ItemAttrVO attr) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>장바구니 진입");
		
		//세션에서 아이디 가져와서 list에 저장
        String id = (String) session.getAttribute("id");
        vo.setId(id);
        attr.setItemcode(code);
		attr = orderService.order_item(code);
        String color =attr.getItemcolor();
		Integer cost =attr.getItemcost();
		String name =attr.getItemname();
		Integer num = attr.getItemnum();
		ItemVO itemvo = itemService.itemDetail(num);
		String itemimg = itemvo.getItemimg();
	    vo.setItemcode(code);
		vo.setItemcost(cost);
		vo.setItemname(name);
		vo.setItemattr(color);
		vo.setItemimg(itemimg);

		logger.info("CartVO"+ vo);
		cartService.cartInsert(vo);
		
		return "redirect:/cart";
	}
	
	//장바구니 삭제
	@RequestMapping(value = "/cartDeleteAction", method = RequestMethod.GET)
	public String cartDeleteAction(CartVO vo, Model model,Integer code) throws Exception {
		
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 장바구니 삭제");
		cartService.cartDelete(code);
		
		
		
		return "redirect:/cart";
	}
	
}
