package com.aplus.cart;

import java.sql.Date;

import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemVO;
import com.aplus.order.OrderVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVO {
	
	 private String id;
	 private String itemname;
	 private Integer itemcode;
	 private Integer itemcost;
	 private String itemimg;

}
