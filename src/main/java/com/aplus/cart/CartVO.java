package com.aplus.cart;

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
	 private String itemattr;

}
