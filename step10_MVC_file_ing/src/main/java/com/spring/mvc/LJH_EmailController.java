package com.spring.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.Email;
import com.spring.dto.EmailFile;
import com.spring.service.EmailFileService;
import com.spring.service.LJH_EmailService;
import com.spring.service.LJH_FileService;

@Controller
public class LJH_EmailController {
	@Autowired
	LJH_EmailService emailService;
	
	@Autowired
	EmailFileService fileServie;
	
	
	@RequestMapping(value = "/emailList2", method = RequestMethod.GET)
	public String emailList(Model model, HttpSession session) {
		if(session.getAttribute("email_address")==null) {
			return "login2";
		}
		
		String email_address =  (String) session.getAttribute("email_address");
		System.out.println(email_address);
		
		List<Email> emailList = emailService.getAllEmail(email_address);
		int isReadCount = 0;
		
		for(int i=0; i<emailList.size(); i++) {
			if(emailList.get(i).getIs_read()=='F') {
				isReadCount++;
			}
		}
		
		model.addAttribute("isReadCount", isReadCount);

		model.addAttribute("emailList", emailList);
		
		
		return "emailList2";
	}
	
	@RequestMapping(value = "/emailRead3/{emailId}", method=RequestMethod.GET)
	public String getEmailbyEmailId(@PathVariable int emailId, Model model, HttpSession session) {
		if(session.getAttribute("email_address")==null) {
			return "login2";
		}
		String email_address = (String) session.getAttribute("email_address");
		
		Email email = emailService.getEmailbyEmailId(emailId, email_address);
		if(email==null) {
			return "redirect:/emailList2";
		}
		
		emailService.updateIsRead(emailId);
		int fileCount = 0;
		int fileTotalSize = 0;
		
	
	
	
//		model.addAttribute("length",fileList.size());

		List<EmailFile> fileList = null;
		try {
			fileList = fileServie.getEmailFileByEmailId(emailId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fileList != null) {
			for(int i=0; i<fileList.size(); i++) {
				fileCount++;
				fileTotalSize += fileList.get(i).getFile_size();
			}
			
			model.addAttribute("fileList", fileList);
			model.addAttribute("fileCount", fileCount);
			model.addAttribute("fileTotalSize", fileTotalSize);
		}
		model.addAttribute("email", email);
		return "emailRead3";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteEmailByEmailId(@RequestParam(value="deleteCheck", required=false) List<String> checkEmailId) {
		if(checkEmailId==null) {
			return "redirect:/emailList2";
		}
		for(int i=0; i<checkEmailId.size(); i++) {
			emailService.deleteEmailByEmailId(Integer.parseInt(checkEmailId.get(i)));
		}
		return "redirect:/emailList2";
	}
	
	@RequestMapping(value = "/deleteList", method = RequestMethod.GET)
	public String deleteList(Model model, HttpSession session) {
		if(session.getAttribute("email_address") == null) {
			return "login2";
		}
		
		String email_address = (String) session.getAttribute("email_address");
		
		List<Email> emailList = emailService.getAllDeleteEmail(email_address);
		
		model.addAttribute("emailList", emailList);
		return "deleteList";
	}

}
