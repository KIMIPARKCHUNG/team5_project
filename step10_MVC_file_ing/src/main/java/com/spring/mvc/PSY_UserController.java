package com.spring.mvc;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.UserEmail;
import com.spring.service.PSY_UserService;

@Controller
public class PSY_UserController {
	
	@Autowired
	PSY_UserService userService;
	
	//http://localhost:8083/login2 (GET) : 로그인 창 출력 메소드
	@GetMapping(value = "/login2")
	public String loginForm() {
		return "login2";
	}
	
	//http://localhost:8083/login2 (POST) : 로그인 메소드
	@PostMapping(value = "/login2")
	public String login(@RequestParam("email_address") String email_address,
						@RequestParam("password") String password,
						HttpSession session) {
		System.out.println(email_address);
		System.out.println(password);
		
		try {
			UserEmail user = userService.getUserByEmailaddressAndPassword(email_address, password);
			if(user != null) {
				session.setAttribute("email_address", email_address);
				return "redirect:/emailList2";
			}
			System.out.println(user);				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login2";
	}
	
//	//http://localhost:8083/logout (GET) : 로그아웃 메소드
//	@GetMapping(value = "/logout")
//	public String logout(HttpSession session) {
//		
//		if(session != null) {
//			session.invalidate();
//		}
//		
//		return "redirect:/login2";
//	}
	
	
	
	//http://localhost:8083/signup (GET) : 회원가입 창 출력 메소드
	@GetMapping(value = "/signup")
	public String signupForm() {
		return "psy-signup";
	}
	
	//http://localhost:8083/signup (POST) : 회원가입 메소드
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
	
	
	//http://localhost:8083/user/email_address (GET) : 유저 객체 돌려받는 메소드
	@GetMapping(value = "user/{email_address}")
	public UserEmail getUserByEmailaddress(@PathVariable String email_address) throws SQLException, Exception {
		System.out.println("유저 객체 돌려받기" + email_address);
		UserEmail user = null;
		user = userService.getUserByEmailaddress(email_address);
		System.out.println(user);
		
		return user;
	
	
	}
}
