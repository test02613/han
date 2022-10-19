package com.aplus.event;

import java.sql.Date;
import java.util.List;

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
public class EventVO {
   
	private Integer eventnum;
	private Date eventdate;
	private String eventtitle;
	private String eventcontent;

}