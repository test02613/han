package com.aplus.item;

import java.sql.Date;

import com.aplus.order.OrderVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVO {

	private Integer itemnum;
	private String itemname;
	private Integer itemcat1;
	private Integer itemcat2;
	private String itemimg;
	private String itemdetailimg;
	
	
}
