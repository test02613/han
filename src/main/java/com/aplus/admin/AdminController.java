package com.aplus.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aplus.item.ItemVO;
import com.aplus.model.MemberVO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService; // 코드 추가

	@RequestMapping(value = "/admin_main", method = RequestMethod.GET)
	public String admin_mainGET(MemberVO vo, HttpServletResponse response, HttpSession session) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 관리자 페이지 진입");
		response.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String admin1 = (String) session.getAttribute("admin");
//		int admin = (int) session.getAttribute("admin");
		int admin = Integer.parseInt(admin1);
		logger.info("vo1: " + admin);
		if (admin == 0) {
			out.print("<script>alert('\" 보노보노 \"'); history.go(-1);</script>");
			logger.info("vo1" + admin);
			out.close();
			return "main/main";
		} else if (admin == 1) {
			logger.info("vo2" + vo);
			return "admin/admin_main";
		} else {

			return "member/login";
		}
	}

	@RequestMapping(value = "/itemRegist", method = RequestMethod.GET)
	public String itemRegist() throws Exception {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  상품등록 페이지 진입");
		return ("admin/itemRegist");
	}

	// 상품등록
	@RequestMapping(value = "/itemRegistAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinPost(ItemVO vo,Model model) throws Exception {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  상품등록 실행");
		

		// 상품등록 실행
		adminService.registItem(vo);

		logger.info("상품등록 성공");

		return "redirect:/admin_main";
	}

	/* 첨부 파일 업로드 */
	//<form> 태그를 이용하던 방식과 동일한 방식으로 처리됨
		//Ajax 방식으로 결과 데이터를 전달하므로 Model을 사용하지 않음.
		@ResponseBody
		@RequestMapping(value="/uploadAjaxAction", method = { RequestMethod.GET, RequestMethod.POST })
//		public List<AttachFileVO> uploadAjaxAction(MultipartFile[] uploadFile) {
		public ResponseEntity<List<AttachFileVO>> uploadAjaxAction(MultipartFile[] uploadFile) {
			
			String uploadFolder = "C:\\Users\\hss61\\Desktop\\Java\\works\\teamproject\\APLUS_Mall\\src\\main\\webapp\\resources\\itemImg";
			
			//연/월/일 폴더 생성 시작-------
			File uploadPath = new File(uploadFolder, getFolder());
			logger.info("uploadPath : " + uploadPath);
			
			if(uploadPath.exists()==false) {//해당 경로가 없으면 생성해줘야함
				uploadPath.mkdirs();			
			}
			//연/월/일 폴더 생성 끝-------
			
			//첨부된 파일의 이름을 담을 List
			List<AttachFileVO> list = new ArrayList<AttachFileVO>();
						
			for(MultipartFile multipartFile : uploadFile) {
				
				logger.info("-----------");
				logger.info("파일명 : " + multipartFile.getOriginalFilename());
				logger.info("파일크기 : " + multipartFile.getSize());
				
				AttachFileVO attachFileVO = new AttachFileVO();
				//1) fileName
				attachFileVO.setFileName(multipartFile.getOriginalFilename());
				
				//-----------UUID 파일명 처리 시작 ----------------------------
				//동일한 이름으로 업로드되면 기존 파일을 지우게 되므로 이를 방지하기 위함
				UUID uuid = UUID.randomUUID();
				
				String uploadFileName = uuid.toString() + "-" + multipartFile.getOriginalFilename();
				// c:\\upload\\gongu03.jpg으로 조립
				// 이렇게 업로드 하겠다라고 설계 uploadFolder -> uploadPath
				File saveFile = new File(uploadPath,uploadFileName);
				//-----------UUID 파일명 처리 끝 ----------------------------
				
				try {
					
					//transferTo() : 물리적으로 파일 업로드가 됨
					multipartFile.transferTo(saveFile);
				
					//2) uploadPath
					attachFileVO.setUploadPath(uploadPath.getPath());
					//3) uuid
					attachFileVO.setUuid(uuid.toString());
					//-------썸네일 처리 시작---------
					//이미지 파일인지 체킹
					if(checkImageType(saveFile)) {
						logger.info("이미지 파일? true");
						//4) image여부
						attachFileVO.setImage(true);
						//uploadPath : 연/월/일이 포함된 경로
						//uploadFileName : UUID가 포함된 파일명
						FileOutputStream thumbnail = 
								new FileOutputStream(
										new File(uploadPath,"s_"+uploadFileName));
						Thumbnailator.createThumbnail(multipartFile.getInputStream(),
								thumbnail, 500, 500);
						thumbnail.close();
					}else {
						logger.info("이미지 파일? false");
					}
					//-------썸네일 처리 끝---------
					
					//파일 실제 명을 list에 담음
					list.add(attachFileVO);
				}catch(Exception e){
					logger.info(e.getMessage());
				}//end catch
			}//end for
			
//			return list;
			return new ResponseEntity<List<AttachFileVO>>(list, HttpStatus.OK);
		}//end uploadAjaxAction
		
		//첨부파일을 보관하는 폴더를 연/월/일 계층 형태로 생성하기 위함
		private String getFolder() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String str = sdf.format(date);
			return str.replace("-", File.separator);
		}
		
		//특정한 파일이 이미지 타입인지 검사해주는 메소드
		private boolean checkImageType(File file) {
			try {
				//file.toPath() : 파일의 전체 경로
				logger.info("file.toPath() : " + file.toPath());
				String contentType = Files.probeContentType(file.toPath());
				logger.info("contentType : " + contentType);
				//contentType이 image로 시작하면 이미지 타입이므로 true를 리턴함
				return contentType.startsWith("image");
			}catch(IOException e) {
				e.printStackTrace();
			}
			return false;
		}

}