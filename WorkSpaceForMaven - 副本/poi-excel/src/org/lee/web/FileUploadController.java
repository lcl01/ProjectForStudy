package org.lee.web;


import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping(value = "/upload")
public class FileUploadController {

	
	@RequestMapping(value = "/toupload")
	public String upload(){
		return "uploads/fileUpload";
	}
	
	@RequestMapping(value = "/toTestupload")
	public String toTestUpload(){
		return "uploads/testUpload";
	}
	
	
	
	
	
	@RequestMapping(value = "/uploadFlie")
	public String uploadTest(@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session,HttpServletRequest req,
			ModelMap model) {
		model.addAttribute("message"," ");
		model.addAttribute("fileurl"," ");
		String path = session.getServletContext().getRealPath("/resources/uploadFile");
		String fileName = file.getOriginalFilename();
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
			model.addAttribute("message","uploads successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 String realPath = path.replaceAll("\\\\", "/");
			System.out.println(realPath);
			model.addAttribute("fileurl",realPath);
			model.addAttribute("message","Upload successful");
	
		return "uploads/result";
	}

}
