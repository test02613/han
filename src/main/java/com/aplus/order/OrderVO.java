package com.aplus.order;

import java.sql.Date;

import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
   
   private String id;
   private Integer ordernum;
   private String shippingnum;
   private String shippingcost;
   private String ordercost;
   private Date orderdate;
   private String payment;
   private String postcode;
   private String address;
   private String addressdetail;
   private String mobile;
   private String name;
   private Integer itemcode;
   
   private ItemAttrVO itemattrvo;
   private ItemVO itemvo;

}