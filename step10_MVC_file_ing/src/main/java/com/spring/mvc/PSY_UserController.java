package com.spring.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.UserEmail;
import com.spring.service.PSY_UserService;

@Controller
public class PSY_UserController {
	
	@Autowired
	PSY_UserService userService;
	
	//http://localhost:8083/login2 (GET)
	@GetMapping(value = "/login2")
	public String loginForm() {
		return "login2";
	}
	
	//http://localhost:8083/login2 (POST)
	@PostMapping(value = "/login2")
	public String login(@RequestParam("email_address") String email_address,
						@RequestParam("password") String password,
						HttpSession session) {
		
		try {
			UserEmail user = userService.getUserByEmailaddressAndPassword(email_address, password);
			
			session.setAttribute("email_address", user.getEmail_address());
			session.setAttribute("mem_name", user.getMem_name());
			
			return "emailList2";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "login2";
	}
	
//	@GetMapping(value = "/logout")
//	public String logout(HttpSession session) {
//		
//		if(session != null) {
//			session.invalidate();
//		}
//		
//		return "redirect:/login2";
//	}
	
	//http://localhost:8083/signup (GET)
	@GetMapping(value = "/signup")
	public String signupForm() {
		return "psy-signup";
	}
	
	//http://localhost:8083/signup (POST)
	@PostMapping(value = "/signup")
	public String UserSignup(@ModelAttribute UserEmail newUser) {
		
		System.out.println(newUser + "님이 가입 시도");
		boolean result = false;
		
		try {
			result = userService.insertUser(newUser);
			if(result) {
				return "/resultView/success";
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return "/resultView/fail";
	}	
	
	
	
	
	
	
}
