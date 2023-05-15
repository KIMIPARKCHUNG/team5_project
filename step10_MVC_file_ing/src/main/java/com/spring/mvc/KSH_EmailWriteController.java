package com.spring.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.Dept;
import com.spring.dto.Email;
import com.spring.dto.EmailFile;
import com.spring.service.KSH_AttachmentFileService;
import com.spring.service.KSH_EmailWriteService;
import com.spring.service.LJH_EmailService;
import com.spring.service.LJH_FileService;

@Controller
public class KSH_EmailWriteController {
	@RequestMapping(value = "/emailWriteList", method = RequestMethod.GET)
	public String emailList() {
		return "emailWriteList";
	}
	
	@Autowired
	LJH_EmailService emailService;
	
	@Autowired
	KSH_EmailWriteService emailWriteService;
	
	@Autowired
	LJH_FileService fileService;
	
	@Autowired
	KSH_AttachmentFileService attachmentFileService;
	
	@RequestMapping(value = "/emailWrite", method = RequestMethod.GET)
	public String insertDeptForm() {
		return "emailWrite";
	}
	
	@RequestMapping(value = "/emailWrite", method = RequestMethod.POST)
	public String insertEmail(@ModelAttribute Email newEmail,
	                          @RequestParam(value = "file") MultipartFile file,
	                          Model model,
	                          HttpSession session) {
	String view = "error";
	String email_address = (String) session.getAttribute("email_address");
	newEmail.setSender_id(email_address);
	//	boolean fileResult = false;
		boolean emailResult = false;
		try {
			emailResult = emailWriteService.insertEmail(newEmail);
		//	fileResult = attachmentFileService.insertAttachmentFile(file, newEmail.getEmail_id());
		 if(emailResult) {
				// version 1
////			view = "main";
////			model.addAttribute("deptList", service.getAllDepts());
//			
			// version2 
			view = "redirect:/emailList2";
			return view;
		 }
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}
}

