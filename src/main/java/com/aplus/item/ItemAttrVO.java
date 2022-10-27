package com.aplus.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemAttrVO {

	   private Integer itemnum;
	   private Integer itemcode;
	   private String itemname;
	   private String itemcolor;
	   private Integer itemcost;
	   private Integer itemstock;
		   
}
