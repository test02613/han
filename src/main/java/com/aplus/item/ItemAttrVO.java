package com.aplus.item;

public class ItemAttrVO {

	   private Integer itemnum;
	   private Integer itemcode;
	   private String itemname;
	   private String itemcolor;
	   private Integer itemcost;
	   private Integer itemstock;
	   private String itemgb;
	public Integer getItemnum() {
		return itemnum;
	}
	public void setItemnum(Integer itemnum) {
		this.itemnum = itemnum;
	}
	public Integer getItemcode() {
		return itemcode;
	}
	public void setItemcode(Integer itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemcolor() {
		return itemcolor;
	}
	public void setItemcolor(String itemcolor) {
		this.itemcolor = itemcolor;
	}
	public Integer getItemcost() {
		return itemcost;
	}
	public void setItemcost(Integer itemcost) {
		this.itemcost = itemcost;
	}
	public Integer getItemstock() {
		return itemstock;
	}
	public void setItemstock(Integer itemstock) {
		this.itemstock = itemstock;
	}
	public String getItemgb() {
		return itemgb;
	}
	public void setItemgb(String itemgb) {
		this.itemgb = itemgb;
	}
	@Override
	public String toString() {
		return "ItemAttrVO [itemnum=" + itemnum + ", itemcode=" + itemcode + ", itemname=" + itemname + ", itemcolor="
				+ itemcolor + ", itemcost=" + itemcost + ", itemstock=" + itemstock + ", itemgb=" + itemgb + "]";
	}
	public ItemAttrVO(Integer itemnum, Integer itemcode, String itemname, String itemcolor, Integer itemcost,
			Integer itemstock, String itemgb) {
		super();
		this.itemnum = itemnum;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.itemcolor = itemcolor;
		this.itemcost = itemcost;
		this.itemstock = itemstock;
		this.itemgb = itemgb;
	}
	
	   
}
