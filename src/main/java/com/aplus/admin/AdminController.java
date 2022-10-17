package com.aplus.admin;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aplus.item.ItemVO;
import com.aplus.model.MemberVO;

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
		int admin = (int) session.getAttribute("admin");

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
	
	// 상품등록
	@RequestMapping(value = "/itemRegistAction", method = RequestMethod.POST)
	public String joinPost(ItemVO vo) throws Exception {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  상품등록");

		// 상품등록 실행
		adminService.registItem(vo);

		logger.info("상품등록 성공");

		return "redirect:/admin/admin_main";
	}

	/* 첨부 파일 업로드 */
	@ResponseBody
	@PostMapping("/detailImgAction")
	public void detailImgActionPOST(MultipartFile[] uploadFile) {

		logger.info("detailImgActionActionPOST..........");

		String uploadFolder = "resources/mall_recent/src/main/webapp/resources/itemDetailImg";

		/* 폴더 생성 */
		File uploadPath = new File(uploadFolder);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		// 향상된 for
		for (MultipartFile multipartFile : uploadFile) {
			/* 파일 이름 */
			String uploadFileName = multipartFile.getOriginalFilename();

			/* 파일 위치, 파일 이름을 합친 File 객체 */
			File saveFile = new File(uploadPath, uploadFileName);

			/* 파일 저장 */
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // for
	}
	/* 첨부 파일 업로드 */
	@ResponseBody
	@PostMapping("/imgAction")
	public void imgActionPOST(MultipartFile[] uploadFile) {

		logger.info("imgActionPOST..........");

		String uploadFolder = "resources/mall_recent/src/main/webapp/resources/itemImg";

		/* 폴더 생성 */
		File uploadPath = new File(uploadFolder);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		// 향상된 for
		for (MultipartFile multipartFile : uploadFile) {
			/* 파일 이름 */
			String uploadFileName = multipartFile.getOriginalFilename();

			/* 파일 위치, 파일 이름을 합친 File 객체 */
			File saveFile = new File(uploadPath, uploadFileName);

			/* 파일 저장 */
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // for
	}
	
//	/* 첨부 파일 업로드 */
//	@PostMapping("/uploadAjaxAction")
//	public void uploadAjaxActionPOST(MultipartFile[] uploadFile) {
//
//		logger.info("uploadAjaxActionPOST..........");
//
//		String uploadFolder = "resources/mall_recent/src/main/webapp/resources/itemDetailImg";
//
//		/* 날짜 폴더 경로 */
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//		Date date = new Date();
//
//		String str = sdf.format(date);
//
//		String datePath = str.replace("-", File.separator);
//
//		/* 폴더 생성 */
//		File uploadPath = new File(uploadFolder, datePath);
//
//		if (uploadPath.exists() == false) {
//			uploadPath.mkdirs();
//		}
//
//		// 향상된 for
//		for (MultipartFile multipartFile : uploadFile) {
//			/* 파일 이름 */
//			String uploadFileName = multipartFile.getOriginalFilename();
//
//			/* 파일 위치, 파일 이름을 합친 File 객체 */
//			File saveFile = new File(uploadPath, uploadFileName);
//
//			/* 파일 저장 */
//			try {
//				multipartFile.transferTo(saveFile);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} // for
//	}
}