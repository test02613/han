package com.aplus.review;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
	
	private Integer itemnum;
	private String id;
	private Integer reviewnum;
	private Date reviewdate;
	private String reviewtitle;
	private String reviewcontent;
	private String reviewpw;
	private Integer ordernum;

}
