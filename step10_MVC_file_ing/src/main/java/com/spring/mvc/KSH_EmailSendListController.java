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
import com.spring.service.KSH_EmailSendListService;
import com.spring.service.LJH_EmailService;
import com.spring.service.LJH_FileService;

@Controller
public class KSH_EmailSendListController {
	@Autowired
	KSH_EmailSendListService emailService;
	
	@Autowired
	EmailFileService fileServie;
	
	
	@RequestMapping(value = "/emailSendList", method = RequestMethod.GET)
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
		
		
		return "emailSendList";
	}
	
	/*
	 * @RequestMapping(value = "/emailRead3/{emailId}", method = RequestMethod.GET)
	 * public String getEmailbyEmailId(@PathVariable int emailId, Model model,
	 * HttpSession session) { if (session.getAttribute("email_address") == null) {
	 * return "login2"; } String email_address = (String)
	 * session.getAttribute("email_address");
	 * 
	 * Email email = emailService.getEmailbyEmailId(emailId, email_address); if
	 * (email == null) { return "redirect:/emailSendList"; }
	 * 
	 * // 모델에 email 객체를 추가하고, 해당하는 view를 반환합니다. model.addAttribute("email", email);
	 * return "emailRead3"; }
	 */
}
