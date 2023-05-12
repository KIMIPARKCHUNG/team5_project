package com.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Email;
import com.spring.dto.EmailFile;
import com.spring.service.LJH_EmailService;
import com.spring.service.LJH_FileService;

@Controller
public class LJH_EmailController {
	@Autowired
	LJH_EmailService emailService;
	
	@Autowired
	LJH_FileService fileServie;
	
	
	@RequestMapping(value = "/emailList2", method = RequestMethod.GET)
	public String emailList(Model model) {
		List<Email> emailList = emailService.getAllEmail();
		
		model.addAttribute("emailList", emailList);
		return "emailList2";
	}
	
	@RequestMapping(value = "/emailRead3/{emailId}", method=RequestMethod.GET)
	public String getEmailbyEmailId(@PathVariable int emailId, Model model) {
		Email email = emailService.getEmailbyEmailId(emailId);
		emailService.updateIsRead(emailId);
		
//		List<EmailFile> fileList = fileServie.getFilebyEmailId(emailId);
		model.addAttribute("email", email);
		return "emailRead3";
	}

}
