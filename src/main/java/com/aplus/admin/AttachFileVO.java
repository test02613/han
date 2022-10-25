package com.aplus.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachFileVO {
	
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;

}
