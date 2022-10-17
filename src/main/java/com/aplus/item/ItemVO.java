package com.aplus.item;

public class ItemVO {

	private Integer itemnum;
	private String itemname;
	private Integer itemcat1;
	private Integer itemcat2;
	private String itemimg;
	private String itemdetailimg;
	public Integer getItemnum() {
		return itemnum;
	}
	public void setItemnum(Integer itemnum) {
		this.itemnum = itemnum;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Integer getItemcat1() {
		return itemcat1;
	}
	public void setItemcat1(Integer itemcat1) {
		this.itemcat1 = itemcat1;
	}
	public Integer getItemcat2() {
		return itemcat2;
	}
	public void setItemcat2(Integer itemcat2) {
		this.itemcat2 = itemcat2;
	}
	public String getItemimg() {
		return itemimg;
	}
	public void setItemimg(String itemimg) {
		this.itemimg = itemimg;
	}
	public String getItemdetailimg() {
		return itemdetailimg;
	}
	public void setItemdetailimg(String itemdetailimg) {
		this.itemdetailimg = itemdetailimg;
	}
	@Override
	public String toString() {
		return "ItemVO [itemnum=" + itemnum + ", itemname=" + itemname + ", itemcat1=" + itemcat1 + ", itemcat2="
				+ itemcat2 + ", itemimg=" + itemimg + ", itemdetailimg=" + itemdetailimg + "]";
	}
	public ItemVO(Integer itemnum, String itemname, Integer itemcat1, Integer itemcat2, String itemimg,
			String itemdetailimg) {
		super();
		this.itemnum = itemnum;
		this.itemname = itemname;
		this.itemcat1 = itemcat1;
		this.itemcat2 = itemcat2;
		this.itemimg = itemimg;
		this.itemdetailimg = itemdetailimg;
	}
	
}
